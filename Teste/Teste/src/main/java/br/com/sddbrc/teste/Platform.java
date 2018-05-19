package br.com.sddbrc.teste;

import br.com.sddbrc.commons.model.CommandJDBC;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.Random;

public class Platform {

    private static final String HOST = "192.168.0.108";
    private static final int PORT = 12345;
    private static Random random = new Random(3000);
    private int contador = 0;

    public void stressPlataformaInsert(int quantidade) throws IOException, Exception {
        try {
            for (int i = 0; i < quantidade; i++) {
                callSocketServer(HOST, PORT, i);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void callSocketServer(String host, int port, final int i) throws Exception {
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(random.nextInt(3000));
                    } catch (Exception e) {
                    }
                    while (true) {
                        CommandJDBC command = new CommandJDBC();
                        String script_pessoa = "INSERT INTO Pessoa (pessoa_Nome,pessoa_Cpf,pessoa_sexo,pessoa_dataNascimento,pessoa_Email) VALUES ('Richard','12345678900','M','12/05/2018 00:35:00.000','email@email.com')";
                        command.setQuery(script_pessoa);
                        command.setGeneratedKeys(false);
                        try (
                                Socket cliente = new Socket(host, port);
                                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                                ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
                            ) 
                        {
                            long ti = System.currentTimeMillis();
                            out.writeObject(command);
                            out.flush();
                            in.readObject();
                            long tf = System.currentTimeMillis();
                            long tempo = tf - ti;
                            System.out.println(new StringBuffer().append(tempo).append(";").append(++contador).toString());
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
}
