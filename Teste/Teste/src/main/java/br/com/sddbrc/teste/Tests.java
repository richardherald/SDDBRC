package br.com.sddbrc.teste;

import br.com.sddbrc.commons.model.CommandJDBC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Timestamp;

public class Tests {

    private static Tests teste = new Tests();
    private static final String host = "192.168.0.108";
    private static final int port = 12345;

    public static void main(String[] args) throws Exception {
        teste.stressPlataformaInsert(1000);
//        teste.stressPlataformaInsert(10000);
//        teste.stressPlataformaInsert(50000);
//        teste.stressPlataformaInsert(100000);
    }

    public void callSocketServer(String host, int port, Object obj) throws Exception {
        try {
            System.out.println("Iniciando a chamada do socket no tempo: " + new Timestamp(System.currentTimeMillis()).toString());
            Socket cliente = new Socket(host, port);
            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
            out.writeObject(obj);
            out.flush();
            Object retorno = (Object) in.readObject();
            System.out.println("Finalizando a chamada do socket no tempo: " + new Timestamp(System.currentTimeMillis()).toString());
            out.close();
            cliente.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public void stressPlataformaInsert(int quantidade) throws IOException, Exception {
        try {
            for (int i = 0; i < quantidade; i++) {
                CommandJDBC command = new CommandJDBC();
                String insert_pessoa = "INSERT INTO Pessoa (pessoa_Id,pessoa_Nome,pessoa_Cpf,pessoa_sexo,pessoa_dataNascimento,pessoa_Email) VALUES (" + i + ",'Richard','12345678900','M','12/05/2018 00:35:00.000','email@email.com')";
                command.setQuery(insert_pessoa);
                command.setGeneratedKeys(false);
                callSocketServer(host, port, command);
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public void stressPlataformaUpdate(int quantidade) throws Exception {
        try {
            for (int i = 0; i < quantidade; i++) {
                CommandJDBC command = new CommandJDBC();
                String update_pessoa = "UPDATE PESSOA SET pessoa_Nome = 'Islan', pessoa_Cpf = '00000000000', pessoa_sexo = 'M', pessoa_dataNascimento = '01/01/2018 00:00:00.000', pessoa_Email = 'email@email.com' WHERE pessoa_Id = " + i;
                command.setQuery(update_pessoa);
                command.setGeneratedKeys(false);
                callSocketServer(host, port, command);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void stressPlataformaDelete(int quantidade) throws Exception {
        try {
            for (int i = 0; i < quantidade; i++) {
                CommandJDBC command = new CommandJDBC();
                String delete_pessoa = "DELETE FROM Pessoa  WHERE pessoa_Id = " + i;
                command.setQuery(delete_pessoa);
                command.setGeneratedKeys(false);
                callSocketServer(host, port, command);
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public static void stressJDBC(int quantidade) {
        for (int i = 0; i < quantidade; i++) {

        }
    }

//    public void teste() throws Exception {
    // SELECT //
//        CommandJDBC select = new CommandJDBC();
//        select.setQuery("SELECT TOP (10) * FROM [TESTE].[dbo].[Pessoa]");
//        select.setGeneratedKeys(false);
//        Runtime.getInstance().execute(select);
//
//        // INSERT SEM RETORNO DO DO NOVO ID DO REGISTRO //
//        CommandJDBC insertSemRetorno = new CommandJDBC();
//
//        insertSemRetorno.setQuery("INSERT INTO [TESTE].[dbo].[Pessoa] ([pessoa_Nome] ,[pessoa_Cpf] ,[pessoa_sexo] ,[pessoa_DataNascimento] ,[pessoa_Email]) VALUES ('teste123', '123' ,'M' ,getdate() ,'teste@teste.com.br')");
//        insertSemRetorno.setGeneratedKeys(false);
//        Runtime.getInstance().execute(insertSemRetorno);
//
//        // INSERT COM RETORNO DO DO NOVO ID DO REGISTRO //
//        CommandJDBC insertComRetorno = new CommandJDBC();
//
//        insertComRetorno.setDML("INSERT");
//        insertComRetorno.setQuery("INSERT INTO TESTE.dbo.Pessoa ([pessoa_Nome] ,[pessoa_Cpf] ,[pessoa_sexo] ,[pessoa_DataNascimento] ,[pessoa_Email]) VALUES ('teste123', '123' ,'M' ,getdate() ,'teste@teste.com.br')");
//        insertComRetorno.setGeneratedKeys(true);
//        int retorno = (int) Runtime.getInstance().execute(insertComRetorno);
//
//        // UPDATE //
//        CommandJDBC update = new CommandJDBC();
//        update.setQuery("UPDATE [TESTE].[dbo].[Pessoa] SET [pessoa_Nome] = 'mudou o nome' WHERE pessoa_Id =  " + retorno);
//        update.setGeneratedKeys(false);
//        Runtime.getInstance().execute(update);
//
//        // DELETE //
//        CommandJDBC delete = new CommandJDBC();
//        delete.setQuery("DELETE FROM [TESTE].[dbo].[Pessoa] WHERE pessoa_Id = " + retorno);
//        delete.setGeneratedKeys(false);
//        Runtime.getInstance().execute(delete);
//
//    }
}
