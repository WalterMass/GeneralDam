package ejemplos.tcp.hilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorHilos {

    static void main() {
        System.out.println("SERVIDOR: Creando socket servidor y realizando bind en el puerto " + Constantes.PUERTO_ESCUCHA);
        try(ServerSocket socketServidor = new ServerSocket(Constantes.PUERTO_ESCUCHA)){

            System.out.println("SERVIDOR: Esperando conexión. El servidor se bloquea esperando a clientes");

            List<HiloServidorComunicaciones> hilosComunicaciones = new ArrayList<>();
            int numCliente = 0;
            while(true){
                //Nos quedamos esperando conexiones
                Socket socketCliente = socketServidor.accept();
                numCliente++;
                System.out.println("SERVIDOR: Conexión establecida. Se pasa a hablar con el cliente en su puerto " + socketCliente.getPort());

                //Cuando tenemos una conexion con un socket de cliente, creamos el hilo para que se encargue él
                HiloServidorComunicaciones hiloCliente = new HiloServidorComunicaciones(numCliente, socketCliente);
                hilosComunicaciones.add(hiloCliente);
                //Arrancamos el hilo
                hiloCliente.start();
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
