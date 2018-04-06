package br.com.configuration_impl;

import br.com.commons.model.Database;
import br.com.configuration.IDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl implements IDatabase {

    @Override
    public List<Database> getAll() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
//            conn = getConnectionMiddleware();
            conn = null;
            ps = conn.prepareStatement("select * from Banco");
            rs = ps.executeQuery();
            List<Database> bancos = new ArrayList<>();
            while (rs.next()) {
                Database banco = new Database();
                banco.setDatabase_Id(rs.getInt("banco_Id"));
                banco.setDatabase_Name(rs.getString("banco_Nome"));
                banco.setDatabase_Principal(rs.getBoolean("banco_Principal"));
                banco.setDatabase_Driver(rs.getString("banco_Driver"));
                banco.setDatabase_Priority(rs.getInt("banco_Prioridade"));
                banco.setDatabase_Active(rs.getBoolean("banco_Prioridade"));
                bancos.add(banco);
            }
            return bancos;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
}
