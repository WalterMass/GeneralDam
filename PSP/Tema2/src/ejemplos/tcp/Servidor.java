package ejemplos.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
TODO: Conseguir que el cliente pueda enviar múltiples mensajes
al servidor, hasta que el cliente envíe la cadena \salir
El cliente deberá pedir al usuario cadenas para enviar. Si el
usuario escribe el comando \salir, se enviará al servidor,
y el cliente terminará.
 */
public class Servidor {

    static void main() {

        int port = 45678;
        System.out.println("Servidor escuchando en el puerto " + port);

        try(ServerSocket socketServidor = new ServerSocket(port)){

            Socket socketCliente = socketServidor.accept();
            System.out.println("Cliente conectado desde: " + socketCliente.getInetAddress() + ", puerto: " + socketCliente.getPort());

            //Recibir el mensaje del cliente...
            try(BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream()))){

                String mensajeDeCliente = in.readLine();
                System.out.println("El cliente dice... " + mensajeDeCliente);

                //Responder al cliente
                salida.write("[RECIBIDO]");
                salida.newLine();
                salida.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fin del programa");
    }
}
