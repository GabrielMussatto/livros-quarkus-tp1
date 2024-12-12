package br.unitins.topicos1.model.Pessoa;

import javax.swing.Box;

import br.unitins.topicos1.model.caixa.CaixaLivro;
import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import br.unitins.topicos1.model.livro.Livro;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemFavorito extends DefaultEntity{

    @ManyToOne
    @JoinColumn(name = "id_livro", nullable = true)
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "id_caixaLivro", nullable = true)
    private CaixaLivro caixaLivro;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CaixaLivro getCaixaLivro() {
        return caixaLivro;
    }

    public void setCaixaLivro(CaixaLivro caixaLivro) {
        this.caixaLivro = caixaLivro;
    }
}
