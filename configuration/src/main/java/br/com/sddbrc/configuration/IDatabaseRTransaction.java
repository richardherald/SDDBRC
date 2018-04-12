package br.com.sddbrc.configuration;

import br.com.sddbrc.commons.model.Databases_R_Transactions;
import java.util.List;

public interface IDatabaseRTransaction {
    public int insert (Databases_R_Transactions databaseRTransaction) throws Exception;
    public List<Databases_R_Transactions> getAllTransactionsWhereSincronizationIsFalse(String arrayDatabases) throws Exception;
}
