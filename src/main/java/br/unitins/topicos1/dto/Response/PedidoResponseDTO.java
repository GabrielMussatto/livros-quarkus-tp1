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
    String statusPedido
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        List<ItemPedidoResponseDTO> lista = pedido.getItens()
                                           .stream()
                                           .map(ItemPedidoResponseDTO::valueOf)
                                           .toList();
        return new PedidoResponseDTO(
            pedido.getId(),
            ClienteResponseDTO.valueOf(pedido.getCliente()), 
            pedido.getDataPedido(),
            "R$" + String.format("%.2f",pedido.getValorTotal()),
            lista,
            pedido.getFormaPagamento() != null ? 
                pedido.getFormaPagamento().getConfirmacaoPagamento() == true ? 
                                "Pagamento realizado" : "Pagamento não realizado" : null,
            pedido.getFormaPagamento() != null ?
                pedido.getFormaPagamento().getDataPagamento() : null,
            pedido.getIfPedidoFeito() == true ? "Compra concluída" : "Compra em andamento"
        );
    }
}
