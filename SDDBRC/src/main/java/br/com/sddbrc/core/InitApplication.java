package br.com.sddbrc.core;

import br.com.sddbrc.configuration_impl.ConfigurationConnection_DBImpl;
import br.com.sddbrc.connection_impl.ConnectionImpl;
import br.com.sddbrc.persistence_impl.PersistenceImpl;
import br.com.sddbrc.replication.IReplication;

public class InitApplication {

    private final String clazz = "br.com.sddbrc.replicationImpl.ReplicationEasyImpl";
    private PersistenceImpl persistence = new PersistenceImpl();
    private ConfigurationConnection_DBImpl configurationConnection = new ConfigurationConnection_DBImpl();
    private Runtime runtime = new Runtime();
    private ConnectionImpl connection = new ConnectionImpl();
    private static InitApplication initApplication = new InitApplication();

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
        runtime.setReplicationClass((IReplication) Class.forName(clazz).newInstance());
    }

    public void startPersistence() throws Exception {
        persistence.init(configurationConnection.getDatabasesWithConfiguration());
    }
}
