package T1.semaforos_parking;

import java.util.concurrent.Semaphore;

public class Parking {
    private Semaphore semaforo;

    public Parking(int receptores) {
        this.semaforo = new Semaphore(receptores);
    }
}
