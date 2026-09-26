package T1.semaforos_parking;

import java.util.Random;

public class Coche extends Thread {
    private int numeroCoche;
    private boolean expulsado = false;
    private Parking parking;

    public Coche(int numeroCoche, Parking parking) {
        this.numeroCoche = numeroCoche;
        this.parking = parking;
    }

    @Override
    public void run(){
        try{
            while (true){
                System.out.printf("\nEl coche numero %d empieza a dar vueltas...",
                        this.getNumeroCoche());
                int millis = getSleepTime();
                Thread.sleep(millis);
                int cochesEnCola = parking.getSemaforo().getQueueLength();
                int plazasLibres = parking.getSemaforo().availablePermits();
                System.out.printf("\nEl coche numero %d deja de dar vueltas, va a aparcar | COCHES EN COLA: %d TICKETS DISPONIBLES: %d",
                        this.getNumeroCoche(),
                        cochesEnCola,
                        plazasLibres);
                if (parking.getSemaforo().getQueueLength() <= 5 ){
                    parking.estacionar(numeroCoche);
                }else {
                    System.out.printf("\nCoche numero %d: Hay mucha cola en el parking, mejor damos otra vuelta",
                            this.getNumeroCoche());
                }
            }
        }catch (InterruptedException e){

        }
    }

    public static int getSleepTime(){
        Random rand = new Random();
        return rand.nextInt(1000, 5000);
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