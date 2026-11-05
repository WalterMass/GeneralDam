package ejemplos.tcp.hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HiloServidorComunicaciones extends Thread{

    private int numHilo;
    private Socket socketCliente;

    public HiloServidorComunicaciones(int numHilo, Socket socketCliente) {
        this.numHilo = numHilo;
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {

        try(BufferedReader lectorBuffer = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()))){

            String linea = lectorBuffer.readLine();
            while(linea != null && !linea.equalsIgnoreCase("END")){
                System.out.printf("[HILO %d]: %s \n", numHilo, linea);
                linea = lectorBuffer.readLine();
            }
            System.out.printf("[HILO %d]: Cerrando comunicación... \n", numHilo);
            socketCliente.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
