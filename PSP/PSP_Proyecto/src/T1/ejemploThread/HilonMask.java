package T1.ejemploThread;

import java.util.Random;

public class HilonMask extends Thread{

    public HilonMask(String name) {
        super(name);
    }

    @Override
    public void run(){
        Random r = new Random();
        int segundos = r.nextInt(10);
        try{
            Thread.sleep(segundos * 1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        System.out.println("Hola soy el "+getName()+" y he dormido "+ segundos +" segundos.");

    }
}
