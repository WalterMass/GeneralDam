package T1.repaso_executor.ejercicio2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ejercicio2 {
    static final int NUM_HILOS = 10;
    //limite de partidas
    static final int NUM_PARTIDAS = 3;

    static void main(String[] args) {
        execute();
    }

    private static void execute() {
        try (ExecutorService executor = Executors.newFixedThreadPool(NUM_HILOS)) {
            NumeroSecreto numeroSecreto  = new NumeroSecreto(NumeroSecreto.tantear(), NUM_PARTIDAS);
            for (int i = 0; i < NUM_HILOS; i++){
                intentarAdivinar(executor, numeroSecreto);
            }
        }
    }

    private static void intentarAdivinar(ExecutorService executor, NumeroSecreto numeroSecreto){
        executor.submit(() -> {
            while(true){
                String nombreHilo = Thread.currentThread().getName();
                int idPartida = numeroSecreto.getNumPartida();
                int propuesta = NumeroSecreto.tantear();
                System.out.printf("\n%s quiere jugar a la partida nº%d", nombreHilo, idPartida);
                int resultadoPropuesta = numeroSecreto.propuestaNumero(propuesta, idPartida);

                if (resultadoPropuesta == -1 ){
                    if (numeroSecreto.isJuegoTerminado()){
                        System.out.printf("\n%s: el juego ya ha terminado", nombreHilo);
                        return;
                    }
                    System.out.printf("\n%s: la partida nº%d ha terminado", nombreHilo, idPartida);
                    continue;
                }

                if (resultadoPropuesta == 1) {
                    System.out.printf("\n%s: ha ganando la partida nº%d acertado el numero oculto: %d, ", nombreHilo, idPartida, propuesta);
                    return;
                }

            }
        });
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