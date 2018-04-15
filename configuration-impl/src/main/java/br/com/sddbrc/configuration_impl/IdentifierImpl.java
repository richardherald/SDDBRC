package br.com.sddbrc.configuration_impl;

import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.commons.model.Identifier;
import br.com.sddbrc.configuration.IIdentifier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IdentifierImpl extends Util implements IIdentifier {

    private static IdentifierImpl identifierImpl;

    public static IdentifierImpl getInstance() {
        return getIdentifierImpl() == null ? new IdentifierImpl() : identifierImpl;
    }

    @Override
    public int insert(Identifier identifier) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("INSERT INTO [dbo].[Identifier]([identifier_Tabela],[identifier_Value],[databases_Id])VALUES(?,?,4)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, identifier.getIdentifier_Table());
            ps.setInt(2, identifier.getIdentifier_Value());
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

    @Override
    public Identifier getByTable(String table) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("select * from Identifier where identifier_Table like ?");
            ps.setString(1, table);
            rs = ps.executeQuery();
            Identifier identifier = null;
            while (rs.next()) {
                identifier = new Identifier();
                identifier.setIdentifier_Id(rs.getInt("identifier_Id"));
                identifier.setIdentifier_Table(rs.getString("identifier_Table"));
                identifier.setIdentifier_Value(rs.getInt("identifier_Value"));
            }
            return identifier;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int update(Identifier identifier) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("UPDATE [dbo].[Identifier] SET [identifier_Tabela] = ?,[identifier_Value] = ? WHERE identifier_Id = ?");
            ps.setString(1, identifier.getIdentifier_Table());
            ps.setInt(2, identifier.getIdentifier_Value());
            ps.setInt(3, identifier.getIdentifier_Id());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(null, ps, conn);
        }
    }

    public static IdentifierImpl getIdentifierImpl() {
        return identifierImpl;
    }

    public static void setIdentifierImpl(IdentifierImpl identifierImpl) {
        IdentifierImpl.identifierImpl = identifierImpl;
    }

}
