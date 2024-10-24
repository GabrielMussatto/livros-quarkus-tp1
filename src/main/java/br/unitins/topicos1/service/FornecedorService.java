package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.dto.Response.FornecedorResponseDTO;
import jakarta.validation.Valid;

public interface FornecedorService {
    
   public FornecedorResponseDTO create(@Valid FornecedorDTO dto);
   public void update(Long id, FornecedorDTO dto);
   public void delete(Long id);
   public FornecedorResponseDTO findById(Long id);
   public List<FornecedorResponseDTO> findAll(int page, int pageSize);
   public List<FornecedorResponseDTO> findByNome(String nome);
   public List<FornecedorResponseDTO> findByCidade(String cidade);
   public List<FornecedorResponseDTO> findByEstado(String estado);
   public List<FornecedorResponseDTO> findByCnpj(String cnpj);
   
   public List<FornecedorResponseDTO> findByNome(int page, int pageSize, String nome);
   public List<FornecedorResponseDTO> findByCidade(int page, int pageSize, String cidade);
   public List<FornecedorResponseDTO> findByEstado(int page, int pageSize, String estado);
   public List<FornecedorResponseDTO> findByCnpj(int page, int pageSize, String cnpj);
   public long count();

}
