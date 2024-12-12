package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.AlterarEmailDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarUsernameDTO;
import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.Response.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.Response.SugestaoResponseDTO;
import br.unitins.topicos1.dto.Response.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface FuncionarioService {
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto);
    public void update(Long id, FuncionarioDTO dto);
    public void delete(Long id);
    public FuncionarioResponseDTO findById(Long id);
    public List<FuncionarioResponseDTO> findAll(int page, int pageSize);
    public List<FuncionarioResponseDTO> findByCargo(String cargo);
    public List<UsuarioResponseDTO> findByCpf(String cpf);
    public List<UsuarioResponseDTO> findByNome(String nome);

    public List<FuncionarioResponseDTO> findByCargo(int page, int pageSize, String cargo);
    public List<UsuarioResponseDTO> findByCpf(int page, int pageSize, String cpf);
    public List<UsuarioResponseDTO> findByNome(int page, int pageSize, String nome);

    public UsuarioResponseDTO login(String username, String senha);  

    public void alterarSenha(AlterarSenhaDTO dto);
    public void alterarUsername(AlterarUsernameDTO dto);
    public void alterarEmail(AlterarEmailDTO dto);

    public FuncionarioResponseDTO findMeuPerfil();

    public List<SugestaoResponseDTO> findSugestoes();

    public long count();
    public long countByNome(String nome);
    public long countByCpf(String cpf);
    public long countByCargo(String cargo);
}