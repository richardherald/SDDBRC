package br.com.sddbrc.teste;

import br.com.sddbrc.commons.model.CommandJDBC;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Tests {

    private static Tests teste = new Tests();
    private static final String host = "192.168.0.108";
    private static final int port = 12345;
    private static boolean continuar = true;
    private static Random random = new Random(3000);

    public static void main(String[] args) throws Exception {
        teste.stressPlataformaInsert(1000);
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
                    while (continuar) {
                        CommandJDBC command = new CommandJDBC();
                        String script_pessoa = "INSERT INTO Pessoa (pessoa_Id,pessoa_Nome,pessoa_Cpf,pessoa_sexo,pessoa_dataNascimento,pessoa_Email) VALUES ('Richard','12345678900','M','12/05/2018 00:35:00.000','email@email.com')";
                        command.setQuery(script_pessoa);
                        command.setGeneratedKeys(false);
                        try (
                                Socket cliente = new Socket(host, port);
                                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                                ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());) {
                            long ti = System.currentTimeMillis();
                            out.writeObject(command);
                            out.flush();
                            Object retorno = (Object) in.readObject();
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

    public void stressPlataformaInsert(int quantidade) throws IOException, Exception {
        try {
            for (int i = 0; i < quantidade; i++) {
                callSocketServer(host, port, i);
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public static void stressJDBC(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            
        }
    }
}
