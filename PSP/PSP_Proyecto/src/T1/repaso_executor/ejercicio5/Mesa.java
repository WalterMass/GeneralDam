package T1.repaso_executor.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Mesa {
    private final int numFilosofos;
    private final List<Palillo> palillos;

    public Mesa(int numFilosofos, int numPalillos) {
        this.numFilosofos = numFilosofos;
        List<Palillo> lista = new ArrayList<>();
        for (int i = 0; i < numPalillos; i++) lista.add(new Palillo(i));
        this.palillos = lista;
    }

    public void empezarComida(){

        try(ExecutorService executor = Executors.newFixedThreadPool(numFilosofos)){
            for (int i = 0; i <= numFilosofos; i++) {
                intentarComer(executor, i);
            }
        }

    }

    private void intentarComer(ExecutorService executor, int index){
        executor.submit( () -> {
            String nombreHilo = Thread.currentThread().getName();
            boolean haComido = false;

            while(!haComido){
                synchronized(this){
                    int palillo1 = 0;
                    int palillo2 = 0;
                    try {
                        System.out.printf("\n(Filosofo_%s) Intenta coger palillos. INTENTA COMER", nombreHilo);
                        if (index == 1){
                            if (palillos.get(numFilosofos -1).availablePermits() == 1
                                    && palillos.get(index).availablePermits() == 1){
                                palillo1 = numFilosofos -1;
                                palillo2 = index;
                                palillos.get(numFilosofos -1).acquire();
                                palillos.get(index).acquire();
                                mensajeFilosofoComiendo(nombreHilo, palillo1, palillo2);
                                Thread.sleep(getRandomEatTime());
                                haComido = true;
                            }else mensajeFilosofoNoConsiguePalillos(nombreHilo, palillo1, palillo2);
                        }else {
                            if (palillos.get(index-1).availablePermits() == 1
                                    && palillos.get(index).availablePermits() == 1){
                                palillo1 = index-1;
                                palillo2 = index;
                                palillos.get(index-1).acquire();
                                palillos.get(index).acquire();
                                mensajeFilosofoComiendo(nombreHilo, palillo1, palillo2);
                                Thread.sleep(getRandomEatTime());
                                haComido = true;
                            }else mensajeFilosofoNoConsiguePalillos(nombreHilo, palillo1, palillo2);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("error");
                        throw new RuntimeException(e);
                    }finally {
                        palillos.get(palillo1).release();
                        palillos.get(palillo2).release();
                        if (haComido){
                            mensajeFilosofoTerminaDeComer(nombreHilo, palillo1, palillo2);
                        }
                    }
                }
            }



        });
    }

    private void mensajeFilosofoNoConsiguePalillos(String nombreHilo, int palillo1, int palillo2){
        System.out.printf("\n(Filosofo_%s) No ha conseguido los palillos, uno de ellos o ambos estan ocupados: %d - %d. NO PUEDE COMER", nombreHilo, palillo1, palillo2);
    }


    private void mensajeFilosofoComiendo(String nombreHilo, int palillo1, int palillo2){
        System.out.printf("\n(Filosofo_%s) Ha conseguido los palillos: %d - %d. EMPIEZA A COMER", nombreHilo, palillo1, palillo2);
    }

    private void mensajeFilosofoTerminaDeComer(String nombreHilo, int palillo1, int palillo2){
        System.out.printf("\n(Filosofo_%s) Devuelve los palillos: %d - %d. HA TERMINADO DE COMER", nombreHilo, palillo1, palillo2);
    }

    private long getRandomEatTime(){
        return ThreadLocalRandom.current().nextLong(1, 3) * 1000;
    }

}
