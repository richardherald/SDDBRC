package br.com.sddbrc.core;

import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.configuration_impl.ConfigurationConnection_DBImpl;
import br.com.sddbrc.persistence_impl.PersistenceImpl;
import java.util.List;

public class InitApplication {

    private final String clazz = "br.com.sddbrc.ReplicationImpl.ReplicationEasyImpl";
    private PersistenceImpl persistence = PersistenceImpl.getInstance();
    private ConfigurationConnection_DBImpl configurationConnection = ConfigurationConnection_DBImpl.getInstance();
    private static InitApplication init = new InitApplication();

    public static void main(String[] args) throws Exception {
        init.startConfiguration();
        init.startPersistence();
        init.startRuntime();
        Runtime.getInstance().teste();
//        init.startReplication();
    }

    public void startRuntime() {
        Runtime.getInstance();
    }

    public void startConfiguration() throws Exception {
        configurationConnection.loadConfiguration();
    }

    public void startReplication() throws Exception {
//            Runtime.replicationClass = (IReplication) Class.forName(clazz).newInstance();
//            Runtime.setReplicationClass((ReplicationEasyImpl) Class.forName(clazz).newInstance());
    }

    public void startPersistence() throws Exception {
        List<Databases> POOLS = configurationConnection.getDatabasesWithConfiguration();
        for (Databases database : POOLS){
            if (database.getDatabase_Principal()){
                Runtime.setDatasource_Master(database);
                break;
            }
        }
        PersistenceImpl.setPOOLS(POOLS);
        persistence.init(PersistenceImpl.getPOOLS());
    }
}
