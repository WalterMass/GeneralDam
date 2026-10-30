package T1.repaso_executor.ejercicio5;

import java.util.concurrent.Semaphore;

public class Palillo extends Semaphore {

    private final int id;

    public Palillo(int id) {
        super(1);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
