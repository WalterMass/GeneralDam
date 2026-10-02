package T1.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LanzadorHilosExecutorV2 {

    static void main() {

        try(ExecutorService executor = Executors.newFixedThreadPool(2)){
            ProcesarPedidoV2 pedidos = new ProcesarPedidoV2();

            executor.execute( () -> pedidos.procesarPedido(1));
            executor.execute( () -> pedidos.procesarPedido(2));
            executor.execute( () -> pedidos.procesarPedido(3));
            executor.execute( () -> pedidos.procesarPedido(4));
            executor.execute( () -> pedidos.procesarPedido(5));
        }
    }
}
