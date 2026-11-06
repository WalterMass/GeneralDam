package ejemplos.udp.idavuelta;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ReceptorDatagram {

    public static final int PUERTO_ESCUCHA = 8888;

    static void main() {
        System.out.println("RECEPTOR: Se inicia");
        System.out.println("RECEPTOR: Creando socket en puerto: " + PUERTO_ESCUCHA);

        try(DatagramSocket socket = new DatagramSocket(PUERTO_ESCUCHA)){
            System.out.println("RECEPTOR: Esperando mensajes...");

            DatagramPacket paqueteRecibido = new DatagramPacket(new byte[100], 100);
            socket.receive(paqueteRecibido);

            System.out.println("RECEPTOR: Mensaje recibido!!!");
            System.out.println("RECEPTOR: Nos lo ha mandado " + paqueteRecibido.getAddress() + " desde el puerto " + paqueteRecibido.getPort());
            String mensaje = new String(paqueteRecibido.getData());
            System.out.println("RECEPTOR: El mensaje es: " + mensaje);

            try {
                //Simulamos que hace algo cuando recibe el mensaje
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Contestar al emisor
            String mensajeRespuesta = "OK.RECIBIDO";
            DatagramPacket paqueteRespuesta = new DatagramPacket(
                            mensajeRespuesta.getBytes(StandardCharsets.UTF_8),
                            mensajeRespuesta.length(),
                            paqueteRecibido.getAddress(),
                            paqueteRecibido.getPort()
                            );
            socket.send(paqueteRespuesta);

            System.out.println("RECEPTOR: Paquete de respuesta enviado");


            System.out.println("RECEPTOR: Terminando...");
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
