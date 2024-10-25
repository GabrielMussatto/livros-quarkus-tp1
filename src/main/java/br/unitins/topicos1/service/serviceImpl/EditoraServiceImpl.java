package br.unitins.topicos1.service.serviceImpl;

import java.util.List;

import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.Response.EditoraResponseDTO;
import br.unitins.topicos1.model.editora.Editora;
import br.unitins.topicos1.model.telefone.Telefone;
import br.unitins.topicos1.repository.EditoraRepository;
import br.unitins.topicos1.service.EditoraService;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class EditoraServiceImpl implements EditoraService {

    @Inject
    public EditoraRepository editoraRepository;

    @Override
    @Transactional
    public EditoraResponseDTO create(@Valid EditoraDTO dto) {
        validarNomeEditora(dto.nome());

        Editora editora = new Editora();
        editora.setNome(dto.nome());
        editora.setEmail(dto.email());
        editora.setEndereco(dto.endereco());
        editora.setEstado(dto.estado());
        editora.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

        editoraRepository.persist(editora);
        return EditoraResponseDTO.valueOf(editora);
    }

    public void validarNomeEditora(String nome) {
        Editora editora = editoraRepository.findByNomeEditora(nome);
        if (editora != null)
            throw new ValidationException("nome", "O editora '" + nome + "' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, EditoraDTO dto) {
        Editora editoraBanco = editoraRepository.findById(id);

        if (editoraBanco != null) {
            editoraBanco.setNome(dto.nome());
            editoraBanco.setEmail(dto.email());
            editoraBanco.setEndereco(dto.endereco());
            editoraBanco.setEstado(dto.estado());

            Telefone telefone = editoraBanco.getTelefone();
            telefone.setCodigoArea(dto.telefone().codigoArea());
            telefone.setNumero(dto.telefone().numero());
        } else {
            throw new ValidationException("id", "Editora não encontrado.");
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (id == null)
            throw new ValidationException("id", "Editora não encontrado.");

        editoraRepository.deleteById(id);
    }

    @Override
    public EditoraResponseDTO findById(Long id) {
        return EditoraResponseDTO.valueOf(editoraRepository.findById(id));
    }

    @Override
    public List<EditoraResponseDTO> findAll(int page, int pageSize) {
        List<Editora> listEditora = editoraRepository
                                        .findAll()
                                        .page(page, pageSize)
                                        .list();
        return listEditora
                .stream()
                .map(editoras -> EditoraResponseDTO.valueOf(editoras))
                .toList();
    }

    @Override
    public List<EditoraResponseDTO> findByNome(String nome) {
        List<Editora> listEditora = editoraRepository
                                        .findByNome(nome)
                                        .list();
        return listEditora
                .stream()
                .map(editoras -> EditoraResponseDTO.valueOf(editoras))
                .toList();
    }

    @Override
    public List<EditoraResponseDTO> findByEstado(String estado) {
        List<Editora> listEditora = editoraRepository
                                        .findByEstado(estado)
                                        .list();
        return listEditora
                .stream()
                .map(editoras -> EditoraResponseDTO.valueOf(editoras))
                .toList();
    }

    @Override
    public List<EditoraResponseDTO> findByNome(int page, int pageSize, String nome) {
        List<Editora> listEditora = editoraRepository
                                        .findByNome(nome)
                                        .page(page, pageSize)
                                        .list();
        return listEditora
                .stream()
                .map(editoras -> EditoraResponseDTO.valueOf(editoras))
                .toList();
    }

    @Override
    public List<EditoraResponseDTO> findByEstado(int page, int pageSize, String estado) {
        List<Editora> listEditora = editoraRepository
                                        .findByEstado(estado)
                                        .page(page, pageSize)
                                        .list();
        return listEditora
                .stream()
                .map(editoras -> EditoraResponseDTO.valueOf(editoras))
                .toList();
    }

    @Override
    public long count() {
        return editoraRepository.count();
    }

    @Override
    public long countByNome(String nome){
        return editoraRepository.findByNome(nome).count();
    }
}
