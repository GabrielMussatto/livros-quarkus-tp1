package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.caixa.CaixaLivro;
import br.unitins.topicos1.model.livro.Livro;
import br.unitins.topicos1.model.pedido.ItemPedido;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemPedidoRepository implements PanacheRepository<ItemPedido>  {
    public ItemPedido findByLivro (Livro livro) {

        if (livro == null)
            return null;

        return find("FROM ItemPedido WHERE livro = ?1", livro).firstResult();
    }

    public ItemPedido findByCaixaLivro (CaixaLivro caixaLivro) {

        if (caixaLivro == null)
            return null;

        return find("FROM ItemPedido WHERE caixaLivro = ?1", caixaLivro).firstResult();
    }
}
