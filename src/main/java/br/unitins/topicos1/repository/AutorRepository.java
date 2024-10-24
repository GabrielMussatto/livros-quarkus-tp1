package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.autor.Autor;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AutorRepository implements PanacheRepository<Autor>{
    
    public PanacheQuery<Autor> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() +"%");
    }

    public PanacheQuery<Autor> findByBiografia(String biografia){
        return find("UPPER(biografia) LIKE ?1", "%"+ biografia.toUpperCase() +"%");
    }

    public Autor findByNomeCompleto(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }
}
