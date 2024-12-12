package br.unitins.topicos1.model.sugestao;

import java.time.LocalDate;

import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sugestao extends DefaultEntity{
    
    private String sugestao;

    private LocalDate dataSugestao;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public String getSugestao() {
        return sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }

    public LocalDate getDataSugestao() {
        return dataSugestao;
    }

    public void setDataSugestao(LocalDate dataSugestao) {
        this.dataSugestao = dataSugestao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
