package T1.carreras_ruben;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CoordinadorCarrera {
    static void main() throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        int participantes =3;
        ArrayList <Corredor> corredores = new ArrayList<>();
        for (int i = 0; i <participantes; i++) {
            System.out.println("Introduce el nombre del participante " + (i+1));
            Corredor c = new Corredor(teclado.nextLine());
            corredores.add(c);
        }
        System.out.println("Empieza la carrera ");
        for (int i = 0; i < participantes; i++) {
            corredores.get(i).start();
        }
        for (int i = 0; i < participantes; i++) {
            corredores.get(i).join();
        }
        Collections.sort(corredores, Comparator.comparing(Corredor::getTiempoTotal));
        System.out.println("El ganador de la carrera es el participante " + corredores.get(0).getNombre() +" con un tiempo de " + corredores.get(0).getTiempoTotal());
    }
}