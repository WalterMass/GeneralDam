package ejemplos.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceptorDatagram {

    public static final int PUERTO_ESCUCHA = 8888;

    static void main() {
        System.out.println("RECEPTOR: Se inicia");
        System.out.println("RECEPTOR: Creando socket en puerto: " + PUERTO_ESCUCHA);

        try(DatagramSocket socket = new DatagramSocket(PUERTO_ESCUCHA)){
            System.out.println("RECEPTOR: Esperando mensajes...");

            DatagramPacket paquete = new DatagramPacket(new byte[100], 100);
            socket.receive(paquete);

            System.out.println("RECEPTOR: Mensaje recibido!!!");
            System.out.println("RECEPTOR: Nos lo ha mandado " + paquete.getAddress() + " desde el puerto " + paquete.getPort());
            String mensaje = new String(paquete.getData());
            System.out.println("RECEPTOR: El mensaje es: " + mensaje);

            System.out.println("RECEPTOR: Terminando...");
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
