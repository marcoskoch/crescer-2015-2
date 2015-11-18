package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDaoTest {

    @Test
    public void findClienteComCpf() throws SQLException {

        Cliente cliente = new Cliente();
        cliente.setNrCpf("654651321");

        ClienteDao clienteDao = new ClienteDao();
        String cpfEncontrado = "";

        List<Cliente> lista = clienteDao.find(cliente);
        for (Cliente clie : lista) {
            cpfEncontrado = clie.getNrCpf();
        }

        assertEquals(cpfEncontrado, "654651321");
    }

}
