package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.genero.Genero;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GeneroRepository implements PanacheRepository<Genero>{

    public PanacheQuery<Genero> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%");
    }

    public PanacheQuery<Genero> findByDescricao(String descricao){
        return find("UPPER(descricao) LIKE ?1", "%" + descricao.toUpperCase() + "%");
    }

    public Genero findByNomeGenero(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }
}
