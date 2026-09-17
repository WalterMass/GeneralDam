package T1.cuenta_bancaria;
// clase principal
public class ProcesadorPagos {
    public static int TOTAL_GASTOS;
    public static int NUM_CLIENTES;

    static void main(String[] args) {
        System.out.println("PROCESADOR DE PAGOS");

    }

    public static void execute(){
        CuentaBancaria cuenta = new CuentaBancaria(0);
        Cliente[] clientes = new Cliente[10];
        for (int i = 0; i < 10; i++){
            clientes[i] = new Cliente(cuenta, 0);
            clientes[i].start();
        }
    }
}
