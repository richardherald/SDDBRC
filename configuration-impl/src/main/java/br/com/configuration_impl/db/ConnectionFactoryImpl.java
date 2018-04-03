package br.com.configuration_impl.db;

import br.com.configuration.db.ConnectionFactory;
import br.com.commons.model.Database;
import br.com.commons.model.Configuration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

public class ConnectionFactoryImpl implements ConnectionFactory {

    protected static Map<Integer, DataSource> poolReplication = new HashMap<>();
    private static DataSource poolMiddleware;
    private static List<Database> listDataBases = new ArrayList<>();
    private static int primaryDataBase;

    public ConnectionFactoryImpl() {
    }

    @Override
    public DataSource config(Configuration config) throws Exception {
        try {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setPoolName(config.getConfiguration_Poolname());
            hikariConfig.setJdbcUrl(config.getConfiguration_PoolJdbcurl());
            hikariConfig.setUsername(config.getConfiguration_Username());
            hikariConfig.setPassword(config.getConfiguration_Password());
            hikariConfig.setMaximumPoolSize(config.getConfiguration_Maxpoolsize());
            if (config.getConfiguration_Cachesize() > 0) {
                hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
                hikariConfig.addDataSourceProperty("prepStmtCacheSize", config.getConfiguration_Cachesize());
                if (config.getConfiguration_Cachesizelimit() < config.getConfiguration_Cachesize()) {
                    hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", config.getConfiguration_Cachesize());
                } else {
                    hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", config.getConfiguration_Cachesizelimit());
                }
            }
            return new HikariDataSource(hikariConfig);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public DataSource config(String directoryConfiguration) throws Exception {
        try {
            HikariConfig config = new HikariConfig(directoryConfiguration);
            return new HikariDataSource(config);
        } catch (Exception e) {
            throw e;
        }
    }

    public DataSource getPoolReplication() throws Exception {
        return poolReplication.get(primaryDataBase);
    }

    public DataSource getPrimaryPoolReplication() throws Exception {
        return poolReplication.get(primaryDataBase);
    }

    public DataSource getPoolMiddleware() throws Exception {
        return poolMiddleware;
    }

    public void setPoolReplication(Map<Integer, DataSource> aPoolReplication) {
        poolReplication = aPoolReplication;
    }

    public static int getPrimaryDataBase() {
        return primaryDataBase;
    }

    public void setPrimaryDataBase(int aPrimaryDataBase) {
        primaryDataBase = aPrimaryDataBase;
    }

    public void setPoolMiddleware(DataSource aPoolMiddleware) {
        poolMiddleware = aPoolMiddleware;
    }

    public List<Database> getListDataBases() {
        return listDataBases;
    }

    public void setListDataBases(List<Database> aListDataBases) {
        listDataBases = aListDataBases;
    }
}
