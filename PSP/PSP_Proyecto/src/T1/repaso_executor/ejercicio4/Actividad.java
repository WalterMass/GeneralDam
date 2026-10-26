package T1.repaso_executor.ejercicio4;

import java.util.List;

public class Actividad {
    private List<Herramienta> herramientas;
    private final int num_trabajadores;

    public Actividad(List<Herramienta> herramientas, int num_trabajadores) {
        this.herramientas = herramientas;
        this.num_trabajadores = num_trabajadores;
    }

    public List<Herramienta> getHerramientas() {
        return herramientas;
    }

    public int getNum_trabajadores() {
        return num_trabajadores;
    }
}
