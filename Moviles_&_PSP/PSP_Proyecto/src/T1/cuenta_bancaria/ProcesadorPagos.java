package T1.cuenta_bancaria;
// clase principal
public class ProcesadorPagos {
    public static int TOTAL_GASTOS = 100000;
    public static int NUM_CLIENTES = 10;

    static void main(String[] args) {
        System.out.println("PROCESADOR DE PAGOS");

        try{
            execute();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void execute() throws InterruptedException {
        CuentaBancaria cuenta = new CuentaBancaria(0);
        Cliente[] clientes = new Cliente[NUM_CLIENTES];
        for (int i = 0; i < clientes.length; i++){
            String nombre = "Esposa nº"+(i+1);
            clientes[i] = new Cliente(cuenta, nombre);
        }

        for (Cliente c : clientes) {
            c.start();
        }

        for (Cliente c : clientes){
            c.join();
        }
        System.out.println("Que ruina!"+cuenta.getGastos());

        for (Cliente cliente : clientes) {
            System.out.println(cliente.getName()+" ha gastado "+cliente.getGastosRealizados());
        }
    }
}
