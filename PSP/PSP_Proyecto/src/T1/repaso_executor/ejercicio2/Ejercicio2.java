package T1.repaso_executor.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejercicio2 {
    static final int NUM_HILOS = 10;
    //limite para
    static final int NUM_PARTIDAS = 3;
    static Random rand = new Random();
    static void main() {
        execute();
    }

    private static void execute() {
        AtomicInteger numeroPartida = new AtomicInteger(1);

        try (ExecutorService executor = Executors.newFixedThreadPool(NUM_HILOS)) {
            List<NumeroSecreto> numeroSecretos = new ArrayList<>();
            while(numeroPartida.get() <= NUM_PARTIDAS){
                numeroSecretos.add(new NumeroSecreto(tantear()));
                for (int i = 0; i<NUM_HILOS; i++){
                    intentarAdivinar(numeroPartida, executor);
                }
                numeroPartida.getAndIncrement();
            }
        }

    }

    private static void intentarAdivinar(AtomicInteger numeroPartida, ExecutorService executor) throws RuntimeException{

    }

    private static int tantear(){
        return rand.nextInt(0, 101);
    }
}

/*Igual que la actividad propuesta anterior pero se juega partida tras partida. A cada partida se le
asigna un identificador distinto, que es un número que empieza con 1 y se va incrementando.
Si un hilo quiere jugar, pero no sabe cuál es la partida en curso, puede obtener su identificador
llamando a un método (para implementar) de la clase NumeroOculto (getNumPartida()).
Cuando los hilos proponen un número con el método propuestaNumero, indican además el
identificador de la partida, porque puede haber hilos que, al menos una vez (no debería ser
más de una), intenten adivinar el número de una partida que ya ha adivinado otro hilo. Si ese
es el caso, el valor devuelto por el método propuestaNumero indica que la partida ya ha
terminado, pero que puede jugar a la partida en curso, después de obtener su identificador.*/