package br.com.sddbrc.connection_impl;

import br.com.sddbrc.commons.model.CommandJDBC;
import br.com.sddbrc.connection.IConnection;
import br.com.sddbrc.security_impl.SecurityImpl;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionImpl implements IConnection {

    private final SecurityImpl security = new SecurityImpl();

    @Override
    public void socket() throws Exception {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor ligado na porta:" + 12345);
            while (true) {
                try (Socket cliente = servidor.accept()) {
                    System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
                    byte[] objectAsByte = new byte[cliente.getReceiveBufferSize()];
                    BufferedInputStream bf = new BufferedInputStream(cliente.getInputStream());
                    bf.read(objectAsByte);
                    CommandJDBC commandJDBC = (CommandJDBC) objectTobyte(objectAsByte);
                    security.basicSecurity("teste", "teste", commandJDBC);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static Object objectTobyte (byte[] objectAsByte) {
        Object obj = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new ByteArrayInputStream(objectAsByte));
            obj = ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
