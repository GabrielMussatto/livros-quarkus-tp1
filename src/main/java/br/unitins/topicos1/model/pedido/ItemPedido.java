package br.unitins.topicos1.model.pedido;

import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import br.unitins.topicos1.model.livro.Livro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido extends DefaultEntity {

    private Double desconto;
    
    @Column(nullable = false)
    private Integer quantidade;

    private Double subTotal;
    
    @ManyToOne
    @JoinColumn(name = "id_livro", nullable = false)
    private Livro livro;

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
    
    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
