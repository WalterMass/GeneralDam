package T1.cuenta_bancaria_corregido;

public class Cliente extends Thread{

    private CuentaBancaria cuenta;
    private int gastosARealizar;//los que tiene que hacer
    private int gastosRealizados;//la contabilizacion de los que ha hecho

    public Cliente(CuentaBancaria cuenta, int gastosARealizar) {
        this.cuenta = cuenta;
        this.gastosARealizar = gastosARealizar;
    }

    @Override
    public void run() {

        for (int numGasto = 0; numGasto < gastosARealizar; numGasto++) {
            this.cuenta.incrementarGasto();
            this.gastosRealizados++;
        }

        System.out.println("He terminado los gastos. He realizado: " + gastosRealizados);
    }
}
