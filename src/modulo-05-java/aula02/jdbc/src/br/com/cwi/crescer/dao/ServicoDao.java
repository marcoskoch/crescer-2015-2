package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Servico;

public class ServicoDao {

    public void adiciona(Servico servico) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            PreparedStatement statement = conexao.prepareStatement("insert into Servico(dsServico) values ('" + servico.getDsServico() + "')");
            statement.execute();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
