package br.unitins.topicos1.model.fornecedor;

import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import br.unitins.topicos1.model.telefone.Telefone;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;

@Entity
public class Fornecedor extends DefaultEntity {

    @Column(length = 60, nullable = false)
    private String nome;

    @Column(length = 18, nullable = false)
    private String cnpj;

    @Column(length = 12)
    private String inscricaoEstadual;

    @Email(message= "E-mail inválido.")
    private String email;

    @Column(length = 60, nullable = false)
    private String endereco;

    @Column(length = 10, nullable = false)
    private String cep;

    private String estado;
    private String cidade;

    @Column(nullable = false)
    private Integer quantLivrosFornecido;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_telefone", nullable = false)
    private Telefone telefone;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public Integer getQuantLivrosFornecido() {
        return quantLivrosFornecido;
    }
    public void setQuantLivrosFornecido(Integer quantLivrosFornecido) {
        this.quantLivrosFornecido = quantLivrosFornecido;
    }

    public Telefone getTelefone() {
        return telefone;
    }
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    } 
}
