package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.fornecedor.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor>{
        
    public List<Fornecedor> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Fornecedor> findByCidade(String cidade){
        return find("UPPER(cidade) LIKE ?1", "%" + cidade.toUpperCase() + "%").list();
    }

    public List<Fornecedor> findByEstado(String estado){
        return find("UPPER(estado) LIKE ?1", "%" + estado.toUpperCase() + "%").list();
    }

    public List<Fornecedor> findByCnpj(String cnpj){
        return find("cnpj LIKE ?1", "%" + cnpj + "%").list();
    }

    public Fornecedor findByNomeFornecedor(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }

    public Fornecedor findByCnpjFornecedor(String cnpj){
        return find("cnpj LIKE ?1", "%" + cnpj + "%").firstResult();
    }
}
