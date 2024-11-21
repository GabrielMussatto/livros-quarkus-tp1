package br.unitins.topicos1.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;

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

    public PanacheQuery<CaixaLivro> findWithFilters(List<Long> autores, List<Long> editoras, List<Long> generos) {
        StringBuilder query = new StringBuilder("SELECT DISTINCT b FROM CaixaLivro b ");
        Map<String, Object> params = new HashMap<>();
    
        boolean whereAdded = false;
    
        if (autores != null && !autores.isEmpty()) {
            query.append("JOIN b.listaAutor autor ");
            query.append(whereAdded ? "AND " : "WHERE ").append("autor.id IN (:autores) ");
            params.put("autores", autores);
            whereAdded = true;
        }
    
        if (editoras != null && !editoras.isEmpty()) {
            query.append(whereAdded ? "AND " : "WHERE ").append("b.editora.id IN (:editoras) ");
            params.put("editoras", editoras);
            whereAdded = true;
        }
    
        if (generos != null && !generos.isEmpty()) {
            query.append(whereAdded ? "AND " : "WHERE ")
                 .append("EXISTS (SELECT 1 FROM b.listaGeneros genero WHERE genero.id IN (:generos)) ");
            params.put("generos", generos);
        }
    
        return find(query.toString(), params);
    }
}
