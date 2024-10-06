package br.unitins.topicos1.repository.pessoa;

import java.util.List;

import br.unitins.topicos1.model.Pessoa.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario>{
    public List<Funcionario> findByCargo(String cargo){
        return find("UPPER(cargo) LIKE ?1", "%" + cargo.toUpperCase() + "%").list();
    }
    
    public Funcionario findByCargoFuncionario(String cargo){
        return find("UPPER(cargo) LIKE ?1", "%" + cargo.toUpperCase() ).firstResult();
    }

    public Funcionario findByUsernameAndSenha(String username, String senha) {
       return find("usuario.username = ?1 AND usuario.senha = ?2", username, senha).firstResult(); 
    }

    public Funcionario findByUsername(String username) {

        if (username == null){
            return null;
        }
        return find("usuario.username = ?1", username).firstResult();
    }

    public Funcionario findById(Long id){
        return find("usuario.id", id).firstResult();
    }

}
