package T1.cuenta_bancaria_corregido;

public class CuentaBancaria {

    private int gastos;

    public synchronized int incrementarGasto(){
        gastos++;
        return gastos;
    }

    public int getGastos() {
        return gastos;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "gastos=" + gastos +
                '}';
    }
}
