package T1.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EjemploCallable {

    static void main() {

        try (ExecutorService executor = Executors.newFixedThreadPool(2)){

           Future<Integer> res1 = executor.submit( () -> calcularCuadrado(5));
           Future<Integer> res2 = executor.submit( () -> calcularCuadrado(10));
           Future<Integer> res3 = executor.submit( () -> calcularCuadrado(50));
           Future<Integer> res4 = executor.submit( () -> {
               System.out.println("Paco paco paco");
               return 9 *2;
           });
            System.out.println("Las tareas se están ejecutando...");

            System.out.println(res1.get());
            System.out.println(res2.get());
            System.out.println(res3.get());
            System.out.println(res4.get());

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static int calcularCuadrado(int numero) throws InterruptedException {
        Thread.sleep(2000);
        return numero * numero;
    }
}
