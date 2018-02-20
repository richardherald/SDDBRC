package br.com.repositorios;

import br.com.repositorios.config.util.Constantes;
import java.sql.SQLException;

public class repositorios extends Constantes{

    public void buscaListaBancosParaReplicacao() throws SQLException, Exception {
        try {
            conn = getConnection(1);
            ps = conn.prepareStatement("");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
    }
}
