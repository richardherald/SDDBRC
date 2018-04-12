package br.com.sddbrc.persistence_impl;

import br.com.sddbrc.commons.model.Configurations;
import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.persistence.IPersistence;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

public class PersistenceImpl extends Util implements IPersistence {

    private static List<Databases> POOLS;
    private static PersistenceImpl persistenceImpl;

    public static PersistenceImpl getInstance() {
        return getPersistenceImpl() == null ? persistenceImpl = new PersistenceImpl() : getPersistenceImpl();
    }

    @Override
    public DataSource createPool(Configurations config) throws Exception {
        try {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setPoolName(config.getConfiguration_Poolname());
            hikariConfig.setJdbcUrl(config.getConfiguration_Jdbcurl());
            hikariConfig.setUsername(config.getConfiguration_Username());
            hikariConfig.setPassword(config.getConfiguration_Password());
            hikariConfig.setMaximumPoolSize(config.getConfiguration_Maxpoolsize());
            hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
            hikariConfig.addDataSourceProperty("prepStmtCacheSize", config.getConfiguration_Cachesize());
            hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", config.getConfiguration_Cachesizelimit());
            return new HikariDataSource(hikariConfig);
        } catch (NumberFormatException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int executeUpdate(Connection connection, String command, boolean generatedKeys) throws Exception {
        try {
            PreparedStatement ps = connection.prepareStatement(command,generatedKeys ? 1 : 0);
            int returnValue = ps.executeUpdate();
            return generatedKeys ? returnGeneratedKeys(ps, returnValue) : returnValue;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ResultSet executeQuery(Connection connection, String command) throws Exception {
        try {
            return connection.prepareStatement(command).executeQuery();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    public void executeQueryTest(Connection connection, String command) throws Exception {
        try {
            ResultSet rs = connection.prepareStatement(command).executeQuery();
            while (rs.next() == true) {
                System.out.println(rs.getInt("pessoa_Id"));
                System.out.println(rs.getString("Pessoa_Nome"));
                System.out.println(rs.getString("Pessoa_Cpf"));
                System.out.println(rs.getString("Pessoa_Sexo"));
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void init(List<Databases> databases) throws Exception {
        try {
            for (int i = 0; i < databases.size(); i++) {
                Databases database = databases.get(i);
                String clazz = database.getDatabase_ClassDatasource();
                IPersistence configConnection = (PersistenceImpl) Class.forName(clazz).newInstance();
                DataSource newDatasource = configConnection.createPool(database.getConfiguration());
                databases.get(i).setDatasource(newDatasource);
            }
            setPOOLS(databases);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isSelect(String command) {
        return (command.substring(0, 6).contains("SELECT"));
    }

    public Connection ReturnConnection(List<Databases> databases, int databaseId) throws Exception {
        try {
            for (Databases database : databases) {
                if (database.getDatabase_Id() == databaseId) {
                    return database.getDatasource().getConnection();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public String testConnection() throws Exception {
        try {
            String databaseConnectionsValid = "0";
            for (int i = 0; i < POOLS.size(); i++) {
                Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                conn = POOLS.get(i).getDatasource().getConnection();
                ps = conn.prepareStatement("SELECT 1");
                if (ps.executeQuery().next()) {
                    databaseConnectionsValid += "," + POOLS.get(i).getDatabase_Id();
                }
            }
            return databaseConnectionsValid;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    public static List<Databases> getPOOLS() {
        return POOLS;
    }

    public static void setPOOLS(List<Databases> aPOOLS) {
        POOLS = aPOOLS;
    }

    public static PersistenceImpl getPersistenceImpl() {
        return persistenceImpl;
    }

    public static void setPersistenceImpl(PersistenceImpl aPersistenceImpl) {
        persistenceImpl = aPersistenceImpl;
    }
}
