package br.com.cwi.crescer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

@Repository
public class PedidoDAO extends AbstractDAO {

    public Pedido findById(Long id) {
        return em.find(Pedido.class, id);
    }

    public List<Pedido> findBySituacao(SituacaoPedido situacao) {
        return em.createQuery("FROM Pedido c WHERE c.situacao = :situacao", Pedido.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }

    public List<Pedido> find() {

        List<Pedido> pedidos = new ArrayList<>();

        pedidos = em.createQuery("FROM Pedido p", Pedido.class)
                .getResultList();

        return pedidos;
    }

    @Transactional
    public Pedido save(Pedido pedido) {

        if (pedido.getIdPedido() == null) {
            em.persist(pedido);
            return pedido;
        }

        return em.merge(pedido);
    }

}
