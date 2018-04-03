package br.com.configuration.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Util {

    public void closeConnection(ResultSet resultSet, PreparedStatement ps, Connection conn) throws SQLException;
}
