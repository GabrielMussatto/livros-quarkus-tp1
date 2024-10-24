package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.LivroDTO;
import br.unitins.topicos1.dto.Response.LivroResponseDTO;
import jakarta.validation.Valid;

public interface LivroService {

    public LivroResponseDTO create(@Valid LivroDTO dto);
    public void update(Long id, LivroDTO dto);
    public void delete(Long id);
    public LivroResponseDTO findById(Long id);
    public List<LivroResponseDTO> findAll(int page, int pageSize);
    public List<LivroResponseDTO> findByTitulo(String titulo);
    public List<LivroResponseDTO> findByIsbn(String isbn);
    public List<LivroResponseDTO> findByDescricao(String descricao);
    public List<LivroResponseDTO> findByAutor(String autor);

    public List<LivroResponseDTO> findByTitulo(int page, int pageSize, String titulo);
    public List<LivroResponseDTO> findByIsbn(int page, int pageSize, String isbn);
    public List<LivroResponseDTO> findByDescricao(int page, int pageSize, String descricao);
    public List<LivroResponseDTO> findByAutor(int page, int pageSize, String autor);
    public long count();
}
