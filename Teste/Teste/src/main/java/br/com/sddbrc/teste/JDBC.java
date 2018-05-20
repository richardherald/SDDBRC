
package br.com.sddbrc.teste;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class JDBC {

    private static Random random = new Random(3000);
//    private int contador = 0;

    public void stressJDBCInsert(int quantidade) throws IOException, Exception {
        try {
            for (int i = 0; i < quantidade; i++) {
                callJDBC();
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }

    public void callJDBC() throws Exception {
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(random.nextInt(3000));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    while (true) {
                        long ti = System.currentTimeMillis();
                        String script_pessoa = "INSERT INTO Pessoa (pessoa_Nome,pessoa_Cpf,pessoa_sexo,pessoa_dataNascimento,pessoa_Email) VALUES ('Richard','12345678900','M','12/05/2018 00:35:00.000','email@email.com')";
                        try (
                                Connection conn = getConnection();
                                PreparedStatement ps = conn.prepareStatement(script_pessoa, Statement.NO_GENERATED_KEYS);
                            ) {
                            ps.executeUpdate();
                            long tf = System.currentTimeMillis();
                            long tempo = tf - ti;
                            System.out.println(tempo);
                            sleep(random.nextInt(3000));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }.start();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() throws Exception {
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDataSource";
            String url = "jdbc:sqlserver://192.168.0.107:1434;instanceName=AMBIENTE1;databaseName=Replication";
            String user = "sa";
            String pass = "Islan@123";
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
}
