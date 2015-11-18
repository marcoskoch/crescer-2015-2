package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Pedido;

public class PedidoDao {

    public void insert(Pedido pedido) throws Exception {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" insert into pedido ");
            stringBuilder.append("(idPedido, idCliente, dsPedido) values(cliente_seq.NEXTVAL,?,?) ");

            PreparedStatement statement = conexao.prepareStatement(stringBuilder.toString());
            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());

            statement.execute();

        } catch (Exception e) {
            throw e;
        }
    }

    public List<Pedido> listAll() throws SQLException {

        List<Pedido> lista = new ArrayList<Pedido>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append(" select idPedido, idCliente, dsPedido from Pedido");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(resultSet.getLong(1));
                pedido.setIdCliente(resultSet.getLong(2));
                pedido.setDsPedido(resultSet.getString(3));
                lista.add(pedido);
            }

        } catch (SQLException e) {
            throw e;
        }
        return lista;

    }

    public void delete(Long id) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("delete from pedido where pedido = ?");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, id);
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public Pedido load(long id) throws SQLException {
        Pedido pedido = new Pedido();
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("select idPedido, idCliente, dsPedido from Pedido where idPedido = ?");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                pedido.setIdPedido(resultSet.getLong(1));
                pedido.setIdCliente(resultSet.getLong(2));
                pedido.setDsPedido(resultSet.getString(3));
            } else {
                throw new RuntimeException("registro não encontrada");
            }

        } catch (SQLException e) {
            throw e;
        }
        return pedido;
    }

    public void update(Pedido pedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("update pedido set idcliente = ?, dspedido = ? where idpedido = ?");

            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());
            statement.setLong(3, pedido.getIdPedido());
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Pedido> find(Pedido filter) throws SQLException {
        List<Pedido> lista = new ArrayList<Pedido>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("select idPedido, idCliente, dsPedido from Pedido where 1 = 1");
            if (filter.getIdCliente() != null) {
                query.append("and idcliente = ?");
            }
            if (filter.getDsPedido() != null) {
                query.append("and dspedido = ?");
            }

            PreparedStatement statement = conexao.prepareStatement(query.toString());
            if (filter.getIdCliente() != null) {
                statement.setLong(1, filter.getIdCliente());
                statement.setString(2, filter.getDsPedido());
            } else {
                statement.setString(1, filter.getDsPedido());
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pedido pedidoEncontrado = new Pedido();
                pedidoEncontrado.setIdPedido(resultSet.getLong(1));
                pedidoEncontrado.setIdCliente(resultSet.getLong(2));
                pedidoEncontrado.setDsPedido(resultSet.getString(3));
                lista.add(pedidoEncontrado);
            }

        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

}
