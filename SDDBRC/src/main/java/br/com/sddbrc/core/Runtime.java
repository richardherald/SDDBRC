package br.com.sddbrc.core;

import br.com.sddbrc.commons.model.CommandJDBC;
import br.com.sddbrc.configuration_impl.Util;
import br.com.sddbrc.configuration_impl.ConfigurationConnection_DBImpl;
import br.com.sddbrc.configuration_impl.DatabaseRTransactionImpl;
import br.com.sddbrc.configuration_impl.IdentifierImpl;
import br.com.sddbrc.configuration_impl.TransactionImpl;
import br.com.sddbrc.connection_impl.ConnectionImpl;
import br.com.sddbrc.persistence_impl.PersistenceImpl;
import br.com.sddbrc.replication.IReplication;

public class Runtime {

    protected IReplication replicationClass;

    private ConfigurationConnection_DBImpl configConnection = new ConfigurationConnection_DBImpl();
    private DatabaseRTransactionImpl databaseRtransaction = new DatabaseRTransactionImpl();
    private final PersistenceImpl persistence = new PersistenceImpl();
    private IdentifierImpl identifier = new IdentifierImpl();
    private TransactionImpl transaction = new TransactionImpl();
    private ConnectionImpl connectionImpl = new ConnectionImpl();

    private boolean ReplicationIsRun = false;

    public Object execute(CommandJDBC command) throws Exception {
        Util util = new Util();
        if (persistence.isSelect(command.getQuery())) {
            Object object = persistence.executeQuery(command.getCon(), command.getQuery());
            return object;
        } else if (persistence.isInsert(command.getQuery())) {
//            Identifier ident = identifier.getByTable(util.extractTableByQuery(command.getQuery()));
//            command.setQuery(util.concatTableIdOnQuery(command.getQuery(), ident.getIdentifier_NameTableId(), ident.getIdentifier_Value()));
//            return persistence.executeUpdate(persistence.getPOLL_MASTER().getDatasource().getConnection(), command.getQuery(), command.isGeneratedKeys());
            return persistence.executeUpdate(command.getCon(), command.getQuery(), command.isGeneratedKeys());
        } else {
            return persistence.executeUpdate(command.getCon(), command.getQuery(), command.isGeneratedKeys());
        }
//            for (int i = 0; i < PersistenceImpl.getPOOLS().size(); i++) {
//                Databases database = PersistenceImpl.getPOOLS().get(i);
//                int transactionId = transaction.insert(new Transaction(null, command.getCommand()));
//                int databaseRtransactionId;
//                if (database.getDatabase_Principal()) {
//                    databaseRtransactionId = databaseRtransaction.insert(new Databases_R_Transactions(null, transactionId, getDatasource_Master().getDatabase_Id(), 1, new Timestamp(System.currentTimeMillis()), null));
//                } else {
//                    databaseRtransactionId = databaseRtransaction.insert(new Databases_R_Transactions(null, transactionId, getDatasource_Master().getDatabase_Id(), 0, new Timestamp(System.currentTimeMillis()), null));
//                }
//            }
    }

    public IReplication getReplicationClass() {
        return replicationClass;
    }

    public void setReplicationClass(IReplication aReplicationClass) {
        replicationClass = aReplicationClass;
    }
}
