package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.avaliacao.Avaliacao;
import br.unitins.topicos1.model.livro.Livro;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AvaliacaoRepository implements PanacheRepository<Avaliacao>{
 
    public List<Avaliacao> findByLivro(Livro livro){
        if(livro == null){
            return null;
        }

        return find("FROM Avaliacao WHERE livro = ?1", livro).list();
    }

    public PanacheQuery<Avaliacao> findByCliente(Cliente cliente){
        if(cliente == null){
            return null;
        }

        return find("FROM Avaliacao WHERE cliente = ?1", cliente);
    }
}
