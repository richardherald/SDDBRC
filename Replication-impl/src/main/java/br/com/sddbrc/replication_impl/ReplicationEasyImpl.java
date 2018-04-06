package br.com.sddbrc.replication_impl;

import br.com.persistence_impl.PersistenceImpl;
import br.com.replicacao.IReplication;
import java.util.Map;
import javax.sql.DataSource;

public class ReplicationEasyImpl extends IReplication {

    private final PersistenceImpl persistence = PersistenceImpl.getInstance();

    @Override
    public Object algorithmReplication(Map<Integer, DataSource> datasources, String command) throws Exception {
        Object value = new Object();
        try {
            for (DataSource datasource : datasources.values()) {
                value = persistence.executeUpdate(datasource.getConnection(),command);
            }
        } catch (Exception e) {
            throw e;
        }
        return value;
    }
}
