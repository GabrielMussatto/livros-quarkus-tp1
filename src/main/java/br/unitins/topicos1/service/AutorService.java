package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.dto.Response.AutorResponseDTO;
import jakarta.validation.Valid;

public interface AutorService {

    public AutorResponseDTO create(@Valid AutorDTO dto);
    public void update(Long id, AutorDTO dto);
    public void delete(Long id);
    public AutorResponseDTO findById(Long id);
    public List<AutorResponseDTO> findByNome(String nome);
    public List<AutorResponseDTO> findByBiografia(String biografia);
    
    public List<AutorResponseDTO> findAll(int page, int pageSize);
    public List<AutorResponseDTO> findByNome(int page, int pageSize, String nome);
    public List<AutorResponseDTO> findByBiografia(int page, int pageSize, String biografia);
    public long count();
}
