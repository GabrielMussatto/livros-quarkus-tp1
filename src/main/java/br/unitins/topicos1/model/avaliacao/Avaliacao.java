package br.unitins.topicos1.model.avaliacao;

import java.time.LocalDate;

import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import br.unitins.topicos1.model.livro.Livro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Avaliacao extends DefaultEntity{
    
    private String comentario;
    
    private LocalDate dataAvaliacao;
    
    @Column(nullable = false)
    private Estrela estrela;

    @ManyToOne
    @JoinColumn(name = "id_livro", nullable = false)
    @Enumerated(EnumType.STRING) 
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Estrela getEstrela() {
        return estrela;
    }

    public void setEstrela(Estrela estrela) {
        this.estrela = estrela;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

}
