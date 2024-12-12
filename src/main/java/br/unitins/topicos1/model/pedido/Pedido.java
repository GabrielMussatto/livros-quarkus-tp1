package br.unitins.topicos1.model.pedido;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.cupom.Cupom;
import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import br.unitins.topicos1.model.formaPagamento.FormaPagamento;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido extends DefaultEntity {

    private LocalDateTime dataPedido;

    private Double valorTotal = 0.0;

    private Boolean ifPedidoFeito = false;

    @ManyToOne(optional = true) // O campo é opcional
    @JoinColumn(name = "id_cupom") // Relacionamento com a tabela de cupom
    private Cupom cupom;

    @OneToOne
    @JoinColumn(name = "id_formaPagamento", unique = true)
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_pedido")
    private List<ItemPedido> itens;

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Boolean getIfPedidoFeito() {
        return ifPedidoFeito;
    }

    public void setIfPedidoFeito(Boolean ifPedidoFeito) {
        this.ifPedidoFeito = ifPedidoFeito;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }
}
