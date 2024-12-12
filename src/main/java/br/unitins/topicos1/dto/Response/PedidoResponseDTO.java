package br.unitins.topicos1.dto.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.unitins.topicos1.model.pedido.Pedido;

public record PedidoResponseDTO(
    Long id,
    ClienteResponseDTO cliente,
    LocalDateTime dataPedido,
    String valorTotal,
    List<ItemPedidoResponseDTO> itens,
    String statusPagamento,
    LocalDate dataPagamento,
    String statusPedido,
    String nomeCupom,  // Novo campo para o nome do cupom
    Double descontoCupom  // Novo campo para o valor do desconto do cupom
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        List<ItemPedidoResponseDTO> lista = pedido.getItens()
                                           .stream()
                                           .map(ItemPedidoResponseDTO::valueOf)
                                           .toList();

        // Adiciona o nome do cupom e o desconto, caso exista
        String nomeCupom = null;
        Double descontoCupom = 0.0;

        if (pedido.getCupom() != null) {
            nomeCupom = pedido.getCupom().getNomeCupom();
            descontoCupom = pedido.getCupom().getDesconto();
        }

        return new PedidoResponseDTO(
            pedido.getId(),
            ClienteResponseDTO.valueOf(pedido.getCliente()), 
            pedido.getDataPedido(),
            "R$" + String.format("%.2f", pedido.getValorTotal()),
            lista,
            pedido.getFormaPagamento() != null ? 
                pedido.getFormaPagamento().getConfirmacaoPagamento() == true ? 
                    "Pagamento realizado" : "Pagamento não realizado" : null,
            pedido.getFormaPagamento() != null ? 
                pedido.getFormaPagamento().getDataPagamento() : null,
            pedido.getIfPedidoFeito() == true ? "Compra concluída" : "Compra em andamento",
            nomeCupom,  // Adicionando o nome do cupom
            descontoCupom  // Adicionando o desconto do cupom
        );
    }
}

