package br.com.sddbrc.persistence_impl;

import br.com.sddbrc.commons.model.CommandJDBC;
import br.com.sddbrc.commons.model.Configurations;
import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.persistence.IPersistence;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class PersistenceImpl extends Util implements IPersistence {

    private static List<Databases> POOLS = new ArrayList<>();
    private static Databases POLL_MASTER = new Databases();

    @Override
    public DataSource createPool(Configurations config) throws Exception {
        try {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setPoolName(config.getConfiguration_Poolname());
            hikariConfig.setDriverClassName(config.getConfiguration_DriverClassName());
            hikariConfig.setJdbcUrl(config.getConfiguration_Jdbcurl());
            hikariConfig.setUsername(config.getConfiguration_Username());
            hikariConfig.setPassword(config.getConfiguration_Password());
            hikariConfig.setMaximumPoolSize(config.getConfiguration_Maxpoolsize());
            hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
            hikariConfig.addDataSourceProperty("prepStmtCacheSize", config.getConfiguration_Cachesize());
            hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", config.getConfiguration_Cachesizelimit());
            return new HikariDataSource(hikariConfig);
        } catch (NumberFormatException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int executeUpdate(CommandJDBC command) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = command.getCon().prepareStatement(command.getQuery(), command.isGeneratedKeys() ? 1 : 0);
            int returnValue = ps.executeUpdate();
            return command.isGeneratedKeys() ? returnGeneratedKeys(ps, returnValue) : returnValue;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(null, ps, command.getCon());
        }
    }

    @Override
    public ResultSet executeQuery(CommandJDBC command) throws Exception {
        try {
            return command.getCon().prepareStatement(command.getQuery()).executeQuery();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(null, null, command.getCon());
        }
    }

    public void executeQueryTest(CommandJDBC command) throws Exception {
        ResultSet rs = null;
        try {
            rs = command.getCon().prepareStatement(command.getQuery()).executeQuery();
            while (rs.next() == true) {
                System.out.println(rs.getInt("pessoa_Id"));
                System.out.println(rs.getString("Pessoa_Nome"));
                System.out.println(rs.getString("Pessoa_Cpf"));
                System.out.println(rs.getString("Pessoa_Sexo"));
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(rs, null, command.getCon());
        }
    }

    /**
     * Metodo responsavel por instanciar o pool de conexões baseado no nome da
     * classe
     *
     * @param databases
     * @param classPersistence
     * @throws Exception
     */
    @Override
    public void init(List<Databases> databases,String classPersistence) throws Exception {
        try {
            for (int i = 0; i < databases.size(); i++) {
                Databases database = databases.get(i);
                if (database.getDatabase_Principal()) {
                    setPOLL_MASTER(database);
                }
                IPersistence configConnection = (PersistenceImpl) Class.forName(classPersistence).newInstance();
                DataSource newDatasource = configConnection.createPool(database.getConfiguration());
                databases.get(i).setDatasource(newDatasource);
            }
            setPOOLS(databases);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean findScriptByName(String command, String Action) {
        return (command.substring(0, 6).contains(Action));
    }


    public Connection getConnection(List<Databases> databases, int databaseId) throws Exception {
        try {
            for (Databases database : databases) {
                if (database.getDatabase_Id() == databaseId) {
                    return database.getDatasource().getConnection();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    /**
     * Testar todas as conexões antes de retornar para fazer a replicação.
     * classe
     *
     * @return List<Databases> databases
     * @throws Exception
     */
    public List<Databases> ListDatabaseActiveForReplication() throws Exception {
        try {
            List<Databases> listDatabases = new ArrayList<>();
            for (int i = 0; i < getPOOLS().size(); i++) {
                Connection conn = null;
                PreparedStatement ps = null;
                conn = getPOOLS().get(i).getDatasource().getConnection();
                ps = conn.prepareStatement("SELECT 1");
                if (ps.executeQuery().next()) {
                    listDatabases.add(getPOOLS().get(i));
                }
            }
            return listDatabases;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * @return the POOLS
     */
    public List<Databases> getPOOLS() {
        return POOLS;
    }

    /**
     * @param aPOOLS the POOLS to set
     */
    public void setPOOLS(List<Databases> aPOOLS) {
        POOLS = aPOOLS;
    }

    /**
     * @return the POLL_MASTER
     */
    public Databases getPOLL_MASTER() {
        return POLL_MASTER;
    }

    /**
     * @param aPOLL_MASTER the POLL_MASTER to set
     */
    public void setPOLL_MASTER(Databases aPOLL_MASTER) {
        POLL_MASTER = aPOLL_MASTER;
    }
}
