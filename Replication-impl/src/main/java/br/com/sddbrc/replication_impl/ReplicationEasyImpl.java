package br.com.sddbrc.replication_impl;

import br.com.commons.model.Databases;
import br.com.commons.model.Databases_R_Transactions;
import br.com.persistence_impl.PersistenceImpl;
import br.com.replicacao.IReplication;
import java.sql.Connection;
import java.util.List;

public class ReplicationEasyImpl extends IReplication {

    private final PersistenceImpl persistence = PersistenceImpl.getInstance();

    @Override
    public void algorithmReplication(List<Databases> datasources, List<Databases_R_Transactions> transactions) throws Exception {
        try {
            int databaseId = 0;
            Connection conn = null;
            for (int i = 0; i < transactions.size(); i++) {
                if (databaseId != transactions.get(i).getDatabase_Id()) {
                    databaseId = transactions.get(i).getDatabase_Id();
                    conn = persistence.ReturnConnection(datasources, databaseId);
                }
                persistence.executeUpdate(conn, transactions.get(i).getTransaction().getTransaction_Script());
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
