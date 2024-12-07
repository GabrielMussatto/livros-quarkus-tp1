package br.unitins.topicos1.model.caixa;

import java.util.List;

import br.unitins.topicos1.model.Enum.Classificacao;
import br.unitins.topicos1.model.autor.Autor;
import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import br.unitins.topicos1.model.editora.Editora;
import br.unitins.topicos1.model.fornecedor.Fornecedor;
import br.unitins.topicos1.model.genero.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class CaixaLivro extends DefaultEntity {

    @Column(length = 60, nullable = false)
    private String nome;

    @Column(length = 20000, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "id_editora", nullable = false)
    private Editora editora;
    
    @ManyToMany
    @JoinTable(name = "caixa_genero", 
    joinColumns = @JoinColumn(name = "idcaixa"), 
    inverseJoinColumns = @JoinColumn(name = "idgenero")
    )
    private List<Genero> listaGeneros;

    @ManyToMany
    @JoinTable(name = "caixa_autor", 
    joinColumns = @JoinColumn(name = "idcaixa"), 
    inverseJoinColumns = @JoinColumn(name = "idautor")
    )

    private List<Autor> listaAutores;

    private Classificacao classificacao;

    private String nomeImagem;

    private Double preco;

    public void diminuindoEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque -= quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
 
    public List<Genero> getListaGeneros() {
        return listaGeneros;
    }

    public void setListaGeneros(List<Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    public List<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(List<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
