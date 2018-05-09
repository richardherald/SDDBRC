package br.com.sddbrc.replicationImpl;

import br.com.sddbrc.commons.model.CommandJDBC;
import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.commons.model.Databases_R_Transactions;
import br.com.sddbrc.persistence_impl.PersistenceImpl;
import br.com.sddbrc.replication.IReplication;
import java.sql.Connection;
import java.util.List;

public class ReplicationEasyImpl extends IReplication {

    private PersistenceImpl persistence = new PersistenceImpl();
    private br.com.sddbrc.core.Runtime runtime = new br.com.sddbrc.core.Runtime();
    
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
                persistence.executeUpdate(conn, transactions.get(i).getTransaction().getTransaction_Script(),true);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void algorithmReplication(List<Databases> databases, CommandJDBC commandJDBC) throws Exception {
        Connection conn = persistence.getPOLL_MASTER().getDatasource().getConnection();
        conn.setAutoCommit(commandJDBC.isBeginTransaction());
        commandJDBC.setCon(conn);
        runtime.execute(commandJDBC);
        if (commandJDBC.isBeginTransaction()) {
            conn.commit();
        }
        //LOGICA DOS OUTROS BANCOS
        for (int i = 0; i < databases.size(); i++) {
            Databases dbs = databases.get(i);
            
        }
    }
}
