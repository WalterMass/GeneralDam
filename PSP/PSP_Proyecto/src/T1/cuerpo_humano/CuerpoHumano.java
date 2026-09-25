package T1.cuerpo_humano;


import java.util.Random;
import java.util.concurrent.Semaphore;

public class CuerpoHumano {

    private final Semaphore receptoresDisponibles;

    public CuerpoHumano(int numeroReceptores){
        receptoresDisponibles = new Semaphore(numeroReceptores);
    }


    public void infectar(String nombreVirus) throws InterruptedException {

        System.out.println("El virus " + nombreVirus + " intenta entrar en el cuerpo");

        System.out.println("Virus en la cola = " + receptoresDisponibles.getQueueLength());

        receptoresDisponibles.acquire();
        //A partir de aqui hay una region compartida entre los que están
            //"dentro" del semaforo
        Thread.sleep(500);
            System.out.println(nombreVirus + " consigue un receptor e INFECTA el cuerpo");
            Random generador = new Random();
            int segundosInfeccion = generador.nextInt(3, 7);
            Thread.sleep(segundosInfeccion * 1000);

        receptoresDisponibles.release();
        int permisosDisponibles = receptoresDisponibles.availablePermits();
        System.out.println(nombreVirus + " libera el receptor y hay espacio para " + permisosDisponibles);

    }
}
