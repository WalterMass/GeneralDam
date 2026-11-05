package ejemplos.tcp.hilos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteBucle {

    static void main() {

        System.out.println("CLIENTE: Pulse enter para iniciar");
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();

        try(Socket socketCliente = new Socket("localhost", Constantes.PUERTO_ESCUCHA)) {

            System.out.println("CLIENTE: Ya estás conectado. Empieza a escribir y con cada línea pulsa enter. Para salir escribe END");
            //Creamos el buffer de salida (donde vamos a escribir las lineas)
            try(BufferedWriter streamSalida = new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream()))){
                String mensaje = null;
                //Iteramos para recibir multiples mensajes del usuario.
                //Con cada uno, lo enviamos por el "tubo"
                do{
                    mensaje = teclado.nextLine();
                    mensaje = mensaje.concat("\n");//le añadimos salto de linea para que detecte que es nueva linea

                    //GRabamos el mensaje a la salida
                    streamSalida.write(mensaje);
                    streamSalida.flush();

                }while(!mensaje.equalsIgnoreCase(Constantes.COMANDO_FIN));

                System.out.println("CLIENTE: Cerrando programa...");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
