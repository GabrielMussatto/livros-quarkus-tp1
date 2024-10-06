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
    public List<LivroResponseDTO> findAll();
    public List<LivroResponseDTO> findByTitulo(String titulo);
    public List<LivroResponseDTO> findByIsbn(String isbn);
    public List<LivroResponseDTO> findByDescricao(String descricao);
    public List<LivroResponseDTO> findByAutor(String autor);
}
