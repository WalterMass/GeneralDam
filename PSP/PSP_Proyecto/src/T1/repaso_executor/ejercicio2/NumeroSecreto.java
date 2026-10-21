package T1.repaso_executor.ejercicio2;


import java.util.Random;

public class NumeroSecreto {
    static Random rand = new Random();

    private int numeroPartida= 1;
    private final int totalPartidas;
    private int numero;
    private boolean juegoTerminado = false;

    public NumeroSecreto(int numero, int totalPartidas) {
        this.numero = numero;
        this.totalPartidas = totalPartidas;
    }

    /*METODO PRINCIPAL*/

    public synchronized int propuestaNumero(int propuesta, int idPartida) {

        boolean partidaNoEsActual = numeroPartida != idPartida;

        if (juegoTerminado || partidaNoEsActual) {
            return -1;
        } else {

            boolean propuestaEsGanadora = propuesta == this.numero;

            if (propuestaEsGanadora) {
                numeroPartida++;

                juegoTerminado = numeroPartida > totalPartidas ;
                if (!juegoTerminado){
                    this.numero = tantear();
                }

                return 1;

            } else {
                return 0;
            }
        }
    }

    /*METODOS AUXILIARES*/

    public synchronized int getNumPartida(){
        return numeroPartida;
    }


    public static int tantear(){
        return rand.nextInt(0, 101);
    }

    /*GETTERS & SETTERS*/
    public synchronized boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public void setJuegoTerminado(boolean juegoTerminado) {
        this.juegoTerminado = juegoTerminado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
