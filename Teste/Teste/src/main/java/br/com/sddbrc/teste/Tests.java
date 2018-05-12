package br.com.sddbrc.teste;

import br.com.sddbrc.commons.model.CommandJDBC;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author herald
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("br.com.sddbrc.teste.Main.main()");
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
//    
//    public void ThreadReplication() throws Exception {
//        try {
//            while (true) {
//                System.out.println("Comecou o socket");
//                Socket cliente = new Socket("127.0.0.1", 12345);
//                System.out.println("O cliente se conectou ao servidor!");
//                Scanner teclado = new Scanner(System.in);
//                PrintStream saida = new PrintStream(cliente.getOutputStream());
//
//                while (teclado.hasNextLine()) {
//                    saida.println(teclado.nextLine());
//                }
//
//                saida.close();
//                teclado.close();
//                Thread.sleep(10000);
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }
}
