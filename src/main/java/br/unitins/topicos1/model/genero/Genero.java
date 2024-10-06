package br.unitins.topicos1.model.genero;

import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Genero extends DefaultEntity{
    
    @Column(length = 60, nullable = false)
    private String nome;

    @Column(length = 500, nullable = false)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
