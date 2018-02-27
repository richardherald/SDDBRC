package br.com.repositorios.config.db;

import br.com.repositorios.model.Banco;
import br.com.repositorios.model.ConfigBanco;
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
    private static List<Banco> listDataBases = new ArrayList<>();
    private static int primaryDataBase;

    public ConnectionFactoryImpl() {
    }

    @Override
    public DataSource config(ConfigBanco config) throws Exception {
        try {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setPoolName(config.getConfigBanco_PoolName());
            hikariConfig.setJdbcUrl(config.getConfigBanco_JdbcUrl());
            hikariConfig.setUsername(config.getConfigBanco_Username());
            hikariConfig.setPassword(config.getConfigBanco_PoolName());
            hikariConfig.setMaximumPoolSize(config.getConfigBanco_MaximumPoolSize());
            if (config.getConfigBanco_CacheSize() > 0) {
                hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
                hikariConfig.addDataSourceProperty("prepStmtCacheSize", config.getConfigBanco_CacheSize());
                if (config.getConfigBanco_CacheSizeLimit() < config.getConfigBanco_CacheSize()) {
                    hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", config.getConfigBanco_CacheSize());
                } else {
                    hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", config.getConfigBanco_CacheSizeLimit());
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

    public List<Banco> getListDataBases() {
        return listDataBases;
    }

    public void setListDataBases(List<Banco> aListDataBases) {
        listDataBases = aListDataBases;
    }
}
