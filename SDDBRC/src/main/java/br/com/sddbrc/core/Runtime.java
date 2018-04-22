package br.com.sddbrc.core;

import br.com.sddbrc.commons.model.CommandJDBC;
import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.commons.model.Databases_R_Transactions;
import br.com.sddbrc.commons.model.Identifier;
import br.com.sddbrc.commons.model.Transaction;
import br.com.sddbrc.configuration_impl.Util;
import br.com.sddbrc.configuration_impl.ConfigurationConnection_DBImpl;
import br.com.sddbrc.configuration_impl.DatabaseRTransactionImpl;
import br.com.sddbrc.configuration_impl.IdentifierImpl;
import br.com.sddbrc.configuration_impl.TransactionImpl;
import br.com.sddbrc.persistence_impl.PersistenceImpl;
import br.com.sddbrc.replication.IReplication;
import java.sql.Timestamp;
import java.util.List;

public class Runtime {

    private static Runtime runtime;
    protected static IReplication replicationClass;
    private static Databases datasource_Master = null;
    private final PersistenceImpl persistence = PersistenceImpl.getInstance();
    private final TransactionImpl transaction = new TransactionImpl();
    private final DatabaseRTransactionImpl databaseRtransaction = new DatabaseRTransactionImpl();
    private final ConfigurationConnection_DBImpl configConnection = ConfigurationConnection_DBImpl.getInstance();
    private boolean ReplicationIsRun = false;
    private final IdentifierImpl identifier = IdentifierImpl.getInstance();

    public static Runtime getInstance() {
        if (runtime == null) {
            runtime = new Runtime();
        }
        return runtime;
    }

    public void teste() throws Exception {

        // SELECT //
        CommandJDBC select = new CommandJDBC();
        select.setQuery("SELECT TOP (10) * FROM [TESTE].[dbo].[Pessoa]");
        select.setGeneratedKeys(false);
        Runtime.getInstance().execute(select);

        // INSERT SEM RETORNO DO DO NOVO ID DO REGISTRO //
        CommandJDBC insertSemRetorno = new CommandJDBC();

        insertSemRetorno.setQuery("INSERT INTO [TESTE].[dbo].[Pessoa] ([pessoa_Nome] ,[pessoa_Cpf] ,[pessoa_sexo] ,[pessoa_DataNascimento] ,[pessoa_Email]) VALUES ('teste123', '123' ,'M' ,getdate() ,'teste@teste.com.br')");
        insertSemRetorno.setGeneratedKeys(false);
        Runtime.getInstance().execute(insertSemRetorno);

        // INSERT COM RETORNO DO DO NOVO ID DO REGISTRO //
        CommandJDBC insertComRetorno = new CommandJDBC();

        insertComRetorno.setDML("INSERT");
        insertComRetorno.setQuery("INSERT INTO TESTE.dbo.Pessoa ([pessoa_Nome] ,[pessoa_Cpf] ,[pessoa_sexo] ,[pessoa_DataNascimento] ,[pessoa_Email]) VALUES ('teste123', '123' ,'M' ,getdate() ,'teste@teste.com.br')");
        insertComRetorno.setGeneratedKeys(true);
        int retorno = (int) Runtime.getInstance().execute(insertComRetorno);

        // UPDATE //
        CommandJDBC update = new CommandJDBC();
        update.setQuery("UPDATE [TESTE].[dbo].[Pessoa] SET [pessoa_Nome] = 'mudou o nome' WHERE pessoa_Id =  " + retorno);
        update.setGeneratedKeys(false);
        Runtime.getInstance().execute(update);

        // DELETE //
        CommandJDBC delete = new CommandJDBC();
        delete.setQuery("DELETE FROM [TESTE].[dbo].[Pessoa] WHERE pessoa_Id = " + retorno);
        delete.setGeneratedKeys(false);
        Runtime.getInstance().execute(delete);

    }

    public void ThreadReplication() throws Exception {
        try {
            while (true) {
                if (!ReplicationIsRun) {
                    ReplicationIsRun = true;
                    String databaseConnectionsValids = PersistenceImpl.getInstance().testConnection();
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

    public Object execute(CommandJDBC command) throws Exception {
        Util util = new Util();
        if (persistence.isSelect(command.getQuery())) {
            return persistence.executeQuery(command.getCon(), command.getQuery());
        } else if (persistence.isInsert(command.getQuery())) {
            Identifier ident = identifier.getByTable(util.extractTableByQuery(command.getQuery()));
            command.setQuery(util.concatTableIdOnQuery(command.getQuery(), ident.getIdentifier_NameTableId(), ident.getIdentifier_Value()));
            return (Object) persistence.executeUpdate(getDatasource_Master().getDatasource().getConnection(), command.getQuery(), command.isGeneratedKeys());
        } else {
            return (Object) persistence.executeUpdate(getDatasource_Master().getDatasource().getConnection(), command.getQuery(), command.isGeneratedKeys());
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

    public static IReplication getReplicationClass() {
        return replicationClass;
    }

    public static void setReplicationClass(IReplication aReplicationClass) {
        replicationClass = aReplicationClass;
    }

    public static Databases getDatasource_Master() {
        return datasource_Master;
    }

    public static void setDatasource_Master(Databases aDatasource_Master) {
        datasource_Master = aDatasource_Master;
    }

}
