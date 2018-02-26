package br.com.repositorios.config.db;

import br.com.repositorios.model.ConfigBanco;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

public class ConnectionFactoryImpl implements ConnectionFactory {

    protected static Map<String, DataSource> datasources = new HashMap<>();
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
    public DataSource config(String directory) throws Exception {
        try {
            HikariConfig config = new HikariConfig(directory);
            return new HikariDataSource(config);
        } catch (Exception e) {
            throw e;
        }
    }

    public DataSource getDatasources(String poolName) throws Exception {
        return datasources.get(poolName);
    }

    public void setDatasources(Map<String, DataSource> aDatasources) {
        datasources = aDatasources;
    }

    public static int getPrimaryDataBase() {
        return primaryDataBase;
    }

    public static void setPrimaryDataBase(int aPrimaryDataBase) {
        primaryDataBase = aPrimaryDataBase;
    }
}
