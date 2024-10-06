package br.unitins.topicos1.model.editora;

import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import br.unitins.topicos1.model.telefone.Telefone;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Editora extends DefaultEntity{
    
    @Column(length = 60, nullable = false)
    private String nome;

    @Email(message= "E-mail inválido.")
	@NotEmpty(message = "O E-mail deve ser informado.")
    private String email;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_telefone", unique = true)
    private Telefone telefone;
    
    private String endereco;
    private String estado;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

}
