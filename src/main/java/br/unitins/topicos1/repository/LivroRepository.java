package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.livro.Livro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LivroRepository implements PanacheRepository<Livro>{
    
    public List<Livro> findByTitulo(String titulo){
        return find("UPPER(titulo) LIKE ?1", "%" + titulo.toUpperCase() + "%").list();
    }

    public List<Livro> findByIsbn(String isbn){
        return find("isbn LIKE ?1", "%" + isbn + "%").list();
    }

    public List<Livro> findByDescricao(String descricao){
        return find("UPPER(descricao) LIKE ?1", "%" + descricao.toUpperCase() + "%").list();
    }

    public Livro findByTituloLivro(String titulo) {
        return find("UPPER(titulo) = ?1",  titulo.toUpperCase() ).firstResult();
    }

    public List<Livro> findByAutor(String autor){
        return find("SELECT l FROM Livro l JOIN l.listaAutor a WHERE UPPER(a.nome) LIKE ?1",autor.toUpperCase() + "%").list();
    }

}
