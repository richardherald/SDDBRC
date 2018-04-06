package br.com.configuration_impl;

import br.com.commons.model.Transaction;
import br.com.configuration.ITransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionImpl extends Util implements ITransaction {

    @Override
    public int insert(Transaction obj) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("INSERT INTO [SDDBRC].[dbo].[Transaction] ([transaction_Script]) VALUES (?)");
            ps.setString(1, obj.getTransaction_Script());
            int returnValue = ps.executeUpdate();
            return returnGeneratedKeys(ps, returnValue);
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(null, ps, conn);
        }
    }
}
