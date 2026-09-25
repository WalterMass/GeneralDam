package T1.cuenta_bancaria;

import java.util.Random;

public class Cliente extends Thread{
    private String nombre;
    private CuentaBancaria cuenta;
    private int gastosRealizados = 0;
    private final int gastosARealizar = ProcesadorPagos.TOTAL_GASTOS/ProcesadorPagos.NUM_CLIENTES;


    public Cliente(CuentaBancaria cuenta, String nombre) {
        this.cuenta = cuenta;
        this.nombre = nombre;

    }

    @Override
    public void run(){
        Random r = new Random();
        while( gastosARealizar != gastosRealizados ){
            int compra = r.nextInt(ProcesadorPagos.TOTAL_GASTOS - gastosRealizados);
            if ((gastosRealizados + compra) <= gastosARealizar){
                incrementoGastosRealizados(compra);
                cuenta.incrementarGastos(compra);
                System.out.println(this.nombre + " -> " + compra);
            }
        }
        System.out.println(this.nombre+" ha gastado todo!" + gastosRealizados);
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public int getGastosRealizados() {
        return gastosRealizados;
    }


    public int getGastosARealizar() {
        return gastosARealizar;
    }

    public void incrementoGastosRealizados(int gastosRealizados) {
        this.gastosRealizados += gastosRealizados;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }
}
