package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.AvaliacaoDTO;
import br.unitins.topicos1.dto.Response.AvaliacaoResponseDTO;
import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.livro.Livro;

public interface AvaliacaoService {

    public List<AvaliacaoResponseDTO> findAll(); 
    public AvaliacaoResponseDTO findById(Long id);
    public AvaliacaoResponseDTO create(AvaliacaoDTO avaliacaDTO);
    public AvaliacaoResponseDTO update(Long id, AvaliacaoDTO avaliacaDTO);

    public void delete(Long id);
    public void delete(Livro livro);
    public void delete(Cliente cliente);

    public List<AvaliacaoResponseDTO> getByIdLivro(Long idLivro);
    public List<AvaliacaoResponseDTO> getByNomeCliente(String nome);
}

