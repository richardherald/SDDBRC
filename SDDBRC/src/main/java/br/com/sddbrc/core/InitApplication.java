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
        starPersistence(ConfigurationConnection_DBImpl.getListDatabases());
        startReplication();
    }
    
    public void startConfiguration() throws Exception{
        configurationConnection.loadConfiguration();
    }
    
    public void startReplication() throws Exception{
        Runtime.getInstance().setReplicationClass((IReplication) Class.forName(clazz).newInstance());
    }
    
    public void starPersistence(List<Database> listDataBases) throws Exception{
        persistence.init(listDataBases);
    }

}
