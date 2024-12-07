package br.unitins.topicos1.service.serviceImpl;

import java.util.List;

import br.unitins.topicos1.dto.LivroDTO;
import br.unitins.topicos1.dto.Response.LivroResponseDTO;
import br.unitins.topicos1.model.Enum.Classificacao;
import br.unitins.topicos1.model.livro.Livro;
import br.unitins.topicos1.repository.AutorRepository;
import br.unitins.topicos1.repository.EditoraRepository;
import br.unitins.topicos1.repository.FornecedorRepository;
import br.unitins.topicos1.repository.GeneroRepository;
import br.unitins.topicos1.repository.LivroRepository;
import br.unitins.topicos1.service.LivroService;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class LivroServiceImpl implements LivroService{

    @Inject
    public LivroRepository livroRepository;

    @Inject
    public AutorRepository autorRepository;

    @Inject
    public EditoraRepository editoraRepository;

    @Inject
    public GeneroRepository generoRepository;

    @Inject
    public FornecedorRepository fornecedorRepository;

    @Override
    @Transactional
    public LivroResponseDTO create(@Valid LivroDTO dto){
        validarTituloLivro(dto.titulo());
        
        Livro livro = new Livro();
        livro.setTitulo(dto.titulo());
        livro.setDescricao(dto.descricao());
        livro.setQuantidadeEstoque(dto.quantidadeEstoque());
        livro.setIsbn(dto.isbn());
        livro.setPreco(dto.preco());
        livro.setClassificacao(Classificacao.valueOf(dto.idClassificacao()));
        livro.setDatalancamento(dto.datalancamento());
        livro.setFornecedor(fornecedorRepository.findById(dto.fornecedor()));
        livro.setEditora(editoraRepository.findById(dto.editora()));
        livro.setListaAutor((dto.autores()).stream().map(a -> autorRepository.findById(a)).toList());
        livro.setListaGenero(dto.generos().stream().map(g -> generoRepository.findById(g)).toList());

        livroRepository.persist(livro);
        return LivroResponseDTO.valueOf(livro);
    }
    
    public void validarTituloLivro(String titulo) {
        Livro livro = livroRepository.findByTituloLivro(titulo);
        if (livro != null)
            throw  new ValidationException("titulo", "O titulo '"+titulo+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, LivroDTO dto){
        Livro livroBanco = livroRepository.findById(id);

        if(livroBanco == null)
            throw new ValidationException("id", "Livro não encontrado.");

        livroBanco.setTitulo(dto.titulo());
        livroBanco.setDescricao(dto.descricao());
        livroBanco.setQuantidadeEstoque(dto.quantidadeEstoque());
        livroBanco.setIsbn(dto.isbn());
        livroBanco.setPreco(dto.preco());
        livroBanco.setClassificacao(Classificacao.valueOf(dto.idClassificacao()));
        livroBanco.setDatalancamento(dto.datalancamento());
        livroBanco.setFornecedor(fornecedorRepository.findById(dto.fornecedor()));
        livroBanco.setEditora(editoraRepository.findById(dto.editora()));
        livroBanco.setListaAutor((dto.autores()).stream().map(a -> autorRepository.findById(a)).toList());
        livroBanco.setListaGenero(dto.generos().stream().map(g -> generoRepository.findById(g)).toList());
    }

    @Override
    @Transactional
    public void delete(Long id){
        if (id == null)
           throw new ValidationException("id", "Id não pode ser nulo.");
        livroRepository.deleteById(id);
    }

    @Override
    public LivroResponseDTO findById(Long id){
        return LivroResponseDTO.valueOf(livroRepository.findById(id));
    }

    @Override
    public List<LivroResponseDTO> findAll(int page, int pageSize){
        List<Livro> listLivro = livroRepository
                                    .findAll()
                                    .page(page, pageSize)
                                    .list();
        return listLivro
                .stream()
                .map(livro -> LivroResponseDTO.valueOf(livro))
                .toList();
    }

    @Override
    public List<LivroResponseDTO> findByTitulo(String titulo) {
        List<Livro> listLivro = livroRepository
                                    .findByTitulo(titulo)
                                    .list();
        return listLivro
                .stream()
                .map(livro -> LivroResponseDTO.valueOf(livro))
                .toList();
    }

    @Override
    public List<LivroResponseDTO> findByIsbn(String isbn) {
        List<Livro> listLivro = livroRepository
                                    .findByIsbn(isbn)
                                    .list();
        return listLivro
                .stream()
                .map(livro -> LivroResponseDTO.valueOf(livro))
                .toList();
    }

    @Override
    public List<LivroResponseDTO> findByDescricao(String descricao) {
        List<Livro> listLivro = livroRepository
                                    .findByDescricao(descricao)
                                    .list();
        return listLivro
                .stream()
                .map(livro -> LivroResponseDTO.valueOf(livro))
                .toList();
    }

    @Override
    public List<LivroResponseDTO> findByAutor(String autor) {
        List<Livro> listLivro = livroRepository
                                    .findByAutor(autor)
                                    .list();
        return listLivro
                .stream()
                .map(livro -> LivroResponseDTO.valueOf(livro))
                .toList();
    }

    @Override
    public List<LivroResponseDTO> findByGenero(String genero) {
        List<Livro> listLivro = livroRepository
                                    .findByGenero(genero)
                                    .list();
        return listLivro
                .stream()
                .map(livro -> LivroResponseDTO.valueOf(livro))
                .toList();
    }

    @Override
    public List<LivroResponseDTO> findByTitulo(int page, int pageSize, String titulo) {
        List<Livro> listLivro = livroRepository
                                    .findByTitulo(titulo)
                                    .page(page, pageSize)
                                    .list();
        return listLivro
                .stream()
                .map(livro -> LivroResponseDTO.valueOf(livro))
                .toList();
    }

    @Override
    public List<LivroResponseDTO> findByIsbn(int page, int pageSize, String isbn) {
        List<Livro> listLivro = livroRepository
                                    .findByIsbn(isbn)
                                    .page(page, pageSize)
                                    .list();
        return listLivro
                .stream()
                .map(livro -> LivroResponseDTO.valueOf(livro))
                .toList();
    }

    @Override
    public List<LivroResponseDTO> findByDescricao(int page, int pageSize, String descricao) {
        List<Livro> listLivro = livroRepository
                                    .findByDescricao(descricao)
                                    .page(page, pageSize)
                                    .list();
        return listLivro
                .stream()
                .map(livro -> LivroResponseDTO.valueOf(livro))
                .toList();
    }

    @Override
    public List<LivroResponseDTO> findByAutor(int page, int pageSize, String autor) {
        List<Livro> listLivro = livroRepository
                                    .findByAutor(autor)
                                    .page(page, pageSize)
                                    .list();
        return listLivro
                .stream()
                .map(livro -> LivroResponseDTO.valueOf(livro))
                .toList();
    }

    @Override
    public List<LivroResponseDTO> findByGenero(int page, int pageSize, String genero) {
        List<Livro> listLivro = livroRepository
                                    .findByGenero(genero)
                                    .page(page, pageSize)
                                    .list();
        return listLivro
                .stream()
                .map(livro -> LivroResponseDTO.valueOf(livro))
                .toList();
    }

    @Override
    public long count(){
        return livroRepository.count();
    }

    @Override
    public long countByTitulo(String titulo){
        return livroRepository.findByTitulo(titulo).count();
    }

    @Override
    public long countByAutor(String autor){
        return livroRepository.findByAutor(autor).count();
    }

    @Override
    public long countByGenero(String genero) {
        return livroRepository.findByGenero(genero).count();
    }

    @Override
    @Transactional
    public LivroResponseDTO salveImage(Long id, String nomeImagem){
        Livro livro = livroRepository.findById(id);
        livro.setNomeImagem(nomeImagem);
        
        return LivroResponseDTO.valueOf(livro);
    }

    @Override
    public List<LivroResponseDTO> findWithFilters(List<Long> autores, List<Long> editoras, List<Long> generos) {
        List<Livro> livros = livroRepository.findWithFilters(autores, editoras, generos).list();

        if (livros.isEmpty()) {
            throw new ValidationException("filters","Sem livros encontrados com os filtros aplicados."+autores + editoras + generos);
        }

        return livros.stream()
                .map(LivroResponseDTO::valueOf)
                .toList();
    }
}
