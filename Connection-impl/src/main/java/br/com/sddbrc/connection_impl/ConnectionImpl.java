package br.com.sddbrc.connection_impl;

import br.com.sddbrc.connection.IConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionImpl implements IConnection {
//    private static ConnectionImpl connectionImpl;

//    public static ConnectionImpl getInstance() throws Exception{
//        if (connectionImpl == null){
//            connectionImpl = new ConnectionImpl();
//        }
//        return connectionImpl;
//    }
    @Override
    public void socket() throws Exception {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Porta 12345 aberta!");
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Nova conexão com o cliente "
                        + cliente.getInetAddress().getHostAddress());

                Scanner s = new Scanner(cliente.getInputStream());
                while (s.hasNextLine()) {
                    System.out.println(s.nextLine());
                }

                s.close();
                cliente.close();
            }

        } catch (Exception e) {
            throw e;
        }

    }

}
