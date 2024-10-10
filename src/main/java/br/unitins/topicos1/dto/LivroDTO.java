package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

public record LivroDTO(
        String titulo,
        String descricao,
        Integer quantidadeEstoque,
        String isbn,
        Double preco,
        Integer classificacao,
        LocalDate datalancamento,
        Long fornecedor,
        Long editora,
        List<Long> autores,
        List<Long> generos
) { }
