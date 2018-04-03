package br.com.sddbrc.core;

import br.com.configuration_impl.db.ConnectionFactoryImpl;
import br.com.configuration_impl.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfigurationC {

    public void closeConnection(ResultSet resultSet, PreparedStatement ps, Connection conn) throws SQLException {
        try {
            Util connectionUtil = new Util();
            connectionUtil.closeConnection(resultSet, ps, conn);
        } catch (SQLException e) {
            throw e;
        }
    }

    public ConnectionFactoryImpl connectionFactoryImpl() {
        return new ConnectionFactoryImpl();
    }
}
