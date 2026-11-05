package ejercicio1_venta_concurrente_de_entradas;

import java.util.concurrent.ThreadLocalRandom;

public class Tarea implements Runnable{

    private int numIntentos;

    public Tarea(int numIntentos) {
        this.numIntentos = numIntentos;
    }

    @Override
    public void run() {
        try {
            String nombreVendedor = Thread.currentThread().getName();
            while(SalaDeVentas.numeroDeEntradas != 0){
                if (numIntentos > 0){
                    boolean intentasVender = getRandomAnswer();
                    numIntentos--;
                    synchronized (SalaDeVentas.LOCK1){
                        if (intentasVender && SalaDeVentas.numeroDeEntradas != 0){
                            System.out.printf("\n%s ha logrado vender una entrada, intentos: %d", nombreVendedor, numIntentos);
                            SalaDeVentas.numeroDeEntradas--;
                            SalaDeVentas.vendidas++;
                        }else if(!intentasVender){
                            System.out.printf("\n%s no ha logrado vender la entrada, intentos: %d", nombreVendedor, numIntentos);
                        }
                    }
                }else if (numIntentos == 0){
                    System.out.printf("\n%s no tiene más intentos disponibles ", nombreVendedor);
                    break;
                }else {
                    break;
                }

                System.out.printf("\nQuedan entradas %s por vender ", SalaDeVentas.numeroDeEntradas);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }



    public boolean getRandomAnswer(){
        int num = ThreadLocalRandom.current().nextInt(0, 2);
        return (num == 1);
    }
}
