package br.unitins.topicos1.service.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.validation.Validator;

import br.unitins.topicos1.dto.AvaliacaoDTO;
import br.unitins.topicos1.dto.Response.AvaliacaoResponseDTO;
import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.avaliacao.Avaliacao;
import br.unitins.topicos1.model.avaliacao.Estrela;
import br.unitins.topicos1.model.livro.Livro;
import br.unitins.topicos1.repository.AvaliacaoRepository;
import br.unitins.topicos1.repository.LivroRepository;
import br.unitins.topicos1.repository.pessoa.ClienteRepository;
import br.unitins.topicos1.service.AvaliacaoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class AvaliacaoServiceImpl implements AvaliacaoService{

    @Inject
    AvaliacaoRepository avaliacaoRepository;

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    LivroRepository livroRepository;

    @Inject
    Validator validator;

    @Override
    public List<AvaliacaoResponseDTO> findAll() {
        return avaliacaoRepository.findAll().stream().map(a -> AvaliacaoResponseDTO.valueOf(a)).toList();
    }

    @Override
    public AvaliacaoResponseDTO findById(Long id) throws NotFoundException {
        Avaliacao avaliacao = avaliacaoRepository.findById(id);
        
        if(avaliacao == null){
            throw new RuntimeException("Avaliação não encontrada");
        }

        return AvaliacaoResponseDTO.valueOf(avaliacao);
    }

    @Override
    @Transactional
    public AvaliacaoResponseDTO create(AvaliacaoDTO avaliacaDTO) throws ConstraintViolationException {
        validar(avaliacaDTO);

        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setComentario(avaliacaDTO.comentario());
        avaliacao.setDataAvaliacao(LocalDate.now());
        avaliacao.setEstrela(Estrela.valueOf(avaliacaDTO.estrela()));
        avaliacao.setLivro(livroRepository.findById(avaliacaDTO.idLivro()));
        avaliacao.setCliente(clienteRepository.findById(avaliacaDTO.idCliente()));

        avaliacaoRepository.persist(avaliacao);

        return AvaliacaoResponseDTO.valueOf(avaliacao);
    }

    @Override
    @Transactional
    public AvaliacaoResponseDTO update(Long id, AvaliacaoDTO avaliacaDTO) {
        validar(avaliacaDTO);

        Avaliacao avaliacao = avaliacaoRepository.findById(id);

        avaliacao.setComentario(avaliacaDTO.comentario());
        avaliacao.setDataAvaliacao(LocalDate.now());
        avaliacao.setEstrela(Estrela.valueOf(avaliacaDTO.estrela()));
        avaliacao.setLivro(livroRepository.findById(avaliacaDTO.idLivro()));
        avaliacao.setCliente(clienteRepository.findById(avaliacaDTO.idCliente()));

        return AvaliacaoResponseDTO.valueOf(avaliacao);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        if (id == null)
        throw new IllegalArgumentException("Id inválido");

        Avaliacao avaliacao = avaliacaoRepository.findById(id);

        if (avaliacaoRepository.isPersistent(avaliacao)){
            avaliacaoRepository.delete(avaliacao);
        }else{
            throw new NotFoundException("Nenhuma avaliação encontrado");
        }
    }

    @Override
    @Transactional
    public void delete(Livro livro) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByLivro(livro);
        for (Avaliacao avaliacao : avaliacoes) {
            avaliacaoRepository.delete(avaliacao);
        }
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByCliente(cliente);

        for (Avaliacao avaliacao : avaliacoes) {
            avaliacaoRepository.delete(avaliacao);
        }
    }

    @Override
    public List<AvaliacaoResponseDTO> getByIdLivro(Long idLivro) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByLivro(livroRepository.findById(idLivro));
        if (avaliacoes == null){
            throw new NullPointerException("Nenhuma avaliação encontrada para o livro de id " + idLivro);
        }

        return avaliacoes.stream().map(a -> AvaliacaoResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<AvaliacaoResponseDTO> getByNomeCliente(String nome) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByCliente(clienteRepository.findByNome(nome).get(0));

        if(avaliacoes == null){
            throw new NullPointerException("Nenhuma avaliação encontrada para o cliente " + nome);
        }

        return avaliacoes.stream().map(a -> AvaliacaoResponseDTO.valueOf(a)).toList();
    }

    private void validar(AvaliacaoDTO avaliacaoDTO) throws ConstraintViolationException{
        Set<ConstraintViolation<AvaliacaoDTO>> validations = validator.validate(avaliacaoDTO);
        
        if (!validations.isEmpty()) {
            throw new ConstraintViolationException(validations);
        }
    }
    
}
