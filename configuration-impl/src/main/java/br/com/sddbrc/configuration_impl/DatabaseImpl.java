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
            ps = conn.prepareStatement("select * from Databases");
            rs = ps.executeQuery();
            List<Databases> bancos = new ArrayList<>();
            while (rs.next() == true) {
                Databases banco = new Databases();
                banco.setDatabase_Id(rs.getInt("databases_Id"));
                banco.setDatabase_Name(rs.getString("databases_Name"));
                banco.setDatabase_Principal(rs.getBoolean("databases_Principal"));
                banco.setDatabase_Driver(rs.getString("databases_Driver"));
                banco.setDatabase_Priority(rs.getInt("databases_Priority"));
                banco.setDatabase_Active(rs.getBoolean("databases_Active"));
                banco.setDatabase_ClassDatasource(rs.getString("databases_ClassDataSource"));
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
