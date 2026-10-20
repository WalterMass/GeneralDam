package T1.repaso_executor.ejercicio2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class NumeroSecreto {
    public static AtomicInteger numeroPartida= new AtomicInteger(1);

    private final int numero;
    AtomicBoolean descubierto = new AtomicBoolean(false);

    public NumeroSecreto(int numero) {
        this.numero = numero;
    }

    // comprueba si el numero es verdadero
    public synchronized int probuestaNumero(int propuesta, int numeroPartida) {
        // devuelve -1 si descubierto esta marcado como verdadero
        if (this.descubierto.get()) {
            return -1;
            // si no lo esta comprueba que el el parametro propuesta sea igual al numero secreto
        } else {
            //si el parametro propuesta es igual al numero secreto devuelve 1
            if (propuesta == this.numero) {
                this.descubierto.set(true);
                return 1;
                //caso contrario devuelve 0
            } else return 0;
        }
    }

    public int getNumPartida(){
        return numeroPartida.get();
    }

    public AtomicBoolean getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(AtomicBoolean descubierto) {
        this.descubierto = descubierto;
    }
}
