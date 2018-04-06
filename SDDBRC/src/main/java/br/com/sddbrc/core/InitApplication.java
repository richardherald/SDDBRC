package br.com.sddbrc.core;

import br.com.commons.model.Database;
import br.com.configuration_impl.ConfigurationConnection_DBImpl;
import br.com.persistence_impl.PersistenceImpl;
import br.com.replicacao.IReplication;
import java.util.List;

public class InitApplication {

    private final String clazz = "ReplicationEasyImpl";
    private PersistenceImpl persistence = PersistenceImpl.getInstance();
    private ConfigurationConnection_DBImpl configurationConnection = ConfigurationConnection_DBImpl.getInstance();

    public void main(String[] args) throws Exception {
        startConfiguration();
        starPersistence();
        startReplication();
        startRuntime();
    }

    public void startRuntime() {
        Runtime.getInstance();
    }

    public void startConfiguration() throws Exception {
        configurationConnection.loadConfiguration();
    }

    public void startReplication() throws Exception {
        Runtime.getInstance().setReplicationClass((IReplication) Class.forName(clazz).newInstance());
    }

    public void starPersistence() throws Exception {
        List<Database> POOLS = configurationConnection.getDatabasesWithConfiguration();
        persistence.setPOOLS(POOLS);
        persistence.init(persistence.getPOOLS());
    }
}
