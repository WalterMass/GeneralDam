package T1.ejemploThread;

public class LanzaHilonMask {
    static void main() throws InterruptedException {
        System.out.println("soy el hilo principal");
        for (int contHilo = 0; contHilo < 5; contHilo++){
            String name = "Hilo"+contHilo;
            HilonMask hilon = new HilonMask(name);
            hilon.start();
            hilon.join();
        }
    }


}
