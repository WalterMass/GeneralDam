package T1.repaso_executor.ejercicio4;

import java.util.List;

public class Actividad {
    private final String nombre;
    private List<Herramienta> herramientas;
    private String[] herramientasNecesarias;
    private final int num_trabajadores;

    public Actividad(List<Herramienta> herramientas, String nombre,String[] herramientasNecesarias ,int num_trabajadores) {
        this.herramientas = herramientas;
        this.num_trabajadores = num_trabajadores;
        this.nombre = nombre;
        this.herramientasNecesarias = herramientasNecesarias;
    }

    public List<Herramienta> getHerramientas() {
        return herramientas;
    }

    public int getNumTrabajadores() {
        return num_trabajadores;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getHerramientasNecesarias() {
        return herramientasNecesarias;
    }

    public int getNum_trabajadores() {
        return num_trabajadores;
    }
}
