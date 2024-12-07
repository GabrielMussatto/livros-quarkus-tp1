package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CaixaLivroDTO;
import br.unitins.topicos1.dto.Response.CaixaLivroResponseDTO;
import jakarta.validation.Valid;

public interface CaixaLivroService {

    public CaixaLivroResponseDTO create(@Valid CaixaLivroDTO dto);
    public void update(Long id, CaixaLivroDTO dto);
    public void delete(Long id);
    public CaixaLivroResponseDTO findById(Long id);
    public List<CaixaLivroResponseDTO> findAll(int page, int pageSize);
    public List<CaixaLivroResponseDTO> findByNome(String nome);
    public List<CaixaLivroResponseDTO> findByDescricao(String descricao);
    public List<CaixaLivroResponseDTO> findByAutor(String autor);
    public List<CaixaLivroResponseDTO> findByGenero(String genero);

    public List<CaixaLivroResponseDTO> findByNome(int page, int pageSize, String nome);
    public List<CaixaLivroResponseDTO> findByDescricao(int page, int pageSize, String descricao);
    public List<CaixaLivroResponseDTO> findByAutor(int page, int pageSize, String autor);
    public List<CaixaLivroResponseDTO> findByGenero(int page, int pageSize, String genero);
    public long count();
    public long countByNome(String nome);
    public long countByAutor (String autor);
    public long countByGenero (String genero);

    public List<CaixaLivroResponseDTO> findWithFilters(List<Long> autores, List<Long> editoras, List<Long> generos);
    
    CaixaLivroResponseDTO salveImage(Long id, String nomeImagem);
}
