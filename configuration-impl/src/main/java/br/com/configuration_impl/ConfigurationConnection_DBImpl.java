package br.com.configuration_impl;

import br.com.commons.model.Database;
import br.com.sddbrc.commons.property.Property;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import br.com.configuration.IConfigurationConnection;
import java.util.List;

public class ConfigurationConnection_DBImpl implements IConfigurationConnection {

    private static Database SDDBRC_POOL;
    private static ConfigurationConnection_DBImpl configurationSDDBRC_DBImpl;

    public static List<Database> getListDatabases() {
        return null;
    }

    public ConfigurationConnection_DBImpl() {
    }

    public static ConfigurationConnection_DBImpl getInstance() {
        return configurationSDDBRC_DBImpl == null ? configurationSDDBRC_DBImpl
                = new ConfigurationConnection_DBImpl() : configurationSDDBRC_DBImpl;
    }

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
            getSDDBRC_POOL().setDatasource(new HikariDataSource(hikariConfig));
        } catch (NumberFormatException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * @return the configurationSDDBRC_DBImpl
     */
    public static ConfigurationConnection_DBImpl getConfigurationSDDBRC_DBImpl() {
        return configurationSDDBRC_DBImpl;
    }

    /**
     * @param aConfigurationSDDBRC_DBImpl the configurationSDDBRC_DBImpl to set
     */
    public static void setConfigurationSDDBRC_DBImpl(ConfigurationConnection_DBImpl aConfigurationSDDBRC_DBImpl) {
        configurationSDDBRC_DBImpl = aConfigurationSDDBRC_DBImpl;
    }

    /**
     * @return the SDDBRC_POOL
     */
    public static Database getSDDBRC_POOL() {
        return SDDBRC_POOL;
    }

    /**
     * @param aSDDBRC_POOL the SDDBRC_POOL to set
     */
    public static void setSDDBRC_POOL(Database aSDDBRC_POOL) {
        SDDBRC_POOL = aSDDBRC_POOL;
    }

}
