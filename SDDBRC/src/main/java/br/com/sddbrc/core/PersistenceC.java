package br.com.sddbrc.core;

import br.com.commons.model.Configuration;
import br.com.commons.model.Database;
import br.com.persistence_impl.ConfigurationImpl;
import br.com.persistence_impl.DatabaseImpl;
import java.util.List;

public class PersistenceC {

    public List<Database> getAllDatabases() throws Exception {
        try {
            DatabaseImpl databaseImpl = new DatabaseImpl();
            return databaseImpl.getAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Configuration> getConfigurationByDatabaseId(Integer id) throws Exception {
        try {
            ConfigurationImpl configurationImpl = new ConfigurationImpl();
            return configurationImpl.getByDatabaseId(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
