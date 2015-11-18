package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.model.Pedido;


public class PedidoDaoTest {

    @Test
    public void listarTodosPedidos() throws SQLException {
        Pedido pedido = new Pedido();

        PedidoDao pedidoDao = new PedidoDao();
        String dsPedidoEncontrado = "";

        List<Pedido> lista = pedidoDao.listAll();
        for (Pedido pedidos : lista) {
            dsPedidoEncontrado = pedidos.getDsPedido();
        }

        assertEquals(dsPedidoEncontrado, "Pedido teste");
    }

    @Test
    public void buscarPedidoComIdUm() throws SQLException {
        Pedido pedidoEsperado = new Pedido();
        pedidoEsperado.setIdPedido(2L);
        pedidoEsperado.setIdCliente(1L);
        pedidoEsperado.setDsPedido("Pedido teste");

        Pedido pedidoEncontrado = new Pedido();
        PedidoDao pedidoDao = new PedidoDao();
        pedidoEncontrado = pedidoDao.load(2);

        assertEquals(pedidoEncontrado.getIdPedido(), pedidoEsperado.getIdPedido());
        assertEquals(pedidoEncontrado.getIdCliente(), pedidoEsperado.getIdCliente());
        assertEquals(pedidoEncontrado.getDsPedido(), pedidoEsperado.getDsPedido());
    }

}
