package T1.repaso_executor.ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Obra {
    public void empezarObra(String[] nombreHerramientas, int[] actNumTrabajadores) {

        List<Herramienta> herramientas = new ArrayList<>();

        for (int i = 0; i < herramientas.size(); i++) {
             herramientas.add(new Herramienta(nombreHerramientas[i]));
        }

        Actividad[] actividades = new Actividad[actNumTrabajadores.length];

        for (int i = 0; i < actividades.length; i++) {
            actividades[i] = new Actividad(herramientas, actNumTrabajadores[i]);
        }
        
        realizarActividades(actividades, herramientas);
    }
    
    public void realizarActividades(Actividad[] actividades, List<Herramienta> herramientas){
        int numHilos = 0;
        for (int i = 0; i < actividades.length; i++) {
            numHilos += actividades[i].getNum_trabajadores();
        }

        try (ExecutorService executor = Executors.newFixedThreadPool(numHilos)){
            realizarAct1(actividades[0], executor);

        }
    }

    public void realizarAct1(Actividad actividad, ExecutorService executor){
        executor.submit( () -> {
            String nombreHilo = Thread.currentThread().getName();
            String nombreHerramienta = "DESTORNILLADOR";
            Herramienta herramienta = getHerramientaByName(actividad.getHerramientas(), nombreHerramienta);
            try{
                System.out.printf("\n(Actividad-1) %s: intenta coger %s",nombreHilo, nombreHerramienta);
                herramienta.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                herramienta.release();
            }
        });
    }

    public Herramienta getHerramientaByName(List<Herramienta> herramientas, String name){
        return herramientas.stream()
                .filter( a -> a.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
