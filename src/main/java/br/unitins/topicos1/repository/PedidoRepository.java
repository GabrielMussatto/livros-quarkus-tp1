package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.pedido.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {

    public List<Pedido> findByCliente(Long idCliente) {
        return find("cliente.id", idCliente).list();
    }
 
    public Pedido findByClienteNaoFinalizado(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        return find("FROM Pedido p WHERE p.cliente = ?1 AND p.ifPedidoFeito = false", cliente).firstResult();
    }

    public List<Pedido> findByClienteFinalizado(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        return find("FROM Pedido p WHERE p.cliente = ?1 AND p.ifPedidoFeito = true", cliente).list();
    }
}

