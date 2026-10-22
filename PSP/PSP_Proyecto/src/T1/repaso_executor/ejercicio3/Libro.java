package T1.repaso_executor.ejercicio3;

import java.util.concurrent.Semaphore;

public class Libro {
    private String id;
    private Semaphore semaphore = new Semaphore(1);

    public Libro(String id) {
        this.id = id;
    }

    /* GETTERS Y SETTERS */

    public String getId() {
        return id;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    @Override
    public String toString() {
        return id;
    }
}
