package br.com.configuration_impl;

import br.com.commons.model.Databases;
import br.com.sddbrc.commons.property.Property;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import br.com.configuration.IConfigurationConnection;
import br.com.configuration.IDatabase;
import br.com.configuration.IConfiguration;
import java.util.List;

public class ConfigurationConnection_DBImpl implements IConfigurationConnection {

    private static Databases SDDBRC_POOL;
    private static ConfigurationConnection_DBImpl configurationSDDBRC_DBImpl;

    public ConfigurationConnection_DBImpl() {
        SDDBRC_POOL = new Databases();
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
            HikariDataSource datasource = new HikariDataSource(hikariConfig);
            getSDDBRC_POOL().setDatasource(datasource);
        } catch (NumberFormatException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Databases> getDatabasesWithConfiguration() throws Exception {
        try{
            IDatabase databaseImpl = new DatabaseImpl();
            IConfiguration configurationImpl = new ConfigurationImpl();
            List<Databases> databases = databaseImpl.getAll();
            for (int i = 0; i < databases.size(); i++){
                databases.get(i).setConfiguration(configurationImpl.getByDatabaseId(databases.get(i).getDatabase_Id()));
            }
            return databases;
        }catch(Exception e){
            throw e;
        }
    }

    public static ConfigurationConnection_DBImpl getConfigurationSDDBRC_DBImpl() {
        return configurationSDDBRC_DBImpl;
    }

    public static void setConfigurationSDDBRC_DBImpl(ConfigurationConnection_DBImpl aConfigurationSDDBRC_DBImpl) {
        configurationSDDBRC_DBImpl = aConfigurationSDDBRC_DBImpl;
    }

    public static Databases getSDDBRC_POOL() {
        return SDDBRC_POOL;
    }

    public static void setSDDBRC_POOL(Databases aSDDBRC_POOL) {
        SDDBRC_POOL = aSDDBRC_POOL;
    }
}
