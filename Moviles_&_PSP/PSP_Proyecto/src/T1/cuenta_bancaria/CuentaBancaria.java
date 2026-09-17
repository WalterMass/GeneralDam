package T1.cuenta_bancaria;

public class CuentaBancaria {

    private int gastos;

    public CuentaBancaria(int gastos) {
        this.gastos = gastos;
    }

    public int getGastos() {
        return gastos;
    }
    public void incrementarGastos(int incremento) {
        this.gastos = gastos + incremento;
    }
}
