package T1.cuerpo_humano;

public class Virus extends Thread{

    private String nombre;
    private CuerpoHumano cuerpoHumano;

    public Virus(String nombre, CuerpoHumano cuerpoHumano) {
        this.nombre = nombre;
        this.cuerpoHumano = cuerpoHumano;
    }

    @Override
    public void run() {
       // System.out.println("Soy el virus " + nombre + " y voy a intentar infectar el cuerpo");

        //infectar
        try {
            cuerpoHumano.infectar(nombre);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("El virus " + nombre + " termina de hacer su trabajo");

    }
}
