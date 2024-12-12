package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CupomDTO;
import br.unitins.topicos1.dto.Response.CupomResponseDTO;
import jakarta.validation.Valid;

public interface CupomService {
    
    public CupomResponseDTO create(@Valid CupomDTO dto);
    public void update(Long id, CupomDTO dto);
    public void delete(Long id);
    public CupomResponseDTO findById(Long id);
    public List<CupomResponseDTO> findAll(int page, int pageSize);
    public List<CupomResponseDTO> findByNomeCupom(String nomeCupom);

    public List<CupomResponseDTO> findByNomeCupom(int page, int pageSize, String nomeCupom);
    public long count();
    public long countByNomeCupom(String nomeCupom);
}
