package datagramas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceptorDatagram {
    public static final int PUERTO_ESCUCHA = 9876;
    static void main(String[] args) {
        System.out.println();
        System.out.println();

        try(DatagramSocket socket = new DatagramSocket(PUERTO_ESCUCHA)){
            System.out.println("RECEPTOR: Esperando Mensajes...");

            DatagramPacket paquete = new DatagramPacket(new byte[100], 100);
            socket.receive(paquete);
            System.out.println("RECEPTOR: Mensaje recibido!");
            System.out.println("RECEPTOR: nos lo ha mandado " + paquete.getAddress() + " desde el puerto " + paquete.getPort());
            String mensaje = new String(paquete.getData());
            System.out.println("RECEPTOR: El mensaje es: "+mensaje);
            System.out.println("RECEPTOR: Terminado...");

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
