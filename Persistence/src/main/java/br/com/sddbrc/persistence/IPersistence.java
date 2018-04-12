package br.com.sddbrc.persistence;

import br.com.sddbrc.commons.model.Configurations;
import br.com.sddbrc.commons.model.Databases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;

public interface IPersistence {
    public void init(List<Databases> databases) throws Exception;
    public DataSource createPool(Configurations config) throws Exception;
    public int executeUpdate(Connection connection, String command, boolean returnGeneratedKeys) throws Exception;
    public ResultSet executeQuery(Connection connection, String command) throws Exception;
}
