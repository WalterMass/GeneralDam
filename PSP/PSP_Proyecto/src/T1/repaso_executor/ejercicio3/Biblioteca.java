package T1.repaso_executor.ejercicio3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Biblioteca {
    private static final int NUM_ESTUDIANTES = 4;
    private static final int TIEMPO_MAX_LECTURA = 3;
    private static final int TIEMPO_MAX_DESCANSO = 2;
    private static final int TIEMPO_MIN = 1;
    private Libro[] libros;

    public Biblioteca(String[] librosID) {
        this.libros = new Libro[librosID.length];
        for (int i=0; i < libros.length; i++){
            libros[i] = new Libro(librosID[i]);
        }

    }

    /*METODOS PRINCIPALES*/
    public void estudiar() {
        try (ExecutorService executor = Executors.newFixedThreadPool(NUM_ESTUDIANTES)){
            for (int i = 0; i < NUM_ESTUDIANTES; i++){
                leerLibros(executor);
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void leerLibros(ExecutorService executor){
        int n = 0;
        while (n < 1){
            executor.submit(() -> {
                int eleccion1 = getRandomLibroIndex(libros.length);
                lectura(eleccion1);

                int eleccion2;
                do{
                    eleccion2 = getRandomLibroIndex(libros.length);
                }while(eleccion1 == eleccion2);
                lectura(eleccion2);

                descanso();
            });
            n++;
        }
    }

    /*METODOS AUXILIARES*/

    public void lectura(int eleccion){
        Libro libro = getLibro(eleccion);
        while(true){
            try {
                System.out.printf("\n%s intenta coger el libro {%s}", Thread.currentThread().getName(), libro);
                if (libro.getSemaphore().availablePermits() == 1){
                    libro.getSemaphore().acquire();
                    leer(libro.getId());
                    libro.getSemaphore().release();
                    return;
                }else {
                    System.out.printf("\n%s el libro {%s} esta ocupado", Thread.currentThread().getName(), libro);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void leer(String idLibro){
        System.out.printf("\n%s esta leyendo: {%s}", Thread.currentThread().getName(), idLibro);
        int sleepT = ThreadLocalRandom.current()
                .nextInt(TIEMPO_MIN, TIEMPO_MAX_LECTURA) * 1000;
        try {
            Thread.currentThread().sleep(sleepT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("\n%s ha terminado de leer: {%s}", Thread.currentThread().getName(), idLibro);
    }

    public void descanso(){
        System.out.printf("\n%s esta descansando...",Thread.currentThread().getName());
        int sleepT = ThreadLocalRandom.current()
                .nextInt(TIEMPO_MIN, TIEMPO_MAX_DESCANSO) * 1000;
        try {
            Thread.currentThread().sleep(sleepT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("\n%s ha terminado de descansar", Thread.currentThread().getName());

    }

    /*GETTERS Y SETTERS*/

    public Libro getLibro(int index) {
        Libro libro = null;
        for (int i = 0; i < libros.length; i++){
            if (index == i){
                libro = libros[i];
            }
        }
        return libro;
    }


    public int getRandomLibroIndex(int length){
        return ThreadLocalRandom.current().nextInt(length);
    }
}
