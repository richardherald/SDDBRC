package br.com.sddbrc.core;

import br.com.commons.model.Transaction;
import br.com.configuration_impl.ConfigurationConnection_DBImpl;
import br.com.configuration_impl.TransactionImpl;
import br.com.persistence_impl.PersistenceImpl;
import br.com.replicacao.IReplication;
import javax.sql.DataSource;

public class Runtime {

    private static Runtime runtime;
    private static DataSource datasource_Master;
    private static IReplication replicationClass;
    private final PersistenceImpl persistence = new PersistenceImpl();
    private final TransactionImpl transaction = new TransactionImpl();
    private final ConfigurationConnection_DBImpl configConnection = ConfigurationConnection_DBImpl.getInstance();

    public static Runtime getInstance() {
        if (runtime == null) {
            runtime = new Runtime();
        }
        return runtime;
    }
    
    public Object execute(String command) throws Exception {
        if (persistence.isSelect(command)){
            return persistence.executeQuery(datasource_Master.getConnection(), command);
        } else {
            Object returnValue = persistence.executeUpdate(datasource_Master.getConnection(), command);
            int transactionId = transaction.insert(new Transaction(null, command, null));
            
            
           return replicationClass.algorithmReplication(persistence.getInstance().getDatasources(),command);
        }
    }

    public static IReplication getReplicationClass() {
        return replicationClass;
    }

    public static void setReplicationClass(IReplication aReplicationClass) {
        replicationClass = aReplicationClass;
    }
}
