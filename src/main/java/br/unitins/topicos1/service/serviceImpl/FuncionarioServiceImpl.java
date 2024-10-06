package br.unitins.topicos1.service.serviceImpl;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.AlterarEmailDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarUsernameDTO;
import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.Response.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.Response.UsuarioResponseDTO;
import br.unitins.topicos1.model.Enum.Sexo;
import br.unitins.topicos1.model.Pessoa.Funcionario;
import br.unitins.topicos1.model.Pessoa.Usuario;
import br.unitins.topicos1.repository.pessoa.FuncionarioRepository;
import br.unitins.topicos1.repository.pessoa.UsuarioRepository;
import br.unitins.topicos1.service.FuncionarioService;
import br.unitins.topicos1.service.hash.HashService;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {

    @Inject
    public FuncionarioRepository funcionarioRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Inject
    private JsonWebToken tokenJwt;

    @Inject
    public HashService hashService;

    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto) {
        validarCpfFuncionario(dto.cpf());

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));
        usuario.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

        usuarioRepository.persist(usuario);

        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(dto.cargo());
        funcionario.setSalario(dto.salario());
        funcionario.setUsuario(usuario);

        funcionarioRepository.persist(funcionario);

        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    public void validarCpfFuncionario(String cpf) {
        Usuario funcionario = usuarioRepository.findByCpfUsuario(cpf);
        if (funcionario != null)
            throw new ValidationException("cpf", "O  CPF: '" + cpf + "' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, FuncionarioDTO dto) {
        Funcionario funcionarioBanco = funcionarioRepository.findById(id);
        
        if (funcionarioBanco == null) {
            throw new NotFoundException("Funcionário não encontrado");
        }

        funcionarioBanco.setCargo(dto.cargo());
        funcionarioBanco.setSalario(dto.salario());

        Usuario usuario = funcionarioBanco.getUsuario();
        usuario.setNome(dto.nome());
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));
        usuario.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

    }

    @Override
    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public FuncionarioResponseDTO findById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        if (funcionario == null) {
            throw new NotFoundException("Funcionário não encontrado");
        }

        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    @GET
    public List<FuncionarioResponseDTO> findAll() {
        return funcionarioRepository.listAll().stream().map(a -> FuncionarioResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<FuncionarioResponseDTO> findByCargo(String cargo) {
        return funcionarioRepository.findByCargo(cargo).stream()
                .map(funcionario -> FuncionarioResponseDTO.valueOf(funcionario)).toList();
    }

    @Override
    public List<UsuarioResponseDTO> findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf).stream().map(c -> UsuarioResponseDTO.valueOf(c)).toList();
    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Funcionario funcionario = funcionarioRepository.findByUsernameAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(funcionario.getUsuario());
    }

    @Override
    @Transactional
    public void alterarSenha(AlterarSenhaDTO dto) {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Funcionario funcionario = funcionarioRepository.findById(usuario.getId());

        if(funcionario == null || !hashService.verificandoHash(dto.senhaAntiga(), funcionario.getUsuario().getSenha())){
            throw new ValidationException("senhaAntiga", "Senha antiga não confere");
        }

        funcionario.getUsuario().setSenha(hashService.getHashSenha(dto.novaSenha()));
        usuarioRepository.persist(funcionario.getUsuario());
    }

    @Override
    @Transactional
    public void alterarUsername(AlterarUsernameDTO dto) {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Funcionario funcionario = funcionarioRepository.findById(usuario.getId());

        if (funcionario == null || !hashService.verificandoHash(dto.senha(), funcionario.getUsuario().getSenha())) {
            throw new ValidationException("senhaAntiga", "Senha incorreta");
        }

        funcionario.getUsuario().setUsername(dto.usernameNovo());
        usuarioRepository.persist(funcionario.getUsuario());
    }

    @Override
    @Transactional
    public void alterarEmail(AlterarEmailDTO dto) {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Funcionario funcionario = funcionarioRepository.findById(usuario.getId());

        if (funcionario == null || !hashService.verificandoHash(dto.senha(), funcionario.getUsuario().getSenha())) {
            throw new ValidationException("senhaAntiga", "Senha incorreta");
        }

        funcionario.getUsuario().setEmail(dto.emailNovo());
        usuarioRepository.persist(funcionario.getUsuario());
    }

    @Override
    @Transactional
    public FuncionarioResponseDTO findMeuPerfil() {
         Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

         Funcionario funcionario = funcionarioRepository.findById(usuario.getId());

        if (funcionario == null) {
            throw new ValidationException("Perfil","Cliente não encontrado");
        }
        return FuncionarioResponseDTO.valueOf(funcionario);
    }
}
