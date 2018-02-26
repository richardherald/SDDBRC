package br.com.repositorios;

import br.com.repositorios.config.util.Metodos;
import br.com.repositorios.model.Banco;
import br.com.repositorios.model.ConfigBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Middleware extends Metodos {

    public List<Banco> listDataBases() throws SQLException, Exception {
        try {
            conn = getConnection("MIDDLEWARE");
            ps = conn.prepareStatement("select * from Banco");
            resultSet = ps.executeQuery();
            List<Banco> bancos = new ArrayList<>();
            while (resultSet.next()) {
                Banco banco = new Banco();
                banco.setBanco_Id(resultSet.getInt("banco_Id"));
                banco.setBanco_Nome(resultSet.getString("banco_Nome"));
                banco.setBanco_Principal(resultSet.getBoolean("banco_Principal"));
                banco.setBanco_Driver(resultSet.getString("banco_Driver"));
                banco.setBanco_Prioridade(resultSet.getInt("banco_Prioridade"));
                bancos.add(banco);
            }
            return bancos;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection();
        }
    }

    public List<ConfigBanco> findConfiguration(int banco_Id) throws Exception {
        try {
            conn = getConnection("MIDDLEWARE");
            ps = conn.prepareStatement("select * from ConfigBanco");
            resultSet = ps.executeQuery();
            List<ConfigBanco> configurations = new ArrayList<>();
            while (resultSet.next()) {
//                ConfigBanco banco = new ConfigBanco();
//                banco.setBanco_Id(resultSet.getInt("banco_Id"));
//                banco.setBanco_Nome(resultSet.getString("banco_Nome"));
//                banco.setBanco_Principal(resultSet.getBoolean("banco_Principal"));
//                banco.setBanco_Driver(resultSet.getString("banco_Driver"));
//                banco.setBanco_Prioridade(resultSet.getInt("banco_Prioridade"));
//                bancos.add(banco);
            }
            return configurations;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection();
        }
    }
}
