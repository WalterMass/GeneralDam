package fastbox_proceso;

import fastbox_utilities.EstadoPedido;
import fastbox_utilities.Utils;

import java.util.concurrent.Semaphore;

public class Recursos {
    public static int numeroEtiqueta = 1;
    public static final Object lock1 = new Object();

    private Semaphore puestosDePreparacion;
    private Semaphore impresoras;

    public Recursos(int numPuestos, int numImpresoras) {
        this.impresoras = new Semaphore(numPuestos);
        this.puestosDePreparacion = new Semaphore(numImpresoras);
    }


    public void prepararPedido(Pedido pedido) throws InterruptedException {
        boolean pedidoPreparado = false;
        do{
            if ( permisoConcedido(puestosDePreparacion.availablePermits()) ){
                pedido.setEstado(EstadoPedido.PREPARANDO);

                System.out.println("Preparando: "+pedido);

                puestosDePreparacion.acquire();

                int sleepTime = Utils.rand.nextInt(1000, 5001);

                Thread.sleep(sleepTime);

                puestosDePreparacion.release();

                System.out.println("Preparacion terminada: "+pedido);

                pedidoPreparado = true;
            }
        }while(!pedidoPreparado);
    }

    public void etiquetarPedido(Pedido pedido)throws InterruptedException{
        boolean pedidoEtiquetado = false;
        do{
            if ( permisoConcedido(impresoras.availablePermits()) ){
                pedido.setEstado(EstadoPedido.ETIQUETANDO);

                System.out.println("Etiquetando: "+pedido);

                impresoras.acquire();

                int sleepTime = Utils.rand.nextInt(1000, 5001);

                Thread.sleep(sleepTime);


                synchronized (lock1){
                    pedido.setCodigoEtiqueta(getEtiquetaUnica());
                    numeroEtiqueta++;
                }

                pedido.setEstado(EstadoPedido.COMPLETADO);

                System.out.println("Etiquetado terminado: "+pedido);

                impresoras.release();

                pedidoEtiquetado = true;
            }
        }while (!pedidoEtiquetado);
    }

    private String getEtiquetaUnica(){
        return String.format("FB-%04d", numeroEtiqueta);
    }

    public boolean permisoConcedido(int permisosDisponibles){
        return permisosDisponibles >= 1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Semaphore getImpresoras() {
        return impresoras;
    }

    public Semaphore getPuestosDePreparacion() {
        return puestosDePreparacion;
    }

    public void setImpresoras(Semaphore impresoras) {
        this.impresoras = impresoras;
    }

    public void setPuestosDePreparacion(Semaphore puestosDePreparacion) {
        this.puestosDePreparacion = puestosDePreparacion;
    }
}
