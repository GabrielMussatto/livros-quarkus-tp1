package br.unitins.topicos1.dto;

import java.util.List;

public record PedidoDTO(
    Long idCliente,
    List<ItemPedidoDTO> itens,
    String nomeCupom
    
) { }
