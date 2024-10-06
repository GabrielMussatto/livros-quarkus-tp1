package br.unitins.topicos1.service.serviceImpl;

import java.util.List;

import br.unitins.topicos1.dto.GeneroDTO;
import br.unitins.topicos1.dto.Response.GeneroResponseDTO;
import br.unitins.topicos1.model.genero.Genero;
import br.unitins.topicos1.repository.GeneroRepository;
import br.unitins.topicos1.service.GeneroService;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class GeneroServiceImpl implements GeneroService{

    @Inject
    public GeneroRepository generoRepository;

    @Override
    @Transactional
    public GeneroResponseDTO create(@Valid GeneroDTO dto){
        validarNomeGenero(dto.nome());

        Genero genero = new Genero();
        genero.setNome(dto.nome());
        genero.setDescricao(dto.descricao());
      

        generoRepository.persist(genero);
        return GeneroResponseDTO.valueOf(genero);
    }

    public void validarNomeGenero(String nome) {
        Genero genero = generoRepository.findByNomeGenero(nome);
        if (genero != null)
            throw  new ValidationException("nome", "O Genero '"+nome+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, GeneroDTO dto){
        Genero generoBanco = generoRepository.findById(id);

        generoBanco.setNome(dto.nome());
        generoBanco.setDescricao(dto.descricao());
    }

    @Override
    @Transactional
    public void delete(Long id){
        generoRepository.deleteById(id);
    }

    @Override
    public GeneroResponseDTO findById(Long id){
        return GeneroResponseDTO.valueOf(generoRepository.findById(id));
    }

    @Override
    public List<GeneroResponseDTO> findAll(){
        return generoRepository.listAll().stream().map(genero -> GeneroResponseDTO.valueOf(genero)).toList();
    }

    @Override
    public List<GeneroResponseDTO> findByNome(String nome) {
        return generoRepository.findByNome(nome).stream()
        .map(e -> GeneroResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<GeneroResponseDTO> findByDescricao(String descricao) {
        return generoRepository.findByDescricao(descricao).stream()
        .map(e -> GeneroResponseDTO.valueOf(e)).toList();
    }


}
