package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.editora.Editora;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EditoraRepository implements PanacheRepository<Editora>{
        
    public List<Editora> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Editora> findByEstado(String estado){
        return find("UPPER(estado) LIKE ?1", "%" + estado.toUpperCase() + "%").list();
    }

    public Editora findByNomeEditora(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }

}
