package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {

    public void adiciona(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            PreparedStatement statement = conexao.prepareStatement("insert into cliente(idCliente, nmCliente, nrCpf) values (" + cliente.getIdCliente() + ",'"+cliente.getNmCliente()+"','"+cliente.getNrCpf()+"')");
            statement.execute();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
