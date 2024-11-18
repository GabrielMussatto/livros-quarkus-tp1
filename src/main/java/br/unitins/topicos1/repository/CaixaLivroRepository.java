package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.caixa.CaixaLivro;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CaixaLivroRepository implements PanacheRepository<CaixaLivro>{
    
    public PanacheQuery<CaixaLivro> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%");
    }

    public PanacheQuery<CaixaLivro> findByDescricao(String descricao){
        return find("UPPER(descricao) LIKE ?1", "%" + descricao.toUpperCase() + "%");
    }

    public PanacheQuery<CaixaLivro> findByAutor(String autor){
        return find("SELECT c FROM CaixaLivro c JOIN c.listaAutores a WHERE UPPER (a.nome) LIKE ?1", autor.toUpperCase() + "%");
    }

    public PanacheQuery<CaixaLivro> findByGenero(String genero){
        return find("SELECT c FROM CaixaLivro c JOIN c.listaGeneros g WHERE UPPER (g.nome) LIKE ?1", genero.toUpperCase() + "%");
    }

    public CaixaLivro findByNomeCaixaLivro(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }
}
