package T1.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LanzadorHilosExecutor {

    public static final int N_THREADS = Runtime.getRuntime().availableProcessors();
    public static final int NUM_PEDIDOS = 50;

    static void main() {
        //Crear el executorService
        try (ExecutorService executor = Executors.newFixedThreadPool(N_THREADS)) {

            System.out.printf("Vamos a lanzar %d hilos para %d tareas \n ",
                    N_THREADS,
                    NUM_PEDIDOS);
            //Lanzarle las tareas en modo bucle
            for (int numPedido = 0; numPedido < NUM_PEDIDOS; numPedido++) {
                executor.execute(new ProcesarPedido(numPedido+1));
            }
            //Lo hacemos manual
//            executor.execute(new ProcesarPedido(2));
//            executor.execute(new ProcesarPedido(3));
//            executor.execute(new ProcesarPedido(4));
//            executor.execute(new ProcesarPedido(5));

            executor.shutdown();

        }
    }
}
