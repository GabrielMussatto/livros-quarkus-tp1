package br.unitins.topicos1.model.Pessoa;

import java.util.List;

import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import br.unitins.topicos1.model.livro.Livro;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente extends DefaultEntity {
    
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private String cep;
    private String endereco;
    private String estado; 
    private String cidade;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "lista_favorito",
                joinColumns = @JoinColumn(name = "id_cliente"),
                inverseJoinColumns = @JoinColumn(name = "id_livro"))
    private List<Livro> listaFavorito;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Livro> getListaFavorito() {
        return listaFavorito;
    }

    public void setListaFavorito(List<Livro> listaFavorito) {
        this.listaFavorito = listaFavorito;
    }
}