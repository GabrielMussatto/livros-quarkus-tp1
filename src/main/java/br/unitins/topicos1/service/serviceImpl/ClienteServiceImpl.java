package br.unitins.topicos1.service.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.AlterarEmailDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarUsernameDTO;
import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.SugestaoDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.Response.ClienteResponseDTO;
import br.unitins.topicos1.dto.Response.FornecedorResponseDTO;
import br.unitins.topicos1.dto.Response.ItemFavoritoResponseDTO;
import br.unitins.topicos1.dto.Response.SugestaoResponseDTO;
import br.unitins.topicos1.dto.Response.UsuarioResponseDTO;
import br.unitins.topicos1.model.Enum.Sexo;
import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.Pessoa.ItemFavorito;
import br.unitins.topicos1.model.Pessoa.Usuario;
import br.unitins.topicos1.model.caixa.CaixaLivro;
import br.unitins.topicos1.model.fornecedor.Fornecedor;
import br.unitins.topicos1.model.livro.Livro;
import br.unitins.topicos1.model.sugestao.Sugestao;
import br.unitins.topicos1.repository.CaixaLivroRepository;
import br.unitins.topicos1.repository.ItemFavoritoRepository;
import br.unitins.topicos1.repository.LivroRepository;
import br.unitins.topicos1.repository.SugestaoRepository;
import br.unitins.topicos1.repository.pessoa.ClienteRepository;
import br.unitins.topicos1.repository.pessoa.UsuarioRepository;
import br.unitins.topicos1.service.ClienteService;
import br.unitins.topicos1.service.hash.HashService;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Inject
    public LivroRepository livroRepository;

    @Inject
    public CaixaLivroRepository caixaLivroRepository;

    @Inject
    public ItemFavoritoRepository itemFavoritoRepository;

    @Inject
    public HashService hashService;

    @Inject
    private JsonWebToken tokenJwt;

    @Inject
    private SugestaoRepository sugestaoRepository;

    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto) {
        validarCpfCliente(dto.cpf());
        validarEmailCliente(dto.email());

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

        Cliente cliente = new Cliente();
        cliente.setEndereco(dto.endereco());
        cliente.setCep(dto.cep());
        cliente.setCidade(dto.cidade());
        cliente.setEstado(dto.estado());
        cliente.setSigla(dto.sigla());
        cliente.setUsuario(usuario);

        clienteRepository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto) {
        validarCpfCliente(dto.cpf());
        Cliente clienteBanco = clienteRepository.findById(id);

        if (clienteBanco == null) {
            throw new ValidationException("Update cliente",
                    "Cliente não encontrado - Executando ClienteServiceImpl_update");
        }

        clienteBanco.setEndereco(dto.endereco());
        clienteBanco.setCep(dto.cep());
        clienteBanco.setCidade(dto.cidade());
        clienteBanco.setEstado(dto.estado());
        clienteBanco.setSigla(dto.sigla());

        Usuario usuario = clienteBanco.getUsuario();
        usuario.setNome(dto.nome());
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));
        usuario.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

        usuarioRepository.persist(usuario);
        clienteRepository.persist(clienteBanco);
    }

    @Override
    @Transactional
    public void delete(Long id) throws IllegalArgumentException, NotFoundException {
        if (id == null) {
            throw new IllegalArgumentException("Id inválido");
        }

        Cliente cliente = clienteRepository.findById(id);

        if (cliente == null) {
            throw new NotFoundException("Cliente não encontrado - Executando ClienteServiceImpl_delete");
        }

        clienteRepository.delete(cliente);
    }

    @Override
    public ClienteResponseDTO findById(Long id) throws NotFoundException {
        Cliente cliente = clienteRepository.findById(id);

        if (cliente == null) {
            throw new NotFoundException("Cliente não encontrado - Executando ClienteServiceImpl_findById");
        }
        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    public List<ClienteResponseDTO> findAll(int page, int pageSize) {
        List<Cliente> listCliente = clienteRepository
                .findAll()
                .page(page, pageSize)
                .list();
        return listCliente
                .stream()
                .map(ClienteResponseDTO::valueOf)
                .toList();
    }

    @Override
    public List<ClienteResponseDTO> findByEstado(String estado) {
        List<Cliente> listCliente = clienteRepository.findByEstado(estado).list();
        return listCliente.stream().map(ClienteResponseDTO::valueOf).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByCpf(String cpf) {
        List<Cliente> listCliente = clienteRepository.findByCpf(cpf).list();
        return listCliente.stream().map(ClienteResponseDTO::valueOf).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome) {
        List<Cliente> listCliente = clienteRepository.findByNome(nome).list();
        return listCliente.stream().map(ClienteResponseDTO::valueOf).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByEstado(int page, int pageSize, String estado) {
        List<Cliente> listCliente = clienteRepository.findByEstado(estado).page(page, pageSize).list();
        return listCliente.stream().map(ClienteResponseDTO::valueOf).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByCpf(int page, int pageSize, String cpf) {
        List<Cliente> listCliente = clienteRepository.findByCpf(cpf).page(page, pageSize).list();
        return listCliente.stream().map(ClienteResponseDTO::valueOf).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByNome(int page, int pageSize, String nome) {
        List<Cliente> listCliente = clienteRepository.findByNome(nome).page(page, pageSize).list();
        return listCliente.stream().map(ClienteResponseDTO::valueOf).toList();
    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);
        if (cliente == null) {
            throw new NullPointerException("cliente não encontrado - Executando ClienteServiceImpl_login");
        }
        return UsuarioResponseDTO.valueOf(cliente.getUsuario());
    }

    public void validarCpfCliente(String cpf) {
        Usuario cliente = usuarioRepository.findByCpfUsuario(cpf);
        if (cliente != null) {
            throw new ValidationException("cpf",
                    "O CPF: '" + cpf + "' já existe. - Executando ClienteServiceImpl_validarCpfCliente");
        }
    }

    public void validarEmailCliente(String email) {
        Usuario cliente = usuarioRepository.findByEmailUsuario(email);
        if (cliente != null) {
            throw new ValidationException("email",
                    "O Email: '" + email + "' já existe. - Executando ClienteServiceImpl_validarEmailCliente");
        }
    }

    @Override
    @Transactional
    public void alterarSenha(AlterarSenhaDTO dto) {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());

        if (cliente == null || !hashService.verificandoHash(dto.senhaAntiga(), cliente.getUsuario().getSenha())) {
            throw new ValidationException("senhaAntiga",
                    "Senha antiga não confere - Executando ClienteServiceImpl_alterarSenha");
        }

        cliente.getUsuario().setSenha(hashService.getHashSenha(dto.novaSenha()));
        usuarioRepository.persist(cliente.getUsuario());
    }

    @Override
    @Transactional
    public void alterarUsername(AlterarUsernameDTO dto) {

        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());

        if (cliente == null || !hashService.verificandoHash(dto.senha(), cliente.getUsuario().getSenha())) {
            throw new ValidationException("senhaAntiga",
                    "Senha incorreta - Executando ClienteServiceImpl_alterarUsername");
        }

        cliente.getUsuario().setUsername(dto.usernameNovo());
        usuarioRepository.persist(cliente.getUsuario());
    }

    @Override
    @Transactional
    public void alterarEmail(AlterarEmailDTO dto) {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());

        if (cliente == null || !hashService.verificandoHash(dto.senha(), cliente.getUsuario().getSenha())) {
            throw new ValidationException("senhaAntiga",
                    "Senha incorreta - Executando ClienteServiceImpl_alterarEmail");
        }

        cliente.getUsuario().setEmail(dto.emailNovo());
        usuarioRepository.persist(cliente.getUsuario());
    }

    @Override
    @Transactional
    public ClienteResponseDTO findMeuPerfil() {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());

        if (cliente == null) {
            throw new ValidationException("Perfil",
                    "Cliente não encontrado - Executando ClienteServiceImpl_findMeuPerfil");
        }
        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void adicionarItemFavorito(Long idLivro, Long idCaixaLivro) {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());

        if (cliente == null) {
            throw new ValidationException("cliente", "Cliente não encontrado. Verifique os dados e tente novamente.");
        }

        ItemFavorito itemFavorito = new ItemFavorito();
        itemFavorito.setCliente(cliente);

        if (idLivro != null) {
            Livro livro = livroRepository.findById(idLivro);
            if (livro == null) {
                throw new NotFoundException("O livro não foi encontrado. Tente novamente");
            }
            itemFavorito.setLivro(livro);
        } else if (idCaixaLivro != null){
            CaixaLivro caixaLivro = caixaLivroRepository.findById(idCaixaLivro);
            if (caixaLivro == null) {
                throw new NotFoundException("A caixa de livros não foi encontrada. Tente novamente");
            }
            itemFavorito.setCaixaLivro(caixaLivro);
        } else {
            throw new ValidationException("itemFavorito", "É necessário informar um id de Livro ou CaixaLivro");
        }
        itemFavoritoRepository.persist(itemFavorito);
    }

    @Override
    @Transactional
    public void removerItemFavorito(Long idItem) {
        ItemFavorito item = itemFavoritoRepository.findById(idItem);
        if (item == null) {
            throw new NotFoundException("Item não encontrado");
        }
        itemFavoritoRepository.delete(item);
    }

    @Override
    public List<ItemFavoritoResponseDTO> findMeusFavoritos(){
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));
        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());
        if (cliente == null) {
            throw new ValidationException("cliente", "Cliente não encontrado. Verifique os dados e tente novamente.");
        }
        return cliente.getListaFavorito().stream().map(ItemFavoritoResponseDTO::valueOf).toList();
    }

    @Override
    @Transactional
    public SugestaoResponseDTO adicionarSugestao(@Valid SugestaoDTO sugestaoDTO) {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));
        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());
        if (cliente == null) {
            throw new ValidationException("cliente", "Cliente não encontrado. Verifique os dados e tente novamente.");
        }

        Sugestao sugestao = new Sugestao();
        sugestao.setSugestao(sugestaoDTO.sugestao());
        sugestao.setDataSugestao(LocalDate.now());
        sugestao.setCliente(cliente);

        sugestaoRepository.persist(sugestao);
        return SugestaoResponseDTO.valueOf(sugestao);
    }

    @Override
    public List<SugestaoResponseDTO> findMinhasSugestoes() {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));
        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());
        if (cliente == null) {
            throw new ValidationException("cliente", "Cliente não encontrado. Verifique os dados e tente novamente.");
        }

        return cliente.getListaSugestao().stream().map(SugestaoResponseDTO::valueOf).toList();
    }

    @Override
    public long count() {
        return clienteRepository.count();
    }

    @Override
    public long countByNome(String nome){
        return clienteRepository.findByNome(nome).count();
    }

    @Override
    public long countByCpf(String cpf){
        return usuarioRepository.findByCpf(cpf).count();
    }

    @Override
    public long countByEstado(String estado){
        return clienteRepository.findByEstado(estado).count();
    }
}
