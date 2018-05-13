package br.com.sddbrc.core;

import br.com.sddbrc.commons.model.CommandJDBC;
import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.commons.model.Databases_R_Transactions;
import br.com.sddbrc.commons.model.Transaction;
import br.com.sddbrc.commons.model.enums.Sincronization;
import br.com.sddbrc.configuration_impl.DatabaseRTransactionImpl;
import br.com.sddbrc.configuration_impl.TransactionImpl;
import br.com.sddbrc.persistence_impl.PersistenceImpl;
import br.com.sddbrc.replication.IReplication;
import java.util.List;

public class Runtime {

    private IReplication replicationClass;
    private PersistenceImpl persistence = new PersistenceImpl();
    private DatabaseRTransactionImpl transactions = new DatabaseRTransactionImpl();
    private TransactionImpl transactionImpl = new TransactionImpl();
    private boolean ReplicationIsRun = false;

    public void schedulerReplication() throws Exception {
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
                System.out.println("replicacao rodando");
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Object execute(CommandJDBC command) throws Exception {
        try {
            Object object = null;
            command.setCon(persistence.getPOLL_MASTER().getDatasource().getConnection());
            if (persistence.isSelect(command.getQuery())) {
                object = persistence.executeQuery(command);
            } else {
                object = persistence.executeUpdate(command);
                int transactionId = transactionImpl.insert(new Transaction(null, command.getQuery()));
                for (Databases database : persistence.getPOOLS()) {
                    transactions.insert(new Databases_R_Transactions(null, transactionId, database.getDatabase_Id(), Sincronization.NAO_SINCRONIZADO.getCodigo(), null, null));
                }   
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
