package br.com.sddbrc.teste;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Random;

public class JDBC {

    HikariDataSource datasource;
    private static Random random = new Random(3000);
    private static final boolean continuar = true;

    public JDBC(){
        loadConfiguration();
    }

    public void stressJDBCInsert(int quantidade) throws IOException, Exception {
        try {
            for (int i = 0; i < quantidade; i++) {
                callJDBC();
            }
            System.out.println("Finalizando o for --------------------");
        } catch (Exception e) {
            throw e;
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
                    }
                    while (continuar) {
                        String script_pessoa = "INSERT INTO Pessoa (pessoa_Nome,pessoa_Cpf,pessoa_sexo,pessoa_dataNascimento,pessoa_Email) VALUES ('Richard','12345678900','M','12/05/2018 00:35:00.000','email@email.com')";
                        try (
                             Connection conn = datasource.getConnection();
                             PreparedStatement ps = conn.prepareStatement(script_pessoa, Statement.NO_GENERATED_KEYS);
                            ) {
                            long ti = System.currentTimeMillis();
                            ps.executeUpdate();
                            long tf = System.currentTimeMillis();
                            long tempo = tf - ti;
                            System.out.println(tempo);
                            sleep(random.nextInt(3000));
                        } catch (Exception e) {
                        }
                    }
                }
            }.start();
        } catch (Exception e) {
            throw e;
        }
    }

    public void loadConfiguration(){
        try {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setPoolName("teste");
            hikariConfig.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
            hikariConfig.setJdbcUrl("jdbc:sqlserver://192.168.0.107:1434;instanceName=AMBIENTE1;databaseName=Replication");
            hikariConfig.setUsername("sa");
            hikariConfig.setPassword("Islan@123");
            hikariConfig.setMaximumPoolSize(500);
            hikariConfig.addDataSourceProperty("cachePrepStmts", 100);
            hikariConfig.addDataSourceProperty("prepStmtCacheSize", 2048);
            hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", 4096);
            datasource = new HikariDataSource(hikariConfig);
        } catch (NumberFormatException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
}
