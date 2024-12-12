package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.cupom.Cupom;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CupomRepository implements PanacheRepository <Cupom>{

    public PanacheQuery<Cupom> findByNomeCupom(String nomeCupom){
        return find("UPPER(nome) LIKE ?1", "%" + nomeCupom.toUpperCase() + "%");
    }

}
