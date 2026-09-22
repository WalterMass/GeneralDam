package T1.ejemploRunnable;

public class Hilo implements Runnable{

    private final String nombre;

    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run(){
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        System.out.printf("Hola, soy el hilo %s \n" , nombre);
    }
}
