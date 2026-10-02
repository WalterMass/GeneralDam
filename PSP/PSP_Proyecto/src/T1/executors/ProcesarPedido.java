package T1.executors;

public class ProcesarPedido implements Runnable{
    private final int pedidoId;

    public ProcesarPedido(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    @Override
    public void run() {
        //Mensaje inicio
        System.out.printf("Procesando pedido %d en %s \n",
                            pedidoId,
                            Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //Mensaje fin
        System.out.printf("Pedido %d terminado \n", pedidoId);
    }
}
