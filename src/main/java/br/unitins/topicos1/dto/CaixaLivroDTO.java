package br.unitins.topicos1.dto;

import java.util.List;

public record CaixaLivroDTO(
    String nome,
    String descricao,
    Long fornecedor,
    Long editora,
    List<Long> generos,
    List<Long> autores,
    Double preco,
    Integer quantidadeEstoque,
    Integer classificacao
) { }
