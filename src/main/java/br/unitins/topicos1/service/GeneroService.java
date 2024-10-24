package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.GeneroDTO;
import br.unitins.topicos1.dto.Response.GeneroResponseDTO;
import jakarta.validation.Valid;

public interface GeneroService {

    public GeneroResponseDTO create(@Valid GeneroDTO dto);
    public void update(Long id, GeneroDTO dto);
    public void delete(Long id);
    public GeneroResponseDTO findById(Long id);
    public List<GeneroResponseDTO> findAll(int page, int pageSize);
    public List<GeneroResponseDTO> findByNome(String nome);
    public List<GeneroResponseDTO> findByDescricao(String descricao);

    public List<GeneroResponseDTO> findByNome(int page, int pageSize, String nome);
    public List<GeneroResponseDTO> findByDescricao(int page, int pageSize, String descricao);
    public long count();

}
