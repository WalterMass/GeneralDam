package T1.repaso_executor.ejercicio4;

import java.util.concurrent.Semaphore;

public class Herramienta extends Semaphore {
    private final static int PERMISOS_HERRAMIENTA = 1;
    private final String nombre;

    public Herramienta(String nombre) {
        super(PERMISOS_HERRAMIENTA);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
