package br.com.configuration_impl.services;

import br.com.commons.model.Database;
import br.com.configuration_impl.db.ConnectionFactoryImpl;
import br.com.sddbrc.core.PersistenceC;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

public class InitDatabases {

    public void initPoolMiddleware() throws Exception {
        try {
            ConnectionFactoryImpl conn = new ConnectionFactoryImpl();
            DataSource poolMiddleware = conn.config("src/main/resources/db.properties");
            conn.setPoolMiddleware(poolMiddleware);
        } catch (Exception e) {
            throw e;
        }
    }

    public void initPoolReplication() throws Exception {
        PersistenceC init = new PersistenceC();
        List<Database> listDataBases;
        Map<Integer, DataSource> poolReplication = new HashMap<>();
        try {
            listDataBases = init.getAllDatabases();
            ConnectionFactoryImpl con = new ConnectionFactoryImpl();
            for (int i = 0; i < listDataBases.size(); i++) {
                if (listDataBases.get(i).getDatabase_Principal()) {
                    con.setPrimaryDataBase(listDataBases.get(i).getDatabase_Id());
                }
                listDataBases.get(i).setListConfiguration(init.getConfigurationByDatabaseId(listDataBases.get(i).getDatabase_Id()));
                for (int j = 0; j < listDataBases.get(i).getListConfiguration().size(); j++) {
                    poolReplication.put(listDataBases.get(i).getDatabase_Id(), con.config(listDataBases.get(i).getListConfiguration().get(j)));
                }
            }
            con.setListDataBases(listDataBases);
            con.setPoolReplication(poolReplication);
        } catch (Exception e) {

        } finally {
            listDataBases = null;
            poolReplication = null;
        }
    }
}
