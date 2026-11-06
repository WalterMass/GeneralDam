package sockets_tcp.ejemplo_scp.hilos.objetos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorObjetos{

    static void main(String[] args) {

        System.out.println("SERVIDOR: escuchando en el puerto " + Const.PUERTO_DEL_SERVER);

        try (ServerSocket socketServer = new ServerSocket(Const.PUERTO_DEL_SERVER)){
            System.out.println("SERVIDOR: Esperando conexión. El servidor se bloquea esparando clientes.");

            List<ClienteObjetos> hilosClienteObj = new ArrayList<>();
            int numCliente = 0;

            while(true){
                Socket socketCliente = socketServer.accept();
                numCliente++;
                System.out.println("SERVIDOR: Conexión establecida. Se pasa a hablar con el cliente en su puerto " + socketCliente.getPort());


            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
