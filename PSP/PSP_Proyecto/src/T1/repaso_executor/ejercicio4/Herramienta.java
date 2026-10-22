package T1.repaso_executor.ejercicio4;

import java.util.concurrent.atomic.AtomicBoolean;

public class Herramienta {

    private String nombre;
    AtomicBoolean enUso = new AtomicBoolean(false);

    public Herramienta(String nombre) {
        this.nombre = nombre;
    }
}
