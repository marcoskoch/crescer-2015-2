package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Servico;

public class ServicoDao {

    public void insert(Servico servico) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" insert into servico ");
            stringBuilder.append("(idServico, dsServico) values(?,?) ");

            PreparedStatement statement = conexao.prepareStatement(stringBuilder.toString());
            statement.setLong(1, servico.getIdServico());
            statement.setString(2, servico.getDsServico());
            statement.execute();

        } catch (Exception e) {
            throw e;
        }
    }

    public List<Servico> listAll() throws SQLException {
        List<Servico> lista = new ArrayList<Servico>();

        try (Connection conexao = new ConnectionFactory().getConnection()){

            StringBuilder query = new StringBuilder();
            query.append("Select idServico, dsServico from Servico");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Servico servico = new Servico();
                servico.setIdServico(result.getInt(1));
                servico.setDsServico(result.getString(2));
                lista.add(servico);
            }

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }
}
