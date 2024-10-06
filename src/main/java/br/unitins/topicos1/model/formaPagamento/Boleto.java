package br.unitins.topicos1.model.formaPagamento;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name = "id")
@Entity
public class Boleto extends FormaPagamento {

    private String nome;

    private String cpf;

    @Column(nullable = false)
    private LocalDate dataGeracaoBoleto;

    @Column(nullable = false)
    private LocalDate dataVencimento;

    public Boleto (Double valor, String nome, String cpf) {

        super(valor);

        this.nome = nome;
        this.cpf = cpf;
        this.dataGeracaoBoleto = LocalDate.now();
        this.dataVencimento = LocalDate.now().plusDays(7);
    }

    public Boleto() {
        
    }

    public LocalDate getDataGeracaoBoleto() {
        return dataGeracaoBoleto;
    }

    public void setDataGeracaoBoleto(LocalDate dataDeGeracaoDoBoleto) {
        this.dataGeracaoBoleto = dataDeGeracaoDoBoleto;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
