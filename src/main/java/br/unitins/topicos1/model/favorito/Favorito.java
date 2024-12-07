package br.unitins.topicos1.model.favorito;

import java.util.List;

import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.caixa.CaixaLivro;
import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import br.unitins.topicos1.model.livro.Livro;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Favorito extends DefaultEntity {
    
    @OneToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "favoritos_livros", 
        joinColumns = @JoinColumn(name = "id_favoritos"), 
        inverseJoinColumns = @JoinColumn(name = "id_livro")
    )
    private List<Livro> listaLivrosFavoritos;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "favoritos_caixas", 
        joinColumns = @JoinColumn(name = "id_favoritos"), 
        inverseJoinColumns = @JoinColumn(name = "id_caixa")
    )
    private List<CaixaLivro> listaCaixasLivrosFavoritos;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Livro> getListaLivrosFavoritos() {
        return listaLivrosFavoritos;
    }

    public void setListaLivrosFavoritos(List<Livro> listaLivrosFavoritos) {
        this.listaLivrosFavoritos = listaLivrosFavoritos;
    }

    public List<CaixaLivro> getListaCaixasLivrosFavoritos() {
        return listaCaixasLivrosFavoritos;
    }

    public void setListaCaixasLivrosFavoritos(List<CaixaLivro> listaCaixasLivrosFavoritos) {
        this.listaCaixasLivrosFavoritos = listaCaixasLivrosFavoritos;
    }
}
