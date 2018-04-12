package br.com.sddbrc.configuration_impl;

import br.com.sddbrc.commons.model.Databases_R_Transactions;
import br.com.sddbrc.configuration.IDatabaseRTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRTransactionImpl extends Util implements IDatabaseRTransaction {

    @Override
    public int insert(Databases_R_Transactions databaseRTransaction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Databases_R_Transactions> getAllTransactionsWhereSincronizationIsFalse(String arrayDatabases) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT * FROM Database_R_Transaction as databaseRtransaction INNER JOIN Transaction as transaction ON (databaseRtransaction.transaction_Id = transaction.transaction_Id WHERE sincronization_Id = 0 AND databaseRtransaction.database_Id in (" + arrayDatabases + ") ORDER BY databaseRtransaction.database_Id)");
            rs = ps.executeQuery();
            List<Databases_R_Transactions> databasesRTransactions = new ArrayList<>();
            while (rs.next()) {
                Databases_R_Transactions databaseRtransaction = new Databases_R_Transactions();
                databaseRtransaction.setDatabase_R_Transaction_Id(rs.getInt("database_R_Transaction_Id"));
                databaseRtransaction.setTransaction_Id(rs.getInt("transaction_Id"));
                databaseRtransaction.setDatabase_Id(rs.getInt("database_Id"));
                databaseRtransaction.setSincronization_Id(rs.getInt("sincronization_Id"));
                databaseRtransaction.setDatabase_R_Transaction_DateSincronization(rs.getTimestamp("database_R_Transaction_DateSincronization"));
                databaseRtransaction.getTransaction().setTransaction_Script("transaction_Script");
                databasesRTransactions.add(databaseRtransaction);
            }
            return databasesRTransactions;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(rs, ps, conn);
        }
    }
}
