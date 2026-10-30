package T1.repaso_executor.ejercicio4;

import java.util.ArrayList;
import java.util.Arrays;
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

        int i  = 0;
        while ( i <= 10 ){
            System.out.printf("\nVuelta Nº%d:", i+1) ;
            realizarActividades(actividades);
            i++;
            System.out.println("\n\n\n");
        }
    }

    /*este bloque de codigo recoge las actividades creadas desde empezar obra
    y llama a una funcion diferente por cada actividad para que ejecete sus
    trabajos con executorservice*/
    private void realizarActividades(Actividad[] actividades){
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
                //este bloque es importante, por cada tarea crea un executorservice y le manda las herramientas necesarias para realizar la actividad

                //si la barrera no es null el trabajo que ejecuta sera trabajoMultiHilo()
                if (barrier != null){
                    for (int i = 0; i < actividad.getHerramientasNecesarias().length; i++) {
                        trabajoMultiHilo(
                                executor,
                                actividad,
                                actividad.getHerramientasNecesarias()[i],
                                barrier,
                                getRandomActTime()
                        );
                    }

                //caso contrario ejecutara trabajoMonoHilo()
                }else {
                    trabajoMonoHilo(executor, actividad, getRandomActTime());
                }

            }
        }

    }

    private void trabajoMonoHilo(ExecutorService executor, Actividad actividad, long tiempoAct) {
        executor.submit( () -> {
            String nombreHilo = Thread.currentThread().getName();

            String[] nombresNecesarios = actividad.getHerramientasNecesarias();
            Arrays.sort(nombresNecesarios);

            boolean[] adquiridas = new boolean[nombresNecesarios.length];
            Arrays.fill(adquiridas, false);

            try {
                // 1. Adquirimos en orden estricto y secuencial
                for (int i = 0; i < nombresNecesarios.length; i++) {
                    Herramienta herramientaActual = getHerramientaByName(actividad.getHerramientas(), nombresNecesarios[i]);
                    herramientaActual.acquire();
                    adquiridas[i] = true;
                    mensajeAdquirirHerramienta(actividad.getNombre(), nombreHilo, nombresNecesarios[i]);
                }

                // --- SECCIÓN CRÍTICA ---
                // ¡Ya tenemos los 3 recursos! Ninguna otra acción puede interferir aquí.
                Thread.sleep(tiempoAct);


            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.printf("\nEl \"%s\" fue interrumpido mientras esperaba los recursos.", nombreHilo);
            }finally {
                // 2. Liberación segura en orden inverso (o el que corresponda) asegurando el finally
                for (int i = nombresNecesarios.length - 1; i >= 0; i--) {
                    if (adquiridas[i]){
                        Herramienta herramientaActual = getHerramientaByName(actividad.getHerramientas(), nombresNecesarios[i]);
                        herramientaActual.release();
                        mensajeLiberarHerramienta(actividad.getNombre(), nombreHilo, nombresNecesarios[i]);
                    }else{
                        System.out.printf("\n(%s)  %s - Algo ha salido mal al adquirir la herramienta %s",actividad.getNombre(), nombreHilo, nombresNecesarios[i]);
                    }
                }
            }



        });

    }


    private void trabajoMultiHilo(ExecutorService executor, Actividad actividad, String nombreHerramienta, CyclicBarrier barrier, long tiempoAct){

        executor.submit( () -> {
            String nombreHilo = Thread.currentThread().getName();
            Herramienta herramienta = getHerramientaByName(actividad.getHerramientas(), nombreHerramienta);
            try{


                herramienta.acquire();

                mensajeAdquirirHerramienta(actividad.getNombre(), nombreHilo, nombreHerramienta);


                barrier.await();

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
                mensajeLiberarHerramienta(actividad.getNombre(), nombreHilo, nombreHerramienta);
            }
        });

    }

    private Herramienta getHerramientaByName(List<Herramienta> herramientas, String name){
        return herramientas.stream()
                .filter( a -> a.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    private long getRandomActTime(){
        return ThreadLocalRandom.current().nextLong(5, 20) * 10;
    }

    private void mensajeAdquirirHerramienta(String nombre, String nombreHilo, String nombreHerramienta){
        System.out.printf("\n(%s) - %s : Ha cogido la herramienta %s"
                ,nombre
                ,nombreHilo
                ,nombreHerramienta);
    }

    private void mensajeLiberarHerramienta(String nombre, String nombreHilo, String nombreHerramienta) {
        System.out.printf("\n(%s) - %s : ha terminado su trabajo y libera la herramienta %s"
                ,nombre
                ,nombreHilo
                ,nombreHerramienta);
    }

}
