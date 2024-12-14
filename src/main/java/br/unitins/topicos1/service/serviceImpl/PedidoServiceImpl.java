package br.unitins.topicos1.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.CartaoCreditoDTO;
import br.unitins.topicos1.dto.CupomDTO;
import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.Response.PedidoResponseDTO;
import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.caixa.CaixaLivro;
import br.unitins.topicos1.model.cupom.Cupom;
import br.unitins.topicos1.model.formaPagamento.BandeiraCartao;
import br.unitins.topicos1.model.formaPagamento.Boleto;
import br.unitins.topicos1.model.formaPagamento.CartaoCredito;
import br.unitins.topicos1.model.formaPagamento.Pix;
import br.unitins.topicos1.model.livro.Livro;
import br.unitins.topicos1.model.pedido.ItemPedido;
import br.unitins.topicos1.model.pedido.Pedido;
import br.unitins.topicos1.repository.BoletoRepository;
import br.unitins.topicos1.repository.CaixaLivroRepository;
import br.unitins.topicos1.repository.CartaoCreditoRepository;
import br.unitins.topicos1.repository.CupomRepository;
import br.unitins.topicos1.repository.ItemPedidoRepository;
import br.unitins.topicos1.repository.LivroRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.PixRepository;
import br.unitins.topicos1.repository.pessoa.ClienteRepository;
import br.unitins.topicos1.service.PedidoService;
import br.unitins.topicos1.validation.ValidationException;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    public PedidoRepository pedidoRepository;

    @Inject
    public ItemPedidoRepository itemPedidoRepository;

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public LivroRepository livroRepository;

    @Inject
    public CaixaLivroRepository caixaLivroRepository;

    @Inject
    public BoletoRepository boletoRepository;

    @Inject
    public PixRepository pixRepository;

    @Inject
    public CartaoCreditoRepository cartaoCreditoRepository;

    @Inject
    public CupomRepository cupomRepository;

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    JsonWebToken tokenJwt;

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {
        String username = securityIdentity.getPrincipal().getName();

        Cliente cliente = clienteRepository.findById(dto.idCliente());
        if (cliente == null) {
            throw new ValidationException("Buscando Cliente",
                    "Cliente não encontrado - Executando PedidoServiceImpl_create");
        }

        if (!clienteAutenticado(username, dto.idCliente())) {
            throw new ValidationException("Verificando...",
                    "Você não tem autorização para realizar o pedido. - Executando PedidoServiceImpl_create");
        }

        Pedido pedidoExistente = pedidoRepository.findByClienteNaoFinalizado(cliente);
        if (pedidoExistente != null) {
            throw new ValidationException("Buscando Pedido",
                    "Já existe um pedido em aberto. Pague seu ultimo pedido ou delete para fazer um novo. - Executando PedidoServiceImpl_create");
        }

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.now());

        // Aqui, você pode aplicar o cupom, se houver
        
        List<ItemPedido> itens = new ArrayList<>();
        Double valorTotal = 0.0;

        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido item = new ItemPedido();
            item.setQuantidade(itemDTO.quantidade());

            if (itemDTO.idLivro() != null) {
                Livro livro = livroRepository.findById(itemDTO.idLivro());
                if (livro == null) {
                    throw new ValidationException("Buscando Livro",
                            "Livro não encontrado - Executando Pedido Create em PedidoServiceIMPL");
                }
                if (item.getQuantidade() > livro.getQuantidadeEstoque()) {
                    throw new ValidationException("Verificando Estoque", "Livro não tem estoque suficiente");
                }

                item.setLivro(livro);
                item.setSubTotal((livro.getPreco() - calcularDesconto(item)) * item.getQuantidade());
            }
            
            if (itemDTO.idCaixaLivro() != null) {
                CaixaLivro caixaLivro = caixaLivroRepository.findById(itemDTO.idCaixaLivro());
                if (caixaLivro == null) {
                    throw new ValidationException("Buscando Caixa de Livro",
                            "Caixa de Livro não encontrada - Executando Pedido Create em PedidoServiceIMPL");
                }
                if (item.getQuantidade() > caixaLivro.getQuantidadeEmEstoque()) {
                    throw new ValidationException("Verificando Estoque", "Caixa de Livro não tem estoque suficiente");
                }

                item.setCaixaLivro(caixaLivro);
                item.setSubTotal((caixaLivro.getPreco() - calcularDesconto(item)) * item.getQuantidade());
            }
            
            item.setDesconto(calcularDesconto(item));
            itens.add(item);
            
            valorTotal += calcularValorTotal(item);
        }

        if (dto.nomeCupom() != null && !dto.nomeCupom().isEmpty()) {
            // Buscando o cupom pelo nome
            Cupom cupom = cupomRepository.find("nomeCupom", dto.nomeCupom()).firstResult();  // ou singleResult()
            if (cupom != null) {
                pedido.setCupom(cupom);  // Associar o cupom ao pedido
            } else {
                throw new ValidationException("Verificando Cupom", "Cupom não encontrado.");
            }
        }

        // Aplicando o desconto do cupom, se existir
        if (pedido.getCupom() != null) {
            valorTotal = valorTotal * (pedido.getCupom().getDesconto()); // Aplicar o desconto do cupom
        }

        pedido.setItens(itens);
        pedido.setValorTotal(valorTotal);

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);
    }

    private Double calcularValorTotal(ItemPedido item) {
        if (item.getLivro() != null) {
            return (item.getLivro().getPreco() - calcularDesconto(item)) * item.getQuantidade();
        } else if (item.getCaixaLivro() != null) {
            return (item.getCaixaLivro().getPreco() - calcularDesconto(item)) * item.getQuantidade();
        }
        throw new ValidationException("calcularValorTotal", "Não há Livro ou Caixa de Livro em Item");
    }

    private Double calcularDesconto(ItemPedido item) {
        Double desconto = 0.0;
        if (item.getLivro() != null) {
            if (item.getQuantidade() >= 3) {
                desconto = (item.getLivro().getPreco() * 0.10);
            }
        } else if (item.getCaixaLivro() != null) {
            if (item.getQuantidade() >= 3) {
                desconto = (item.getCaixaLivro().getPreco() * 0.20);
            }
        } else {
            throw new ValidationException("calcularDesconto",
                    "Não há Livro ou Caixa de Livro para calcular o desconto");
        }
        return desconto;
    }

    @Override
    @Transactional
    public void cancelarPedido(Long idCliente) {
        Pedido pedido = pedidoRepository.findByClienteNaoFinalizado(clienteRepository.findById(idCliente));
        if (pedido == null)
            throw new ValidationException("cancelarPedido", "Não há nenhuma compra em andamento");
        for (ItemPedido itemPedido : pedido.getItens()) {
            itemPedidoRepository.delete(itemPedido);
            if (itemPedido.getLivro() != null) {
                itemPedido.getLivro().aumentandoEstoque(itemPedido.getQuantidade());
            } else if (itemPedido.getCaixaLivro() != null) {
                itemPedido.getCaixaLivro().aumentandoEstoque(itemPedido.getQuantidade());
            }
        }
        pedidoRepository.delete(pedido);
    }

    @Override
    public void finalizarPedido(Long idPedido) throws NullPointerException {
        Pedido pedido = pedidoRepository.findById(idPedido);
        if (pedido == null)
            throw new ValidationException("finalizarPedido", "Não há nenhuma compra em andamento");
        if (pedido.getItens().size() == 0)
            throw new ValidationException("finalizarPedido", "Não há nenhum item dentro do carrinho");
        pedido.setDataPedido(LocalDateTime.now());
        for (ItemPedido itemPedido : pedido.getItens()) {
            if (itemPedido.getLivro() != null) {
                if (itemPedido.getLivro().getQuantidadeEstoque() < itemPedido.getQuantidade()) {
                    throw new ValidationException("finalizarPedido",
                            "quantidade de livro em estoque insuficiente para a quantidade requisitada. Não é possível finalizar a compra");
                } else {
                    itemPedido.getLivro().diminuindoEstoque(itemPedido.getQuantidade());
                }
            }

            if (itemPedido.getCaixaLivro() != null) {
                if (itemPedido.getCaixaLivro().getQuantidadeEmEstoque() < itemPedido.getQuantidade()) {
                    throw new ValidationException("finalizarPedido",
                            "quantidade de caixa livro em estoque insuficiente para a quantidade requisitada. Não é possível finalizar a compra");
                } else {
                    itemPedido.getCaixaLivro().diminuindoEstoque(itemPedido.getQuantidade());
                }
            }

        }
        pedido.setIfPedidoFeito(true);
    }

    @Override
    @Transactional
    public List<PedidoResponseDTO> meusPedidos() {
        String username = tokenJwt.getName();
        List<PedidoResponseDTO> pedidos = pedidoRepository.find("cliente.usuario.username", username).stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();

        if (pedidos.isEmpty()) {
            throw new ValidationException("Meus pedidos",
                    "Você ainda não fez nenhum pedido. - Executando PedidoServiceImpl_meusPedidos");
        }

        return pedidos;
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return PedidoResponseDTO.valueOf(pedidoRepository.findById(id));
    }

    @Override
    @Transactional
    public void pagamentoCartao(Long idCliente, CartaoCreditoDTO cartaoCreditoDTO) {
        Cliente cliente = clienteRepository.findById(idCliente);
        Pedido pedido = validar(cliente);
        CartaoCredito pagamento = new CartaoCredito(
                pedido.getValorTotal(),
                cartaoCreditoDTO.nomeImpressaoTitular(),
                cartaoCreditoDTO.numeroCartao(),
                cartaoCreditoDTO.cvc(),
                cartaoCreditoDTO.cpfTitular(),
                cartaoCreditoDTO.validade(),
                BandeiraCartao.valueOf(cartaoCreditoDTO.bandeiraCartao()));
        cartaoCreditoRepository.persist(pagamento);
        pedido.setFormaPagamento(pagamento);
        if (pedido.getFormaPagamento() == null)
            throw new ValidationException("PagamentoCartaoCredito",
                    "Não foi efetuado nenhum pagamento - Executando PedidoServiceImpl_pagamentoCartao");
        finalizarPedido(pedido.getId());
    }

    @Override
    @Transactional
    public void pagamentoBoleto(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente);
        Pedido pedido = validar(cliente);
        Boleto pagamento = new Boleto(pedido.getValorTotal(), pedido.getCliente().getUsuario().getNome(),
                pedido.getCliente().getUsuario().getCpf());
        boletoRepository.persist(pagamento);
        pedido.setFormaPagamento(pagamento);
        if (pedido.getFormaPagamento() == null) {
            throw new ValidationException("PagamentoBoleto",
                    "Não foi efetuado nenhum pagamento - Executando PedidoServiceImpl_pagamentoBoleto");
        }
        finalizarPedido(pedido.getId());
    }

    @Override
    @Transactional
    public void pagamentoPix(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente);
        Pedido pedido = validar(cliente);
        Pix pagamento = new Pix(pedido.getValorTotal(), pedido.getCliente().getUsuario().getNome(),
                pedido.getCliente().getUsuario().getCpf());
        pixRepository.persist(pagamento);
        pedido.setFormaPagamento(pagamento);
        if (pedido.getFormaPagamento() == null) {
            throw new ValidationException("PagamentoPix",
                    "Não foi efetuado nenhum pagamento - Executando PedidoServiceImpl_pagamentoPix");
        }
        finalizarPedido(pedido.getId());
    }

    private Pedido validar(Cliente cliente) {

        Pedido pedido = pedidoRepository.findByClienteNaoFinalizado(cliente);

        if (pedido == null) {
            throw new ValidationException("ValidandoCliente", "Não há nenhuma pedido em andamento");
        }
        if (pedido.getItens().size() == 0) {
            throw new ValidationException("ValidandoCliente", "Não há nenhum item dentro do carrinho");
        }
        return pedido;
    }

    @Override
    public List<PedidoResponseDTO> findAll() {

        return pedidoRepository
                .listAll()
                .stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    public boolean clienteAutenticado(String username, Long idCliente) {
        Cliente clienteAutenticado = clienteRepository.findByUsername(username);
        return clienteAutenticado != null && clienteAutenticado.getId().equals(idCliente);
    }

    @Override
    public List<PedidoResponseDTO> findByCliente(Long idCliente) {
        return pedidoRepository.findByCliente(idCliente).stream().map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

}
