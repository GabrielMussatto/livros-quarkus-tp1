package br.unitins.topicos1.service.serviceImpl;

import br.unitins.topicos1.dto.CadastroBasicoDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.Response.CadastroBasicoResponseDTO;
import br.unitins.topicos1.dto.Response.ClienteResponseDTO;
import br.unitins.topicos1.model.Enum.Sexo;
import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.Pessoa.Usuario;
import br.unitins.topicos1.repository.pessoa.ClienteRepository;
import br.unitins.topicos1.repository.pessoa.UsuarioRepository;
import br.unitins.topicos1.service.CadastroBasicoService;
import br.unitins.topicos1.service.hash.HashService;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CadastroBasicoServiceImpl implements CadastroBasicoService {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    HashService hashService;

    @Override
    @Transactional
    public CadastroBasicoResponseDTO create(@Valid CadastroBasicoDTO dto) {
        Cliente cliente = new Cliente();
        Usuario usuario = new Usuario();
        
        validarEmailCliente(dto.email());

        usuario.setNome(dto.nome());
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));
        usuario.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

        usuarioRepository.persist(usuario);

        cliente.setEndereco(dto.endereco());
        cliente.setCep(dto.cep());
        cliente.setCidade(dto.cidade());
        cliente.setEstado(dto.estado());
        cliente.setSigla(dto.sigla());
        cliente.setUsuario(usuario);

        clienteRepository.persist(cliente);
        return CadastroBasicoResponseDTO.valueOf(cliente);
    }   

    public void validarEmailCliente(String email){
        Usuario cliente = usuarioRepository.findByEmailUsuario(email);
        if (cliente != null) {
            throw new ValidationException("email", "O Email: '" + email + "' já existe. - Executando ClienteServiceImpl_validarEmailCliente");
        }
    }
    
}
