package ejemplos.udp.idavuelta;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class EmisorDatagram {

    static void main() {
        System.out.println("EMISOR: Iniciamos. Pulsa enter para arrancar");
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();

        //Creamos el datagramSocket
        try(DatagramSocket datagramSocket = new DatagramSocket()){
            System.out.println("EMISOR: Por favor, introduce mensaje a enviar");
            String mensaje = teclado.nextLine();

            //Creamos el paquete (DatagramPacket)
            InetAddress direccion = InetAddress.getByName("localhost");
            int puerto = ReceptorDatagram.PUERTO_ESCUCHA;
            DatagramPacket paquete = new DatagramPacket(
                        mensaje.getBytes(),
                        mensaje.getBytes().length,
                        direccion,
                        puerto);
            datagramSocket.send(paquete);
            System.out.println("EMISOR: Paquete enviado");

            //Ahora pasamos a quedarnos escuchando la recepcion
            DatagramPacket paqueteRecepcion = new DatagramPacket(new byte[100], 100);

            datagramSocket.receive(paqueteRecepcion);

            System.out.println("EMISOR: Paquete recibido!!! ");
            String mensajeRespuesta = new String(paqueteRecepcion.getData());
            System.out.println("EMISOR: Contenido del paquete: " + mensajeRespuesta);



        } catch (SocketException e) {
            //TODO: poner mensajes acorde a cada excepcion
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            //TODO: poner mensajes acorde a cada excepcion
            throw new RuntimeException(e);
        } catch (IOException e) {
            //TODO: poner mensajes acorde a cada excepcion
            throw new RuntimeException(e);
        }

    }
}
