package br.com.sddbrc.connection_impl;

import br.com.sddbrc.commons.model.CommandJDBC;
import br.com.sddbrc.connection.IConnection;
import br.com.sddbrc.security_impl.SecurityImpl;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionImpl implements IConnection {

    private final SecurityImpl security = new SecurityImpl();

    @Override
    public void socket() throws Exception {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            while (true) {
                try (
                        Socket cliente = servidor.accept();
                        ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
                        ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                    ) 
                {
                    CommandJDBC commandJDBC = (CommandJDBC) in.readObject();
                    Object objetoSaida = security.basicSecurity("teste", "teste", commandJDBC);
                    out.writeObject(objetoSaida);
                    out.flush();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
