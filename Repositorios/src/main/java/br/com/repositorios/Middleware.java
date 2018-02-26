package br.com.repositorios;

import br.com.repositorios.config.util.Metodos;
import java.sql.SQLException;

public class Middleware extends Metodos {

    public void listBancos() throws SQLException, Exception {
        try {
            conn = getConnection(1);
            ps = conn.prepareStatement("");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

            }
        } catch (Exception e) {
            throw e;
        }
    }
}
