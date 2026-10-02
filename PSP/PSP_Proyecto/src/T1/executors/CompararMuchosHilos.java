package T1.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class CompararMuchosHilos {
    private static final int NUMERO_TAREAS = 2_000;
    private static final int REPETICIONES = 80_000;
    private static final int WORKERS =
            Runtime.getRuntime().availableProcessors();
    private static long sumaResultados = 0;
    public static void main(String[] args)
            throws InterruptedException {
        medir("Thread manual", CompararMuchosHilos::ejecutarManual);
        medir("ExecutorService", CompararMuchosHilos::ejecutarConExecutor);
    }
    private static void medir(String nombre, Experimento experimento)
            throws InterruptedException {
        long inicio = System.currentTimeMillis();
        experimento.ejecutar();
        long fin = System.currentTimeMillis();
        System.out.printf("%s: %d ms%n", nombre, fin - inicio);
    }
    private static void ejecutarManual()
            throws InterruptedException {
        List<Thread> hilos = new ArrayList<>();
        for (int i = 0; i < NUMERO_TAREAS; i++) {
            Thread hilo = new Thread(CompararMuchosHilos::trabajoCpu);
            hilos.add(hilo);
            hilo.start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
    }
    private static void ejecutarConExecutor()
            throws InterruptedException {
        ExecutorService executor =
                Executors.newFixedThreadPool(WORKERS);
        for (int i = 0; i < NUMERO_TAREAS; i++) {
            executor.submit(CompararMuchosHilos::trabajoCpu);
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }
    private static void trabajoCpu() {
        long contador = 0;
        for (int i = 2; i < REPETICIONES; i++) {
            if (esPrimo(i)) {
                contador++;
            }
        }
        registrar(contador);
    }
    private static synchronized void registrar(long valor) {
        sumaResultados += valor;
    }
    private static boolean esPrimo(int numero) {
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
    @FunctionalInterface
    private interface Experimento {
        void ejecutar() throws InterruptedException;
    }
}
