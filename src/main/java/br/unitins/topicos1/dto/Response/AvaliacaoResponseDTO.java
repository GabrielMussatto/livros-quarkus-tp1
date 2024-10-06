package br.unitins.topicos1.dto.Response;

import java.time.LocalDate;
import java.util.HashMap;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.topicos1.model.avaliacao.Avaliacao;
import br.unitins.topicos1.model.avaliacao.Estrela;

public record AvaliacaoResponseDTO(
    Long id,
    String comentario,
    LocalDate dataAvaliacao,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Estrela estrela,

    Map<String, Object> Livro,
    Map<String, Object> cliente
) {
    public static AvaliacaoResponseDTO valueOf(Avaliacao avaliacao){
        return new AvaliacaoResponseDTO(
            avaliacao.getId(),
            avaliacao.getComentario() != null ? avaliacao.getComentario() : null,
            avaliacao.getDataAvaliacao(),
            avaliacao.getEstrela(),
            livro(avaliacao.getLivro().getId(),
                    avaliacao.getLivro().getTitulo()),
            cliente(avaliacao.getCliente().getUsuario().getId(),
                    avaliacao.getCliente().getUsuario().getUsername(),
                    avaliacao.getCliente().getUsuario().getEmail())       
        );
    }

    public static Map<String, Object> livro (Long id, String nome) {

        Map<String, Object> livro = new HashMap<>();

        livro.put("id", id);
        livro.put("nome", nome);

        return livro;
    }

    public static Map<String, Object> cliente (Long id, String username, String email) {

        Map<String, Object> cliente = new HashMap<>();

        cliente.put("id", id);
        cliente.put("username", username);
        cliente.put("email", email);

        return cliente;
    }

}