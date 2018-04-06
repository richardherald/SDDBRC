package br.com.persistence;

import br.com.commons.model.Configuration;
import br.com.commons.model.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;

public abstract class IPersistence {
    public abstract void init(List<Database> databases) throws Exception;
    public abstract DataSource createPool(Configuration config) throws Exception;
    public abstract int executeUpdate(Connection connection, String command) throws Exception;
    public abstract ResultSet executeQuery(Connection connection, String command) throws Exception;
}
