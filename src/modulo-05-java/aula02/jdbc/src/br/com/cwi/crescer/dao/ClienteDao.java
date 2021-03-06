package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {

    public void insert(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" insert into cliente ");
            stringBuilder.append("(idCliente, nmCliente, nrCpf) values(cliente_seq.NEXTVAL,?,?) ");

            PreparedStatement statement = conexao.prepareStatement(stringBuilder.toString());
            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());

            statement.execute();

        } catch (Exception e) {
            throw e;
        }
    }

    public List<Cliente> listAll() throws SQLException {
        List<Cliente> lista = new ArrayList<Cliente>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append(" select idCliente, nmCliente, nrCpf from Cliente");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
                lista.add(cliente);
            }

        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public void delete(Long id) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("delete from cliente where idcliente = ?");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, id);
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public Cliente load(long id) throws SQLException {
        Cliente cliente = new Cliente();
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("select idcliente, nmcliente, nrcpf from cliente where idcliente = ?");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
            } else {
                throw new RuntimeException("registro não encontrada");
            }

        } catch (SQLException e) {
            throw e;
        }
        return cliente;
    }

    public void update(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("update cliente set nmcliente = ?, nrcpf = ? where idcliente = ?");

            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
            statement.setLong(3, cliente.getIdCliente());
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Cliente> find(Cliente cliente) throws SQLException {
        List<Cliente> lista = new ArrayList<Cliente>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("select idcliente, nmcliente, nrcpf from cliente where 1 = 1");
            if (cliente.getNmCliente() != null) {
                query.append("and nmcliente = ?");
            }
            if (cliente.getNrCpf() != null) {
                query.append("and nrcpf = ?");
            }


            PreparedStatement statement = conexao.prepareStatement(query.toString());
            if (cliente.getNmCliente() != null) {
                statement.setString(1, cliente.getNmCliente());
                statement.setString(2, cliente.getNrCpf());
            } else {
                statement.setString(1, cliente.getNrCpf());
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente clienteEncontrado = new Cliente();
                clienteEncontrado.setIdCliente(resultSet.getLong(1));
                clienteEncontrado.setNmCliente(resultSet.getString(2));
                clienteEncontrado.setNrCpf(resultSet.getString(3));
                lista.add(cliente);
            }

        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

}
