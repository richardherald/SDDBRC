package br.com.configuration_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
    
    ConfigurationConnection_DBImpl configConnection = ConfigurationConnection_DBImpl.getInstance();

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

    protected Connection getConnection() throws Exception {
        return configConnection.getSDDBRC_POOL().getDatasource().getConnection();
    }
    
    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
        if (rs != null){
            rs.close();
        }
        if (ps != null){
            ps.close();
        }
        if (conn != null){
            conn.close();
        }
    }
}
