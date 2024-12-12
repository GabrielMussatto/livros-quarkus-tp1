package br.unitins.topicos1.model.cupom;

import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class Cupom extends DefaultEntity{
    
    private String nomeCupom;
    private Double desconto;
    
    public String getNomeCupom() {
        return nomeCupom;
    }
    public void setNomeCupom(String nomeCupom) {
        this.nomeCupom = nomeCupom;
    }
    public Double getDesconto() {
        return desconto;
    }
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
    
}
