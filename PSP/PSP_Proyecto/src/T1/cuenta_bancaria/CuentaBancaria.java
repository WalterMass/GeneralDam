package T1.cuenta_bancaria;

import java.util.concurrent.atomic.AtomicInteger;

public class CuentaBancaria {

    private AtomicInteger gastos;

    public CuentaBancaria(AtomicInteger gastos) {
        this.gastos = gastos;
    }

    public AtomicInteger getGastos() {
        return gastos;
    }

    public synchronized void incrementarGastos(int incremento) {
        this.gastos.getAndSet(this.gastos.intValue() + incremento);
    }

}
