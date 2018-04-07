package br.com.sddbrc.core;

import br.com.commons.model.Databases;
import br.com.commons.model.Databases_R_Transactions;
import br.com.commons.model.Transaction;
import br.com.configuration_impl.ConfigurationConnection_DBImpl;
import br.com.configuration_impl.DatabaseRTransactionImpl;
import br.com.configuration_impl.TransactionImpl;
import br.com.persistence_impl.PersistenceImpl;
import br.com.replicacao.IReplication;
import java.sql.Timestamp;
import java.util.List;

public class Runtime {

    private static Runtime runtime;
    private static Databases datasource_Master;
    private static IReplication replicationClass;
    private final PersistenceImpl persistence = new PersistenceImpl();
    private final TransactionImpl transaction = new TransactionImpl();
    private final DatabaseRTransactionImpl databaseRtransaction = new DatabaseRTransactionImpl();
    private final ConfigurationConnection_DBImpl configConnection = ConfigurationConnection_DBImpl.getInstance();
    private boolean ReplicationIsRun = false;

    public static Runtime getInstance() {
        if (runtime == null) {
            runtime = new Runtime();
        }
        return runtime;
    }

    public void ThreadReplication() throws Exception {
        try {
            while (true) {
                if (!ReplicationIsRun) {
                    ReplicationIsRun = true;
                    String databaseConnectionsValids = persistence.testConnection();
                    List<Databases_R_Transactions> databasesRTransactions = databaseRtransaction.getAllTransactionsWhereSincronizationIsFalse(databaseConnectionsValids);
                    replicationClass.algorithmReplication(PersistenceImpl.getPOOLS(), databasesRTransactions);
                    ReplicationIsRun = false;
                }
                Thread.sleep(10000);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Object execute(String command) throws Exception {
        if (persistence.isSelect(command)) {
            return persistence.executeQuery(datasource_Master.getDatasource().getConnection(), command);
        } else {
            Object returnValue = persistence.executeUpdate(datasource_Master.getDatasource().getConnection(), command);
            for (int i = 0; i < PersistenceImpl.getPOOLS().size(); i++) {
                Databases database = PersistenceImpl.getPOOLS().get(i);
                int transactionId = transaction.insert(new Transaction(null, command));
                int databaseRtransactionId;
                if (database.getDatabase_Principal()) {
                    databaseRtransactionId = databaseRtransaction.insert(new Databases_R_Transactions(null, transactionId, datasource_Master.getDatabase_Id(), 1, new Timestamp(System.currentTimeMillis()), null));
                } else {
                    databaseRtransactionId = databaseRtransaction.insert(new Databases_R_Transactions(null, transactionId, datasource_Master.getDatabase_Id(), 0, new Timestamp(System.currentTimeMillis()), null));
                }
            }
            return returnValue;
        }
    }

    public static IReplication getReplicationClass() {
        return replicationClass;
    }

    public static void setReplicationClass(IReplication aReplicationClass) {
        replicationClass = aReplicationClass;
    }
}
