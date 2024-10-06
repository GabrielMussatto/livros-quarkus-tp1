package br.unitins.topicos1.model.telefone;

import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class Telefone extends DefaultEntity {
    
    private String codigoArea;
    private String numero;

    public String getCodigoArea() {
        return codigoArea;
    }
    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

}
