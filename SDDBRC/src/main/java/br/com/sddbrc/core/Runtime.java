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
import java.sql.Timestamp;
import java.util.List;

public class Runtime {

    private IReplication replicationClass;
    private final PersistenceImpl persistence;
    private final DatabaseRTransactionImpl transactions;
    private final TransactionImpl transactionImpl;
    private boolean ReplicationIsRun;

    public Runtime() {
        replicationClass = null;
        persistence = new PersistenceImpl();
        transactions = new DatabaseRTransactionImpl();
        transactionImpl = new TransactionImpl();
    }

    @SuppressWarnings("SleepWhileInLoop")
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
                    List<Databases_R_Transactions> listOfTransactions = transactions.getAllTransactionsWhereSincronizationIsFalse(databasesId);
                    if (!listOfTransactions.isEmpty()) {
                        replicationClass.algorithm(databases, listOfTransactions);
                    } else {
                        System.out.println("Não existem linhas para serem replicadas!!");
                    }
                    ReplicationIsRun = false;
                } else {
                    System.out.println("Replicação está sendo executada!");
                }
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Object execute(CommandJDBC command) throws Exception {
        try {
            Object object;
            command.setCon(persistence.getPOLL_MASTER().getDatasource().getConnection());
            if (persistence.findScriptByName(command.getQuery(), "SELECT")) {
                object = persistence.executeQuery(command);
            } else {
                object = persistence.executeUpdate(command);
                int transactionId = transactionImpl.insert(new Transaction(null, command.getQuery()));
                for (Databases database : persistence.getPOOLS()) {
                    Databases_R_Transactions databaseRtransaction;
                    if (database.getDatabase_Principal()) {
                        databaseRtransaction = new Databases_R_Transactions(null, transactionId, database.getDatabase_Id(), Sincronization.SINCRONIZADO.getCodigo(), new Timestamp(System.currentTimeMillis()), null);
                    } else {
                        databaseRtransaction = new Databases_R_Transactions(null, transactionId, database.getDatabase_Id(), Sincronization.NAO_SINCRONIZADO.getCodigo(), null, null);
                    }
                    transactions.insert(databaseRtransaction);
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
