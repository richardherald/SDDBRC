package br.com.sddbrc.core;

import br.com.sddbrc.configuration_impl.ConfigurationConnection_DBImpl;
import br.com.sddbrc.configuration_impl.DatabaseRConfigurationImpl;
import br.com.sddbrc.connection_impl.ConnectionImpl;
import br.com.sddbrc.persistence_impl.PersistenceImpl;
import br.com.sddbrc.replication.IReplication;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InitApplication {

    private final String classReplication = "br.com.sddbrc.replicationImpl.ReplicationPrimaryCopyAsynchronousImpl";
    private final String classPersistence = "br.com.sddbrc.persistence_impl.PersistenceImpl";
    private PersistenceImpl persistence = new PersistenceImpl();
    private ConfigurationConnection_DBImpl configurationConnection = new ConfigurationConnection_DBImpl();
    private DatabaseRConfigurationImpl databaseRConfiguration = new DatabaseRConfigurationImpl();
    private Runtime runtime = new Runtime();
    private ConnectionImpl connection = new ConnectionImpl();
    private static InitApplication initApplication = new InitApplication();

    public static void main(String[] args) throws Exception {
        System.out.println("Ligando Configuracoes");
        initApplication.startConfiguration();
        System.out.println("Ligando Persistencia");
        initApplication.startPersistence();
        System.out.println("Ligando Replicacao");
        initApplication.startReplication();
//        initApplication.schedulerReplication();
        System.out.println("Ligando Servidor Socket");
        initApplication.startServerSocket();
    }

    public void schedulerReplication() throws Exception {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runtime.schedulerReplication();
                } catch (Exception ex) {
                    Logger.getLogger(InitApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
    }

    public void startServerSocket() throws Exception {
        connection.socket();
    }

    public void startConfiguration() throws Exception {
        configurationConnection.loadConfiguration();
    }

    public void startReplication() throws Exception {
        runtime.setReplicationClass((IReplication) Class.forName(classReplication).newInstance());
    }

    public void startPersistence() throws Exception {
        persistence.init(databaseRConfiguration.getDatabasesWithConfiguration(), classPersistence);
    }
}
