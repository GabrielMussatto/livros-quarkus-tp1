package br.unitins.topicos1.dto;

public record ItemPedidoDTO(
    Long idLivro,
    Long idCaixaLivro,
    Integer quantidade
) { }
