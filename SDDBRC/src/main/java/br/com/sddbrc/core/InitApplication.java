package br.com.sddbrc.core;

import br.com.sddbrc.configuration_impl.ConfigurationConnection_DBImpl;
import br.com.sddbrc.connection_impl.ConnectionImpl;
import br.com.sddbrc.persistence_impl.PersistenceImpl;
import br.com.sddbrc.replication.IReplication;

public class InitApplication {

    private final String clazz = "br.com.sddbrc.replicationImpl.ReplicationEasyImpl";
    private PersistenceImpl persistence;
    private ConfigurationConnection_DBImpl configurationConnection;
    private Runtime runtime;
    private ConnectionImpl connection;
    private static InitApplication initApplication;

    public InitApplication() {
        persistence = new PersistenceImpl();
        configurationConnection = new ConfigurationConnection_DBImpl();
        runtime = new Runtime();
        initApplication = new InitApplication();
        connection = new ConnectionImpl();
    }

    public static void main(String[] args) throws Exception {
        initApplication.startConfiguration();
        initApplication.startPersistence();
        initApplication.startReplication();
        initApplication.startConnection();
    }

    public void startConnection() throws Exception {
        connection.socket();
    }

    public void startConfiguration() throws Exception {
        configurationConnection.loadConfiguration();
    }

    public void startReplication() throws Exception {
        runtime.replicationClass = (IReplication) Class.forName(clazz).newInstance();
    }

    public void startPersistence() throws Exception {
        persistence.init(configurationConnection.getDatabasesWithConfiguration());
    }
}
