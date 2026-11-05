package ejemplos.tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    static void main() {
        String direccionDestino = "localhost";
        //127.0.0.1
        Scanner teclado = new Scanner(System.in);
        int puertoDestino = 45678;

        System.out.println("Cliente preparado. Pulse enter para conectar al servidor");
        teclado.nextLine();

        try(Socket socketCliente = new Socket(direccionDestino, puertoDestino)){
            System.out.println("Bien, he podido conectar!!!!");

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream()));

            System.out.println("Dime qué le mandamos al servidor");

            String mensajeCliente = teclado.nextLine();
            out.write(mensajeCliente);
            out.newLine();//nos aseguramos que el mensaje termine con una línea nueva
            out.flush();

            //Recibimos del servidor la respuesta...
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            String mensajeServidor = entrada.readLine();
            System.out.println("Servidor: " + mensajeServidor);



        } catch (UnknownHostException e) {
            System.out.println("No existe esa direccion de host");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fin del cliente");
    }
}
