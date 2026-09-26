package T1.semaforos_parking;

import java.util.concurrent.Semaphore;

public class Parking {
    private final Semaphore semaforo;

    public Parking(int receptores) {
        this.semaforo = new Semaphore(receptores);
    }

    public void estacionar(int numCoche) throws InterruptedException{

        System.out.println("\nEl coche numero %d se intenta estacionar");
        boolean esperando = true;
        do{

        if (isAvailable(semaforo.availablePermits())){
            esperando = false;
            System.out.printf("\nEl coche %d ha encontrado plaza", numCoche);
            semaforo.acquire();
            int millis = Coche.getSleepTime();
            Thread.sleep(millis);
            semaforo.release();
            System.out.printf("\nEl coche num  ero %d sale del estacionamiento tras %d minutos. TICKETS LIBRES: %d"
                    ,numCoche
                    ,millis
                    ,semaforo.availablePermits());
        }else System.out.printf("\nCoche numero %d: Esperando...",
                numCoche);

        }while(esperando);
    }
    private boolean isAvailable(int numPlazasDisponibles){
        return numPlazasDisponibles >= 1;
    }

    public Semaphore getSemaforo() {
        return semaforo;
    }

}
