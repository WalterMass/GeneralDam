package T1.carreras;

import java.util.Random;

import static java.lang.Character.getName;

public class Corredor extends Thread implements Runnable{

    private final String nombre;
    private Long tiempo = -1L;

    public Corredor(String nombre) {
        this.nombre = nombre;
    }

    public void setTiempo(Long tiempo){
        this.tiempo = tiempo;
    }

    public Long getTiempo() {
        return tiempo;
    }

    @Override
    public void run(){
        Random r = new Random();
        long acumulador = 0L;
        System.out.println(nombre);
        for (int i = 0; i < LanzarCarrera.PARTICIPANTES; i++){
            long segundos = r.nextLong(1,4);
            try{
                Thread.sleep(segundos * 1000);
                acumulador = acumulador+segundos;
                System.out.println(this.nombre+" vuelta nº"+(i+1)+ " ha tardado "+segundos+" s");
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        }
        setTiempo(acumulador);
        System.out.println(nombre + " ha tardado : " + acumulador +" s.");
    }

    @Override
    public String toString() {
        return
                nombre +
                ", tiempo=" + tiempo;
    }
}

