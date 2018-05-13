package br.com.sddbrc.configuration_impl;

import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.configuration.IDatabase;
import br.com.sddbrc.configuration.IDatabaseRConfiguration;
import java.util.List;

public class DatabaseRConfigurationImpl implements IDatabaseRConfiguration {

    @Override
    public List<Databases> getDatabasesWithConfiguration() throws Exception {
        try{
            IDatabase databaseImpl = new DatabaseImpl();
            ConfigurationImpl configurationImpl = new ConfigurationImpl();
            List<Databases> databases = databaseImpl.getAll();
            for (int i = 0; i < databases.size(); i++){
                // se acontecer algum erro: parar tudo ou usar o que subir
                databases.get(i).setConfiguration(configurationImpl.getByDatabaseId(databases.get(i).getDatabase_Id()));
            }
            return databases;
        }catch(Exception e){
            throw e;
        }
    }
    
}
