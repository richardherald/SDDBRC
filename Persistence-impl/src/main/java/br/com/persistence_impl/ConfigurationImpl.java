package br.com.persistence_impl;

import br.com.commons.model.Configuration;
import br.com.persistence.IConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationImpl extends Metodos implements IConfiguration {

    @Override
    public List<Configuration> getByDatabaseId(int databaseId) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnectionMiddleware();
            ps = conn.prepareStatement("select * from ConfigBanco where banco_Id = ?");
            ps.setInt(1, databaseId);
            rs = ps.executeQuery();
            List<Configuration> configurations = new ArrayList<>();
            while (rs.next()) {
                Configuration config = new Configuration();
                config.setConfiguration_Id(rs.getInt("configuration_Id"));
                config.setConfiguration_Poolname(rs.getString("configuration_Poolname"));
                config.setConfiguration_PoolJdbcurl(rs.getString("configuration_PoolJdbcurl"));
                config.setConfiguration_Username(rs.getString("configuration_Username"));
                config.setConfiguration_Password(rs.getString("configuration_Password"));
                config.setConfiguration_Maxpoolsize(rs.getInt("configuration_Maxpoolsize"));
                config.setConfiguration_Cachesize(rs.getInt("configuration_Cachesize"));
                config.setConfiguration_Cachesizelimit(rs.getInt("configuration_Cachesizelimit"));
                configurations.add(config);
            }
            return configurations;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(rs, ps, conn);
        }
    }
}
