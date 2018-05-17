package br.com.sddbrc.configuration_impl;

import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.configuration.IDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl extends Util implements IDatabase {

    @Override
    public List<Databases> getAll() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT * FROM SDDBRC_database WHERE sddbrc_database_active = 1");
            rs = ps.executeQuery();
            List<Databases> bancos = new ArrayList<>();
            while (rs.next() == true) {
                Databases banco = new Databases();
                banco.setDatabase_Id(rs.getInt("sddbrc_database_id"));
                banco.setDatabase_Name(rs.getString("sddbrc_database_name"));
                banco.setDatabase_Principal(rs.getBoolean("sddbrc_database_principal"));
                banco.setDatabase_Priority(rs.getInt("sddbrc_database_priority"));
                banco.setDatabase_Active(rs.getBoolean("sddbrc_database_active"));
                bancos.add(banco);
            }
            return bancos;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(rs, ps, conn);
        }
    }
}
