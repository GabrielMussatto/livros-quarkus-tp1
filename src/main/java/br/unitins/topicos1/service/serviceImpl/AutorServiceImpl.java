package br.unitins.topicos1.service.serviceImpl;

import java.util.List;

import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.dto.Response.AutorResponseDTO;
import br.unitins.topicos1.model.autor.Autor;
import br.unitins.topicos1.repository.AutorRepository;
import br.unitins.topicos1.service.AutorService;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class AutorServiceImpl implements AutorService{

    @Inject
    public AutorRepository autorRepository;

    @Override
    @Transactional
    public AutorResponseDTO create(@Valid AutorDTO dto){
        validarNomeCompletoAutor(dto.nome());

        Autor autor = new Autor();
        autor.setNome(dto.nome());
        autor.setBiografia(dto.biografia());

        autorRepository.persist(autor);
        return AutorResponseDTO.valueOf(autor);
    }

    public void validarNomeCompletoAutor(String nome) {
        Autor autor = autorRepository.findByNomeCompleto(nome);
        if (autor != null)
            throw  new ValidationException("nome", "O nome "+nome+" já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, AutorDTO dto){
        Autor autorBanco = autorRepository.findById(id);

        if(autorBanco == null){
            throw new ValidationException("id", "O autor não existe.");
        }

        autorBanco.setNome(dto.nome());
        autorBanco.setBiografia(dto.biografia());
    }

    @Override
    @Transactional
    public void delete(Long id){
        if (id == null) {
            throw new ValidationException("id", "Nenhum autor encontrado");
        }
        autorRepository.deleteById(id);
    }

    @Override
    public AutorResponseDTO findById(Long id){
        if (id == null) {
            throw new ValidationException("id", "Nenhum autor encontrado");
        }
        return AutorResponseDTO.valueOf(autorRepository.findById(id));
    }

    @Override
    public List<AutorResponseDTO> findAll(int page, int pageSize){
        List<Autor> listAutor = autorRepository
                                    .findAll()
                                    .page(page, pageSize)
                                    .list();

        return listAutor
                .stream()
                .map(autor -> AutorResponseDTO.valueOf(autor))
                .toList();
    }

    @Override
    public List<AutorResponseDTO> findByNome(String nome){
        if (nome == null) {
            throw new ValidationException("nome", "Nenhum autor encontrado");            
        }
        List<Autor> listAutor = autorRepository
                                    .findByNome(nome)
                                    .list();

        return listAutor
                .stream()
                .map(autor -> AutorResponseDTO.valueOf(autor))
                .toList(); 
    }

    @Override
    public List<AutorResponseDTO> findByNome(int page, int pageSize, String nome){
        if (nome == null) {
            throw new ValidationException("nome", "Nenhum autor encontrado");            
        }

        List<Autor> listAutor = autorRepository
                                    .findByNome(nome)
                                    .page(page, pageSize)
                                    .list();

        return listAutor
                .stream()
                .map(autor -> AutorResponseDTO.valueOf(autor))
                .toList();    
    }

    @Override
    public List<AutorResponseDTO> findByBiografia(String biografia){
        if (biografia == null) {
            throw new ValidationException("biografia", "Nenhuma biografia encontrada");
        }
        List<Autor> listAutor = autorRepository
                                    .findByBiografia(biografia)
                                    .list();

        return listAutor
                .stream()
                .map(autor -> AutorResponseDTO.valueOf(autor))
                .toList(); 
    }

    @Override
    public List<AutorResponseDTO> findByBiografia(int page, int pageSize, String biografia){
        if (biografia == null) {
            throw new ValidationException("biografia", "Nenhuma biografia encontrada");
        }

        List<Autor> listAutor = autorRepository
                                    .findByBiografia(biografia)
                                    .page(page, pageSize)
                                    .list();

        return listAutor
                .stream()
                .map(autor -> AutorResponseDTO.valueOf(autor))
                .toList(); 
    }

    @Override
    public long count(){
        return autorRepository.count();
    }

    @Override
    public long countByNome(String nome){
        return autorRepository.findByNome(nome).count();
    }
}
