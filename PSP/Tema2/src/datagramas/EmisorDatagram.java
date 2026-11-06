package datagramas;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class EmisorDatagram {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("EMISOR: Iniciamos");

        System.out.println("EMISOR: preparando.");

        // crear el dataSocket
        try (DatagramSocket datagramSocket = new DatagramSocket()){
            System.out.println("EMISOR: Por favor, intrudce mensaje a enviar");
            String mensaje = sc.nextLine();

            //crear el packet
            InetAddress dirrecion = InetAddress.getByName("localhost");

            int puerto = ReceptorDatagram.PUERTO_ESCUCHA;

            DatagramPacket packet = new DatagramPacket(
                    mensaje.getBytes(),
                    mensaje.getBytes().length,
                    dirrecion,
                    puerto
            );

            datagramSocket.send(packet);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
