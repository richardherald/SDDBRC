package br.com.sddbrc.configuration_impl;

import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.commons.property.Property;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import br.com.sddbrc.configuration.IConfigurationConnection;

public class ConfigurationConnection_DBImpl implements IConfigurationConnection {

    private static Databases SDDBRC_POOL = new Databases();

    @Override
    public void loadConfiguration() throws Exception {
        try {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setPoolName(Property.DB.getProperty("poolName"));
            hikariConfig.setJdbcUrl(Property.DB.getProperty("jdbcUrl"));
            hikariConfig.setUsername(Property.DB.getProperty("username"));
            hikariConfig.setPassword(Property.DB.getProperty("password"));
            hikariConfig.setMaximumPoolSize(Integer.valueOf(Property.DB.getProperty("maximumPoolSize")));
            hikariConfig.addDataSourceProperty("cachePrepStmts", Property.DB.getProperty("cachePrepStmts"));
            hikariConfig.addDataSourceProperty("prepStmtCacheSize", Property.DB.getProperty("prepStmtCacheSize"));
            hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", Property.DB.getProperty("prepStmtCacheSqlLimit"));
            HikariDataSource datasource = new HikariDataSource(hikariConfig);
            getSDDBRC_POOL().setDatasource(datasource);
        } catch (NumberFormatException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    public static Databases getSDDBRC_POOL() {
        return SDDBRC_POOL;
    }

    public static void setSDDBRC_POOL(Databases aSDDBRC_POOL) {
        SDDBRC_POOL = aSDDBRC_POOL;
    }
}
