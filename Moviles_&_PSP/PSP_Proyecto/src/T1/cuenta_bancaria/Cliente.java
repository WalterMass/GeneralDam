package T1.cuenta_bancaria;

public class Cliente extends Thread{
    private CuentaBancaria cuenta;
    private int gastosRealizados = 0;
    private int gastosARealizar;

    public Cliente(CuentaBancaria cuenta, int gastosARealizar) {
        this.cuenta = cuenta;
        this.gastosRealizados = gastosRealizados;
        this.gastosARealizar = gastosARealizar;
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


}
