package ejercicio2_procesamiento_de_trabajos;

public class Trabajo {
    private final int id;
    private final int numPiezas;
    private int numPiezasTerminadas;

    public Trabajo(int id, int numPiezas) {
        this.id = id;
        this.numPiezas = numPiezas;
        numPiezasTerminadas = 0;
    }

    public int getId() {
        return id;
    }

    public int getNumPiezas() {
        return numPiezas;
    }

    public int getNumPiezasTerminadas() {
        return numPiezasTerminadas;
    }


    public void incrementarPiezasTerminadas() {
        this.numPiezasTerminadas++;
    }
}
