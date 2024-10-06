package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

public record LivroDTO(String titulo,
        List<Long> autores,
        Long editora,
        List<Long> generos,
        Double preco,
        Integer quantidadeEstoque,
        String isbn,
        LocalDate datalancamento,
        Integer id_classificacao,
        String descricao,
        Long fornecedor
) { }
