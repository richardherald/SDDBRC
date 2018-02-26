package br.com.repositorios.services;

import br.com.repositorios.config.db.ConnectionFactoryImpl;
import br.com.repositorios.model.Banco;
import br.com.repositorios.model.ConfigBanco;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

public class Middleware {

    public br.com.repositorios.Middleware mid = new br.com.repositorios.Middleware();

    public void startPoolDataBases() throws Exception {
        ConnectionFactoryImpl con = new ConnectionFactoryImpl();
        List<Banco> listDataBases = mid.listDataBases();
        Map<String, DataSource> datasources = new HashMap<>();
        for (int i = 0; i < listDataBases.size(); i++) {
            List<ConfigBanco> listConfigurations = mid.findConfiguration(listDataBases.get(i).getBanco_Id());
            for (int j = 0; j < listConfigurations.size(); j++) {
//                datasources.put(listDataBases.get(i).con.config(config);
            }
        }

        con.setDatasources(aDatasources);
    }
}
