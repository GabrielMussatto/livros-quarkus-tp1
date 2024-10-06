package br.unitins.topicos1.repository;

import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.topicos1.model.formaPagamento.Boleto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BoletoRepository implements PanacheRepository<Boleto>{
    
}
