package br.unitins.topicos1.model.formaPagamento;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name = "id")
@Entity
public class Pix extends FormaPagamento {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    private LocalDate dataExpiracaoTokenPix;
    
    public Pix (Double valor, String nome, String cpf) {
        super(valor);
        this.nome = nome;
        this.cpf = cpf;
        this.dataExpiracaoTokenPix = LocalDate.now().plusDays(1);
    }
    
    public Pix () {
        
    }
        
    public LocalDate getDataExpiracaoTokenPix() {
        return dataExpiracaoTokenPix;
    }

    public void setDataExpiracaoTokenPix(LocalDate dataExpiracaoTokenPix) {
        this.dataExpiracaoTokenPix = dataExpiracaoTokenPix;
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
