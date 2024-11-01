package br.unitins.topicos1.service.serviceImpl;

import java.util.List;

import br.unitins.topicos1.dto.CaixaLivroDTO;
import br.unitins.topicos1.dto.Response.CaixaLivroResponseDTO;
import br.unitins.topicos1.model.Enum.Classificacao;
import br.unitins.topicos1.model.caixa.CaixaLivro;
import br.unitins.topicos1.repository.AutorRepository;
import br.unitins.topicos1.repository.CaixaLivroRepository;
import br.unitins.topicos1.repository.EditoraRepository;
import br.unitins.topicos1.repository.FornecedorRepository;
import br.unitins.topicos1.repository.GeneroRepository;
import br.unitins.topicos1.service.CaixaLivroService;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CaixaLivroServiceImpl implements CaixaLivroService {

    @Inject
    public AutorRepository autorRepository;

    @Inject
    public EditoraRepository editoraRepository;

    @Inject
    public FornecedorRepository fornecedorRepository;

    @Inject
    public GeneroRepository generoRepository;

    @Inject
    public CaixaLivroRepository caixaLivroRepository;

    @Override
    @Transactional
    public CaixaLivroResponseDTO create(@Valid CaixaLivroDTO dto) {
        validarNomeCaixaLivro(dto.nome());

        CaixaLivro caixaLivro = new CaixaLivro();
        caixaLivro.setNome(dto.nome());
        caixaLivro.setDescricao(dto.descricao());
        caixaLivro.setFornecedor(fornecedorRepository.findById(dto.fornecedor()));
        caixaLivro.setEditora(editoraRepository.findById(dto.editora()));
        caixaLivro.setListaAutores((dto.autores()).stream().map(a -> autorRepository.findById(a)).toList());
        caixaLivro.setListaGeneros((dto.generos()).stream().map(g -> generoRepository.findById(g)).toList());
        caixaLivro.setPreco(dto.preco());
        caixaLivro.setQuantidadeEstoque(dto.quantidadeEstoque());
        caixaLivro.setClassificacao(Classificacao.valueOf(dto.classificacao()));

        caixaLivroRepository.persist(caixaLivro);
        return CaixaLivroResponseDTO.valueOf(caixaLivro);
    }

    public void validarNomeCaixaLivro(String nome) {
        CaixaLivro caixaLivro = caixaLivroRepository.findByNomeCaixaLivro(nome);
        if (caixaLivro != null) {
            throw new ValidationException("nome", "O nome '" + nome + "' de Caixa de Livro já existe");
        }
    }

    @Override
    @Transactional
    public void update(Long id, CaixaLivroDTO dto) {
        CaixaLivro caixaLivroBanco = caixaLivroRepository.findById(id);
        if (caixaLivroBanco == null)
            throw new ValidationException("id", "Caixa de livro não encontrada");

        caixaLivroBanco.setNome(dto.nome());
        caixaLivroBanco.setDescricao(dto.descricao());
        caixaLivroBanco.setFornecedor(fornecedorRepository.findById(dto.fornecedor()));
        caixaLivroBanco.setEditora(editoraRepository.findById(dto.editora()));
        caixaLivroBanco.setListaAutores((dto.autores()).stream().map(a -> autorRepository.findById(a)).toList());
        caixaLivroBanco.setListaGeneros((dto.generos()).stream().map(g -> generoRepository.findById(g)).toList());
        caixaLivroBanco.setPreco(dto.preco());
        caixaLivroBanco.setQuantidadeEstoque(dto.quantidadeEstoque());
        caixaLivroBanco.setClassificacao(Classificacao.valueOf(dto.classificacao()));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (id == null)
            throw new ValidationException("id", "Id não pode ser nulo.");

        caixaLivroRepository.deleteById(id);
    }

    @Override
    public CaixaLivroResponseDTO findById(Long id) {
        return CaixaLivroResponseDTO.valueOf(caixaLivroRepository.findById(id));
    }

    @Override
    public List<CaixaLivroResponseDTO> findAll(int page, int pageSize) {
        List<CaixaLivro> listCaixaLivro = caixaLivroRepository
                                            .findAll()
                                            .page(page, pageSize)
                                            .list();
        return listCaixaLivro
                .stream()
                .map(cl -> CaixaLivroResponseDTO.valueOf(cl))
                .toList();
    }

    @Override
    public List<CaixaLivroResponseDTO> findByNome(String nome) {
        List<CaixaLivro> listCaixaLivro = caixaLivroRepository
                                            .findByNome(nome)
                                            .list();
        return listCaixaLivro
                .stream()
                .map(cl -> CaixaLivroResponseDTO.valueOf(cl))
                .toList();
    }

    @Override
    public List<CaixaLivroResponseDTO> findByDescricao(String descricao) {
        List<CaixaLivro> listCaixaLivro = caixaLivroRepository
                                            .findByDescricao(descricao)
                                            .list();
        return listCaixaLivro
                .stream()
                .map(cl -> CaixaLivroResponseDTO.valueOf(cl))
                .toList();
    }

    @Override
    public List<CaixaLivroResponseDTO> findByAutor(String autor) {
        List<CaixaLivro> listCaixaLivro = caixaLivroRepository
                                            .findByAutor(autor)
                                            .list();
        return listCaixaLivro
                .stream()
                .map(cl -> CaixaLivroResponseDTO.valueOf(cl))
                .toList();
    }

    @Override
    public List<CaixaLivroResponseDTO> findByNome(int page, int pageSize, String nome) {
        List<CaixaLivro> listCaixaLivro = caixaLivroRepository
                                            .findByNome(nome)
                                            .page(page, pageSize)
                                            .list();
        return listCaixaLivro
                .stream()
                .map(cl -> CaixaLivroResponseDTO.valueOf(cl))
                .toList();
    }

    @Override
    public List<CaixaLivroResponseDTO> findByDescricao(int page, int pageSize, String descricao) {
        List<CaixaLivro> listCaixaLivro = caixaLivroRepository
                                            .findByDescricao(descricao)
                                            .page(page, pageSize)
                                            .list();
        return listCaixaLivro
                .stream()
                .map(cl -> CaixaLivroResponseDTO.valueOf(cl))
                .toList();
    }

    @Override
    public List<CaixaLivroResponseDTO> findByAutor(int page, int pageSize, String autor) {
        List<CaixaLivro> listCaixaLivro = caixaLivroRepository
                                            .findByAutor(autor)
                                            .page(page, pageSize)
                                            .list();
        return listCaixaLivro
                .stream()
                .map(cl -> CaixaLivroResponseDTO.valueOf(cl))
                .toList();
    }

    @Override
    public long count(){
        return caixaLivroRepository.count();
    }

    @Override
    public long countByNome(String nome){
        return caixaLivroRepository.findByNome(nome).count();
    }

}
