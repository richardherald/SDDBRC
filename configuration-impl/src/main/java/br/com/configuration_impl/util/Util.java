package br.com.configuration_impl.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util implements br.com.configuration.util.Util {

    @Override
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
}
