package br.com.sddbrc.replication_impl;

import br.com.commons.model.Database;
import br.com.persistence_impl.PersistenceImpl;
import br.com.replicacao.IReplication;
import java.util.List;

public class ReplicationEasyImpl extends IReplication {

    private final PersistenceImpl persistence = PersistenceImpl.getInstance();

    @Override
    public Object algorithmReplication(List<Database> datasources, String command) throws Exception {
        Object value = new Object();
        try {
            for (Database database : datasources) {
                value = persistence.executeUpdate(database.getDatasource().getConnection(),command);
            }
        } catch (Exception e) {
            throw e;
        }
        return value;
    }
}
