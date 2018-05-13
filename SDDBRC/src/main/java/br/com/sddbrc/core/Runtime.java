package br.com.sddbrc.core;

import br.com.sddbrc.commons.model.CommandJDBC;
import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.commons.model.Databases_R_Transactions;
import br.com.sddbrc.configuration_impl.DatabaseRTransactionImpl;
import br.com.sddbrc.persistence_impl.PersistenceImpl;
import br.com.sddbrc.replication.IReplication;
import java.util.List;

public class Runtime {

    private IReplication replicationClass;
    private PersistenceImpl persistence = new PersistenceImpl();
    private DatabaseRTransactionImpl transactions = new DatabaseRTransactionImpl();
    private boolean ReplicationIsRun = false;

    public void ThreadReplication() throws Exception {
        try {
            while (true) {
                if (!ReplicationIsRun) {
                    ReplicationIsRun = true;
                    List<Databases> databases = persistence.ListDatabaseActiveForReplication();
                    String databasesId = "0";
                    for (Databases database : databases) {
                        databasesId += "," + database.getDatabase_Id();
                    }
                    List<Databases_R_Transactions> ListOfTransactions = transactions.getAllTransactionsWhereSincronizationIsFalse(databasesId);
                    replicationClass.algorithm(databases, ListOfTransactions);
                    ReplicationIsRun = false;
                }
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Object execute(CommandJDBC command) throws Exception {
        try {
            Object object = null;
            if (persistence.isSelect(command.getQuery())) {
                object = persistence.executeQuery(command);
            } else if (persistence.isInsert(command.getQuery())) {
                object = persistence.executeUpdate(command);
            }
            return object;
        } catch (Exception e) {
            throw e;
        }
    }

    public IReplication getReplicationClass() {
        return replicationClass;
    }

    public void setReplicationClass(IReplication aReplicationClass) {
        replicationClass = aReplicationClass;
    }
}
