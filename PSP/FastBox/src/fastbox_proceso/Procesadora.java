package fastbox_proceso;

import fastbox_utilities.Utils;

import java.util.ArrayList;
import java.util.List;

public class Procesadora {
    public static final int NUM_PUESTOS_PREPARACION = 3;
    public static final int NUM_IMPRESORAS = 2;
    public static final int NUM_PEDIDOS = 12;
    public static Recursos recursos = new Recursos(NUM_PUESTOS_PREPARACION,NUM_IMPRESORAS);

    public static int ordenDePedido = 0;

    public static void main(String[] args) {
        try{
            exe();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void exe() throws InterruptedException {
        List<Pedido> pedidos = new ArrayList<>();


        for (int i = 0; i < NUM_PEDIDOS; i++){
            ordenDePedido++;
            String idPedido = "P-"+ordenDePedido;
            int cantidad = Utils.rand.nextInt(1,11);
            pedidos.add(new Pedido(idPedido,cantidad, recursos));
            pedidos.get(i).start();
        }

        for(Pedido p:pedidos){
            p.join();
        }

        System.out.println("\n\nLista de Pedidos completados:\n".toUpperCase());
        for(Pedido p:pedidos){
            System.out.println(p);
        }
    }


}
