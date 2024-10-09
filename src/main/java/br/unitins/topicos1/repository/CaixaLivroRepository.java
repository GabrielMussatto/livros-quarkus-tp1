package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.caixa.CaixaLivro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CaixaLivroRepository implements PanacheRepository<CaixaLivro>{
    
    public List<CaixaLivro> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public List<CaixaLivro> findByDescricao(String descricao){
        return find("UPPER(descricao) LIKE ?1", "%" + descricao.toUpperCase() + "%").list();
    }

    public List<CaixaLivro> findByAutor(String autor){
        return find("SELECT c FROM CaixaLivro c JOIN c.listaAutores a WHERE UPPER (a.nome) LIKE ?1", autor.toUpperCase() + "%").list();
    }

    public CaixaLivro findByNomeCaixaLivro(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }
}
