package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.AlterarEmailDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarUsernameDTO;
import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.SugestaoDTO;
import br.unitins.topicos1.dto.Response.ClienteResponseDTO;
import br.unitins.topicos1.dto.Response.ItemFavoritoResponseDTO;
import br.unitins.topicos1.dto.Response.SugestaoResponseDTO;
import br.unitins.topicos1.dto.Response.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface ClienteService {
    public ClienteResponseDTO create(@Valid ClienteDTO dto);
    public void update(Long id, ClienteDTO dto);
    public void delete(Long id);
    public ClienteResponseDTO findById(Long id);
    public List<ClienteResponseDTO> findAll(int page, int pageSize);
    public List<ClienteResponseDTO> findByEstado(String estado);
    public List<UsuarioResponseDTO> findByCpf(String cpf);
    public List<UsuarioResponseDTO> findByNome(String nome);

    public List<ClienteResponseDTO> findByEstado(int page, int pageSize, String estado);
    public List<UsuarioResponseDTO> findByCpf(int page, int pageSize, String cpf);
    public List<UsuarioResponseDTO> findByNome(int page, int pageSize, String nome);

    public UsuarioResponseDTO login(String username, String senha);

    public void alterarSenha(AlterarSenhaDTO dto);
    public void alterarUsername(AlterarUsernameDTO dto);
    public void alterarEmail(AlterarEmailDTO dto);

    public ClienteResponseDTO findMeuPerfil();
    public void adicionarItemFavorito(Long idLivro, Long idCaixaLivro);
    public void removerItemFavorito(Long idItem);
    public List<ItemFavoritoResponseDTO> findMeusFavoritos();

    public SugestaoResponseDTO adicionarSugestao(@Valid SugestaoDTO sugestaoDTO);
    public List<SugestaoResponseDTO> findMinhasSugestoes();

    public long count();
    public long countByNome(String nome);
    public long countByCpf(String cpf);
    public long countByEstado(String estado);
}
