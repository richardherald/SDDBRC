package br.com.sddbrc.configuration_impl;

import br.com.sddbrc.commons.model.Configurations;
import br.com.sddbrc.configuration.IConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfigurationImpl extends Util implements IConfiguration {

    @Override
    public Configurations getByDatabaseId(int databaseId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT * FROM SDDBRC_configuration WHERE sddbrc_database_id = ?");
            ps.setInt(1, databaseId);
            rs = ps.executeQuery();
            Configurations config = new Configurations();
            while (rs.next()) {
                config.setConfiguration_Id(rs.getInt("sddbrc_configuration_id"));
                config.setConfiguration_Poolname(rs.getString("sddbrc_configuration_poolName"));
                config.setConfiguration_DriverClassName(rs.getString("sddbrc_configuration_driverClassName"));
                config.setConfiguration_Jdbcurl(rs.getString("sddbrc_configuration_jdbcUrl"));
                config.setConfiguration_Username(rs.getString("sddbrc_configuration_username"));
                config.setConfiguration_Password(rs.getString("sddbrc_configuration_password"));
                config.setConfiguration_Maxpoolsize(rs.getInt("sddbrc_configuration_maxPoolSize"));
                config.setConfiguration_Cachesize(rs.getInt("sddbrc_configuration_cacheSize"));
                config.setConfiguration_Cachesizelimit(rs.getInt("sddbrc_configuration_cacheSizeLimit"));
            }
            return config;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(rs, ps, conn);
        }
    }
}
