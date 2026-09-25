package T1.semaforos_parking;

import java.util.concurrent.Semaphore;

public class Coche {
    private int numeroCoche;
    private boolean expulsado = false;
    private Parking parking;

    public Coche(int numeroCoche, boolean expulsado, Parking parking) {
        this.numeroCoche = numeroCoche;
        this.expulsado = expulsado;
        this.parking = parking;
    }



    public int getNumeroCoche() {
        return numeroCoche;
    }

    public void setNumeroCoche(int numeroCoche) {
        this.numeroCoche = numeroCoche;
    }

    public boolean isExpulsado() {
        return expulsado;
    }

    public void setExpulsado(boolean expulsado) {
        this.expulsado = expulsado;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
