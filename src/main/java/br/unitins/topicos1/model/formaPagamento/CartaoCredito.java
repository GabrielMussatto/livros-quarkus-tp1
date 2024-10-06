package br.unitins.topicos1.model.formaPagamento;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name = "id")
@Entity
public class CartaoCredito extends FormaPagamento{
    
    private String nomeImpressoTitular;
    private String numeroCartao;
    private Integer cvc;
    
    @Column(nullable = false)
    private String cpfTitular;
    private LocalDate validade;
    private BandeiraCartao bandeiraCartao;
    
    public CartaoCredito(Double valor, String nomeImpressoTitular, String numeroCartao, Integer cvc, String cpfTitular, LocalDate validade, BandeiraCartao bandeiraCartao) {
        super(valor);
        this.nomeImpressoTitular = nomeImpressoTitular;
        this.numeroCartao = numeroCartao;
        this.cvc = cvc;
        this.cpfTitular = cpfTitular;
        this.validade = validade;
        this.bandeiraCartao = bandeiraCartao;
    }
    
    public CartaoCredito() {
        
    }
    
    public LocalDate getValidade() {
        return validade;
    }
    
    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getNomeImpressoTitular() {
        return nomeImpressoTitular;
    }
    
    public void setNomeImpressoTitular(String nomeImpressoTitular) {
        this.nomeImpressoTitular = nomeImpressoTitular;
    }
    
    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
    
    public Integer getCvc() {
        return cvc;
    }
    
    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }
    
    public String getCpfTitular() {
        return cpfTitular;
    }
    
    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public BandeiraCartao getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(BandeiraCartao bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }
}
