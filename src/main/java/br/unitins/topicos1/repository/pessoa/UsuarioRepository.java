package br.unitins.topicos1.repository.pessoa;

import java.util.List;

import br.unitins.topicos1.model.Pessoa.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{
    public PanacheQuery<Usuario> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%");
    }

    public PanacheQuery<Usuario> findByCpf(String cpf){
        return find("cpf LIKE ?1", "%" + cpf + "%");
    }

    public Usuario findByCpfUsuario(String cpf){
        return find("cpf LIKE ?1", "%" + cpf + "%").firstResult();
    }

    public Usuario findByEmailUsuario(String email){
        return find("email LIKE ?1", "%" + email + "%").firstResult();
    }

    public Usuario findById(Long id){
        return find("id", id).firstResult();
    }

}
