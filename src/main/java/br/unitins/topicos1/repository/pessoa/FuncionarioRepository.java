package br.unitins.topicos1.repository.pessoa;

import java.util.List;

import br.unitins.topicos1.model.Pessoa.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario>{
    public PanacheQuery<Funcionario> findByCargo(String cargo){
        return find("UPPER(cargo) LIKE ?1", "%" + cargo.toUpperCase() + "%");
    }

    public PanacheQuery<Funcionario> findByNomeFuncionario(String nome){

        if(nome == null){
            return null;
        }
        return find("UPPER(usuario.nome) LIKE ?1", "%" + nome.toUpperCase() + "%");
    }

    public PanacheQuery<Funcionario> findByCpfFuncionario(String cpf){

        if(cpf == null){
            return null;
        }
        return find("UPPER(usuario.cpf) LIKE ?1", "%" + cpf.toUpperCase() + "%");
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
