package br.com.repositorios.config.db;

import static br.com.commons.property.Property.PROPS;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class ConnectionFactoryImpl implements ConnectionFactory {

    private static DataSource sqlServer;
    private static DataSource postgresql;
    private static DataSource middleware;

    List<DataSource> datasources = new ArrayList<>();

    private final static Logger LOGGER = Logger.getLogger(ConnectionFactoryImpl.class.getName());

    public ConnectionFactoryImpl() {
        datasources.add(middleware);
        datasources.add(sqlServer);
        datasources.add(postgresql);
    }

    @Override
    public DataSource getDatasource(int banco) throws Exception {
        if (datasources.get(banco - 1) == null) {
            datasources.set(banco - 1, config(banco));
            return datasources.get(banco - 1);
        } else {
            return datasources.get(banco - 1);
        }
    }

    @Override
    public DataSource config(int codigo) throws Exception {
        try {
            HikariConfig config = new HikariConfig();
            config.setPoolName(String.valueOf(codigo));
            config.setJdbcUrl(PROPS.getProperty(codigo + "-url"));
            config.setUsername(PROPS.getProperty(codigo + "-username"));
            config.setPassword(PROPS.getProperty(codigo + "-password"));
            config.setMaximumPoolSize(Integer.valueOf(PROPS.getProperty(codigo + "-maxPoolSize")));
            config.setAutoCommit(Boolean.valueOf(PROPS.getProperty(codigo + "-autoCommit")));
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "4096");
            return new HikariDataSource(config);
        } catch (Exception e) {
            throw e;
        }
    }

}
