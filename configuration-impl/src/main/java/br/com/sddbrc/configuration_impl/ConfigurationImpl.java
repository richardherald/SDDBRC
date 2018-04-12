package br.com.sddbrc.configuration_impl;

import br.com.sddbrc.commons.model.Configurations;
import br.com.sddbrc.configuration.IConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationImpl extends Util implements IConfiguration {

    @Override
    public Configurations getByDatabaseId(int databaseId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("select * from Configurations where databases_Id = ?");
            ps.setInt(1, databaseId);
            rs = ps.executeQuery();
            Configurations config = new Configurations();
            while (rs.next()) {
                config.setConfiguration_Id(rs.getInt("configuration_Id"));
                config.setConfiguration_Poolname(rs.getString("configuration_Poolname"));
                config.setConfiguration_Jdbcurl(rs.getString("configuration_Jdbcurl"));
                config.setConfiguration_Username(rs.getString("configuration_Username"));
                config.setConfiguration_Password(rs.getString("configuration_Password"));
                config.setConfiguration_Maxpoolsize(rs.getInt("configuration_Maxpoolsize"));
                config.setConfiguration_Cachesize(rs.getInt("configuration_Cachesize"));
                config.setConfiguration_Cachesizelimit(rs.getInt("configuration_Cachesizelimit"));
            }
            return config;
        } catch (SQLException e) {
            throw e;
        }
    }
}
