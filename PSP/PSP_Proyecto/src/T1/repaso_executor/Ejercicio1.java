package T1.repaso_executor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Ejercicio1 {
    static final int NUM_HILOS = 10;
    static Random rand = new Random();
    static void main() {
        execute();
    }
    public static void execute(){
        try ( ExecutorService executor = Executors.newFixedThreadPool(NUM_HILOS) ) {

            NumeroSecreto numeroS = new NumeroSecreto(tantear());

            // mientras la variable AtomicBoolean descubierto dentro de numeroS sea falso, van a seguir buscando

            for(int i = 0; i < NUM_HILOS; i++){
                intentarAdivinar(executor, numeroS);
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static void intentarAdivinar(ExecutorService executor, NumeroSecreto numeroS) throws RuntimeException{
        executor.submit(
                () -> {
                    String nombreHilo = Thread.currentThread().getName().toUpperCase();
                    while(!numeroS.getDescubierto().get()){

                        int propuesta = tantear();
                        System.out.println(nombreHilo + ": INTENTA ADIVINAR EL NUMERO CON LA PROPUESTA -> " + propuesta);
                        int resultadoPropuesta = numeroS.probuestaNumero(propuesta);

                        if (resultadoPropuesta == -1){
                            System.out.printf("%s: EL JUEGO YA HA TERMINADO\n"
                                    ,nombreHilo
                            );
                            break;
                        }else {
                            if (resultadoPropuesta == 1){
                                System.out.printf("%s: HA ADIVINADO EL NUMERO CON SU PROPUESTA -> %d\n"
                                        ,nombreHilo
                                        ,propuesta
                                );
                                break;
                            }else if (resultadoPropuesta == 0){
                                System.out.printf("%s: NO HA LOGRADO HA ADIVINAR EL NUMERO CON ESTA PROPUESTA -> %d\n"
                                        ,nombreHilo
                                        ,propuesta
                                );
                            }
                        }
                    }

                }

        );
    }

    public static int tantear(){
        return rand.nextInt(0, 101);
    }
}

