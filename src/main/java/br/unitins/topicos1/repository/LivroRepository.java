package br.unitins.topicos1.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unitins.topicos1.model.livro.Livro;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LivroRepository implements PanacheRepository<Livro>{
    
    public PanacheQuery<Livro> findByTitulo(String titulo){
        return find("UPPER(titulo) LIKE ?1", "%" + titulo.toUpperCase() + "%");
    }

    public PanacheQuery<Livro> findByIsbn(String isbn){
        return find("isbn LIKE ?1", "%" + isbn + "%");
    }

    public PanacheQuery<Livro> findByDescricao(String descricao){
        return find("UPPER(descricao) LIKE ?1", "%" + descricao.toUpperCase() + "%");
    }

    public Livro findByTituloLivro(String titulo) {
        return find("UPPER(titulo) = ?1",  titulo.toUpperCase() ).firstResult();
    }

    public PanacheQuery<Livro> findByAutor(String autor){
        return find("SELECT l FROM Livro l JOIN l.listaAutor a WHERE UPPER(a.nome) LIKE ?1",autor.toUpperCase() + "%");
    }

    public PanacheQuery<Livro> findByGenero(String genero){
        return find("SELECT l FROM Livro l JOIN l.listaGenero g WHERE UPPER (g.nome) LIKE ?1", genero.toUpperCase() + "%");
    }

    public PanacheQuery<Livro> findWithFilters(List<Long> autores, List<Long> editoras, List<Long> generos) {
        StringBuilder query = new StringBuilder("SELECT DISTINCT l FROM Livro l ");
        Map<String, Object> params = new HashMap<>();
    
        boolean whereAdded = false;
    
        if (autores != null && !autores.isEmpty()) {
            query.append("JOIN l.listaAutor autor ");
            query.append(whereAdded ? "AND " : "WHERE ").append("autor.id IN (:autores) ");
            params.put("autores", autores);
            whereAdded = true;
        }
    
        if (editoras != null && !editoras.isEmpty()) {
            query.append(whereAdded ? "AND " : "WHERE ").append("l.editora.id IN (:editoras) ");
            params.put("editoras", editoras);
            whereAdded = true;
        }
    
        if (generos != null && !generos.isEmpty()) {
            query.append(whereAdded ? "AND " : "WHERE ")
                 .append("EXISTS (SELECT 1 FROM l.listaGenero genero WHERE genero.id IN (:generos)) ");
            params.put("generos", generos);
        }
    
        return find(query.toString(), params);
    }
}
