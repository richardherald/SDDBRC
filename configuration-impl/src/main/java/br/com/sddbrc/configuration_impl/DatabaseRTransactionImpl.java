package br.com.sddbrc.configuration_impl;

import br.com.sddbrc.commons.model.Databases_R_Transactions;
import br.com.sddbrc.commons.model.enums.Sincronization;
import br.com.sddbrc.configuration.IDatabaseRTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRTransactionImpl extends Util implements IDatabaseRTransaction {

    @Override
    public int insert(Databases_R_Transactions databaseRTransaction) throws Exception {
         Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("INSERT INTO [SDDBRC].[dbo].[SDDBRC_Database_R_SDDBRC_Transaction] ([sddbrc_transaction_id] ,[sddbrc_database_id] ,[sddbrc_sincronization_id] ,[sddbrc_database_r_sddbrc_transaction_dateSincronization])  (?,?,?,?)");
            ps.setInt(1, databaseRTransaction.getTransaction_Id());
            ps.setInt(2, databaseRTransaction.getDatabase_Id());
            ps.setInt(3, Sincronization.NAO_SINCRONIZADO.getCodigo());
            ps.setString(4, null);
            int returnValue = ps.executeUpdate();
            return returnGeneratedKeys(ps, returnValue);
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(rs, ps, conn);
        }
    }

    @Override
    public List<Databases_R_Transactions> getAllTransactionsWhereSincronizationIsFalse(String arrayDatabases) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT * FROM SDDBRC_Database_R_SDDBRC_Transaction as databaseRtransaction INNER JOIN SDDBRC_Transaction as transaction ON (databaseRtransaction.sddbrc_transaction_id = sddbrc_transaction.transaction_id WHERE sddbrc_sincronization_id = 0 AND databaseRtransaction.sddbrc_database_id in (" + arrayDatabases + ") ORDER BY databaseRtransaction.sddbrc_database_id)");
            rs = ps.executeQuery();
            List<Databases_R_Transactions> databasesRTransactions = new ArrayList<>();
            while (rs.next()) {
                Databases_R_Transactions databaseRtransaction = new Databases_R_Transactions();
                databaseRtransaction.setDatabase_R_Transaction_Id(rs.getInt("sddbrc_database_R_sddbrc_transaction_id"));
                databaseRtransaction.setTransaction_Id(rs.getInt("sddbrc_transaction_id"));
                databaseRtransaction.setDatabase_Id(rs.getInt("sddbrc_database_id"));
                databaseRtransaction.setSincronization_Id(rs.getInt("sddbrc_sincronization_id"));
                databaseRtransaction.setDatabase_R_Transaction_DateSincronization(rs.getTimestamp("sddbrc_database_R_sddbrc_transaction_dateSincronization"));
                databaseRtransaction.getTransaction().setTransaction_Script("sddbrc_transaction_script");
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