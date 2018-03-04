package br.com.repositorios.services;

import br.com.repositorios.Middleware;
import br.com.repositorios.config.db.ConnectionFactoryImpl;
import br.com.repositorios.model.Banco;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

public class MiddlewareService {

    public void initPoolMiddleware() throws Exception {
        try {
            ConnectionFactoryImpl con = new ConnectionFactoryImpl();
            DataSource poolMiddleware = con.config("src/main/resources/config.properties");
            con.setPoolMiddleware(poolMiddleware);
        } catch (Exception e) {
            throw e;
        }
    }

    public void initPoolReplication() throws Exception {
        Middleware mid = new Middleware();
        List<Banco> listDataBases = new ArrayList<>();
        Map<Integer, DataSource> poolReplication = new HashMap<>();
        try {
            mid.listDataBases();
            ConnectionFactoryImpl con = new ConnectionFactoryImpl();
            for (int i = 0; i < listDataBases.size(); i++) {
                if (listDataBases.get(i).isBanco_Principal()) {
                    con.setPrimaryDataBase(listDataBases.get(i).getBanco_Id());
                }
                listDataBases.get(i).setConfiguracoes(mid.findConfiguration(listDataBases.get(i).getBanco_Id()));
                for (int j = 0; j < listDataBases.get(i).getConfiguracoes().size(); j++) {
                    poolReplication.put(listDataBases.get(i).getBanco_Id(), con.config(listDataBases.get(i).getConfiguracoes().get(j)));
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
