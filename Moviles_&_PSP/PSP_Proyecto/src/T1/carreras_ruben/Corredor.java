package T1.carreras_ruben;

import java.util.Random;

public class Corredor extends Thread{

    private String nombre;
    private long tiempoTotal=0;
    private final int vueltas=4;

    public Corredor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public long getTiempoTotal() {
        return tiempoTotal;
    }

    @Override
    public void run() {
        Random r = new Random();

        for (int i = 1; i <=vueltas ; i++) {
            long tiempoVuelta=3000+(r.nextInt(5)*1000);
            tiempoTotal=tiempoTotal+tiempoVuelta;
            try {
                Thread.sleep(tiempoVuelta);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(nombre+ " Ha terminado la vuelta " + i + " en "+ tiempoVuelta + " milisegundos" );
        }
        System.out.println("Tiempo total de  "+ nombre + " " + tiempoTotal);
    }
}
