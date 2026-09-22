package T1.ejemploRunnable;

public class LanzaHilos {

    static void main() throws InterruptedException {
        Hilo h1 = new Hilo("H1");
        Hilo h2 = new Hilo("H2");

        Long tiempoInicio = System.currentTimeMillis();
        Thread contenedorHilo1 = new Thread(h1);
        Thread contenedorHilo2 = new Thread(h2);

        contenedorHilo1.start();
        contenedorHilo1.join();

        contenedorHilo2.start();
        Long tiempoFin = System.currentTimeMillis();


        System.out.println("El MAIN ha terminado");
        System.out.println("Ha tardado (ms): "+(tiempoFin - tiempoInicio));

    }

}
