package br.com.persistence_impl;

import br.com.configuration_impl.db.ConnectionFactoryImpl;
import br.com.sddbrc.core.ConfigurationC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Metodos {

    private static ConnectionFactoryImpl connectionHikari;
    private static ConfigurationC configurationC = new ConfigurationC();

    protected Connection getConnectionPrimaryPool() throws Exception {
        return getConnectionHikari().getPrimaryPoolReplication().getConnection();
    }

    protected Connection getConnection() throws Exception {
        return getConnectionHikari().getPoolReplication().getConnection();
    }

    protected Connection getConnectionMiddleware() throws Exception {
        return getConnectionHikari().getPoolMiddleware().getConnection();
    }

    protected static ConnectionFactoryImpl getConnectionHikari() {
        if (connectionHikari == null) {
            connectionHikari = configurationC.connectionFactoryImpl();
            return connectionHikari;
        }
        return connectionHikari;
    }

    protected void closeConnection(ResultSet resultSet, PreparedStatement ps, Connection conn) throws SQLException {
        configurationC.closeConnection(resultSet, ps, conn);
    }

    protected int returnGeneratedKeys(PreparedStatement ps, int retorno) throws SQLException {
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

    public void executeScript(String command, String script, Connection conn) throws Exception {
        try (Statement st = (PreparedStatement) conn.createStatement()) {
            switch (command) {
                case "INSERT":
                    st.executeUpdate(script);
                    break;
                case "UPDATE":
                    st.executeUpdate(script);
                    break;
                case "DELETE":
                    st.executeUpdate(script);
                    break;
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
