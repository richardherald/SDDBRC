package br.com.persistence_impl;

import br.com.commons.model.Configuration;
import br.com.commons.model.Database;
import br.com.persistence.IPersistence;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;

public class PersistenceImpl extends IPersistence {

    private static List<Database> POOLS;
    private static PersistenceImpl persistenceImpl;

    public static PersistenceImpl getInstance() {
        return getPersistenceImpl() == null ? persistenceImpl = new PersistenceImpl() : getPersistenceImpl();
    }

    @Override
    public DataSource createPool(Configuration config) throws Exception {
        try {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setPoolName(config.getConfiguration_Poolname());
            hikariConfig.setJdbcUrl(config.getConfiguration_PoolJdbcurl());
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
    public int executeUpdate(Connection connection, String command) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet executeQuery(Connection connection, String command) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init(List<Database> databases) throws Exception {
        try {
            for (int i = 0; i < databases.size(); i++) {
                Database database = databases.get(i);
                String clazz = database.getDatabase_classDatasource();
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

    /**
     * @return the POOLS
     */
    public static List<Database> getPOOLS() {
        return POOLS;
    }

    /**
     * @param aPOOLS the POOLS to set
     */
    public static void setPOOLS(List<Database> aPOOLS) {
        POOLS = aPOOLS;
    }

    /**
     * @return the persistenceImpl
     */
    public static PersistenceImpl getPersistenceImpl() {
        return persistenceImpl;
    }

    /**
     * @param aPersistenceImpl the persistenceImpl to set
     */
    public static void setPersistenceImpl(PersistenceImpl aPersistenceImpl) {
        persistenceImpl = aPersistenceImpl;
    }
}
