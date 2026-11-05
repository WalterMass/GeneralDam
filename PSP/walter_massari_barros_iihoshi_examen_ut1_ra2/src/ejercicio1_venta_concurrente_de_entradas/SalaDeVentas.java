package ejercicio1_venta_concurrente_de_entradas;

import java.util.ArrayList;
import java.util.List;

public class SalaDeVentas {
    public static final Object LOCK1 = new Object();
    public static int numeroDeEntradas;
    public static int vendidas = 0;
    private final ArrayList<Thread> vendedores;


    public SalaDeVentas(int numVendedores, int numEntradas, int numIntentosVenta) {
        Tarea tarea = new Tarea(numIntentosVenta);

        List<Thread> listVendedores = new ArrayList<>();
        for (int i = 0; i < numVendedores; i++) {
            String nombre = "VENDEDOR-"+i;
            listVendedores.add(new Thread(tarea,nombre));
        }

        this.vendedores = (ArrayList<Thread>) listVendedores;
        this.numeroDeEntradas = numEntradas;
    }

    public void comenzarVentas(){
        while (numeroDeEntradas != 0){
            for(Thread vendedor : vendedores){
                vendedor.start();
            }
        }

        for(Thread vendedor : vendedores){
            try {
                vendedor.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("\nSe han vendido %d, quedan %d", vendidas, numeroDeEntradas);

    }


    public ArrayList<Thread> getVendedores() {
        return vendedores;
    }





}
