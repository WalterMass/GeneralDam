package T1.cuenta_bancaria_corregido;

import java.util.ArrayList;
import java.util.List;

public class ProcesadorPagos {

    private final static int TOTAL_CLIENTES = 5;
    private final static int TOTAL_GASTOS_REALIZAR = 1_000;

    static void main() throws InterruptedException {

        List<Cliente> clientes = new ArrayList<>();
        CuentaBancaria miCuenta = new CuentaBancaria();

        //Reparto de gastos por cliente
        int gastosRealizarPorCliente = TOTAL_GASTOS_REALIZAR / TOTAL_CLIENTES;

        System.out.printf("Vamos a lanzar %d clientes, y cada uno hará %d gastos \n", TOTAL_CLIENTES, gastosRealizarPorCliente);
        for (int numCliente = 1; numCliente <= TOTAL_CLIENTES; numCliente++) {
            Cliente cli = new Cliente(miCuenta, gastosRealizarPorCliente);
            clientes.add(cli);
        }

        //Para cada cliente, ejecuta su metodo start
        clientes.forEach(Cliente::start);

        //Esperamos a que terminen
        for (Cliente cli : clientes){
            cli.join();
        }

        //Consultamos los gastos realizados en la cuenta bancaria
        System.out.printf("Programa terminado. La cuenta bancaria tiene %d gastos \n", miCuenta.getGastos());
    }
}
