package br.com.repositorios.config.util;

import br.com.repositorios.config.db.ConnectionFactoryImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metodos {

    public static ConnectionFactoryImpl connectionHikari = new ConnectionFactoryImpl();
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet resultSet = null;

    public Connection getConnection(String poolName) throws Exception {
        return connectionHikari.getDatasource(poolName).getConnection();
    }

    public void closeConnection() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public void closeConnection(ResultSet resultSet, PreparedStatement ps, Connection conn) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public int returnGeneratedKeys(PreparedStatement ps, int retorno) throws SQLException {
        if (retorno == 0) {
            throw new SQLException("Ocorreu um erro ao criar o registro no banco.");
        }
        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("O registro foi criado, mas ocorreu um problema ao retornar o id do registro.");
            }
        }
    }
}
