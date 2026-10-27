package T1.repaso_executor.ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Obra {

    /*funcion principal, crea las actividades con un array estatico
     de los nombres de los nombres de las herramientas y otro
     con los numeros de hilos de cada actividad*/
    public void empezarObra(String[] nombreHerramientas, int[] actNumTrabajadores, String[][] herramientasNecesariasEnAct) {

        List<Herramienta> herramientas = new ArrayList<>();

        for (String nombreHerramienta : nombreHerramientas) {
            herramientas.add(new Herramienta(nombreHerramienta));
        }

        Actividad[] actividades = new Actividad[actNumTrabajadores.length];

        for (int i = 0; i < actividades.length; i++) {
            String nombreAct = "Actividad-"+ (i + 1);
            actividades[i] = new Actividad(herramientas, nombreAct, herramientasNecesariasEnAct[i], actNumTrabajadores[i]);
        }
        
        realizarActividades(actividades);
    }

    /*este bloque de codigo recoge las actividades creadas desde empezar obra
    y llama a una funcion diferente por cada actividad para que ejecete sus
    trabajos con executorservice*/
    public void realizarActividades(Actividad[] actividades){

        for (Actividad actividad : actividades) {
            int trabajadores = actividad.getNumTrabajadores();

            // crea un CyclicBarrier para coordinar los hilos en caso de que el numero de trabajadores sea mayor que 1.
            CyclicBarrier barrier;
            if (trabajadores > 1){
                barrier = new CyclicBarrier(trabajadores);
            } else {
                barrier = null;
            }


            try (ExecutorService executor = Executors.newFixedThreadPool(trabajadores)){
                // este bloque es importante, por cada tarea crea un executorservice y le manda las herramientas necesarias para
                for (int i = 0; i < actividad.getHerramientasNecesarias().length; i++) {
                    trabajo(
                            executor,
                            actividad,
                            actividad.getHerramientasNecesarias()[i],
                            barrier,
                            getRandomActTime()
                    );
                }
            }
        }

        //trabajo(executor, actividad,"DESTORNILLADOR", barrier, getRandomActTime());
    }


    public void trabajo(ExecutorService executor, Actividad actividad, String nombreHerramienta, CyclicBarrier barrier, long tiempoAct){

        executor.submit( () -> {
            String nombreHilo = Thread.currentThread().getName();
            Herramienta herramienta = getHerramientaByName(actividad.getHerramientas(), nombreHerramienta);
            try{
                System.out.printf("\n(%s) - %s : Intenta coger la herramienta %s"
                        ,actividad.getNombre()
                        ,nombreHilo
                        ,nombreHerramienta);


                herramienta.acquire();

                if(barrier != null){
                    barrier.await();
                }

                System.out.printf("\n(%s) - %s : Empieza a trabajar en la actividad"
                        ,actividad.getNombre()
                        ,nombreHilo);
                Thread.sleep(tiempoAct);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                System.out.println(e.getClass()+": error de cordinacion de hilos, comprobar funcion trabajo()");
            } finally {
                herramienta.release();
                System.out.printf("\n(%s) - %s : ha terminado su trabajo y libera la herramienta %s"
                        ,actividad.getNombre()
                        ,nombreHilo
                        ,nombreHerramienta);

            }
        });

    }

    public Herramienta getHerramientaByName(List<Herramienta> herramientas, String name){
        return herramientas.stream()
                .filter( a -> a.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public long getRandomActTime(){
        return ThreadLocalRandom.current().nextLong(5, 20) * 10;
    }

}
