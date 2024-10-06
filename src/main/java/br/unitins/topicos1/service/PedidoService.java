package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CartaoCreditoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.Response.PedidoResponseDTO;
import jakarta.validation.Valid;

public interface PedidoService {

    public List<PedidoResponseDTO> findAll();
    public PedidoResponseDTO findById(Long id);
    public List<PedidoResponseDTO> findByCliente(Long idCliente);    
    public PedidoResponseDTO create(@Valid PedidoDTO dto);
    public void cancelarPedido(Long idCliente);
    public void finalizarPedido(Long idPedido);
    public void pagamentoCartao(Long idCliente, CartaoCreditoDTO cartaoCreditoDTO);
    public void pagamentoBoleto(Long idCliente);
    public void pagamentoPix(Long idCliente);
    boolean clienteAutenticado(String username, Long idCliente);
    public List<PedidoResponseDTO> meusPedidos();
}
