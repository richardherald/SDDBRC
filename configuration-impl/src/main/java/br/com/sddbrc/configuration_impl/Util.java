package br.com.sddbrc.configuration_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {

    ConfigurationConnection_DBImpl configConnection = new ConfigurationConnection_DBImpl();

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
        return ConfigurationConnection_DBImpl.getSDDBRC_POOL().getDatasource().getConnection();
    }

    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public String extractTableByQuery(String query) {
        try {
            String[] aux;
            String[] queryAux;
            queryAux = query.split("\\(");
            if (queryAux[0].contains(".")) {
                aux = queryAux[0].split("\\.");
                query = aux[aux.length - 1];
                query = query.replace("[", "").replace("]", "").replace(" ", "");
            } else {
                aux = query.split(" ");
                query = aux[aux.length - 1];
                query = query.replace("[", "").replace("]", "").replace(" ", "");
            }
            return query;
        } catch (Exception e) {
            throw e;
        }
    }

    public String extractCommandByQuery(String query) {
        try {
            return query.split(" ")[0];
        } catch (Exception e) {
            throw e;
        }
    }

    public String concatTableIdOnQuery(String query, String tableId, int valueId) {
        try {
            String corte = "(";
            int begin = query.toUpperCase().indexOf(corte.toUpperCase());
            String inicio = query.substring(0, begin + 1);
            inicio = inicio.concat(tableId.concat(","));
            String aux = inicio.concat(query.substring(begin + 1, query.length()));
            //segunda parte
            begin = aux.indexOf(corte, aux.indexOf(corte)+1);
            inicio = aux.substring(0, begin+1).concat(""+valueId+",");
            aux = inicio.concat(aux.substring(begin + 1, aux.length()));
            return aux;
        } catch (Exception e) {
            throw e;
        }
    }
}
