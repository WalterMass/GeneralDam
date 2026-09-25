package T1.cuerpo_humano;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int NUM_RECEPTORES_CUERPO = 3;
    private static final int NUMERO_VIRUS =10;

    static void main() throws InterruptedException {

        CuerpoHumano cuerpo = new CuerpoHumano(NUM_RECEPTORES_CUERPO);
        List<Virus> losVirus = new ArrayList<>();

        for (int numVirus = 1; numVirus <= NUMERO_VIRUS ; numVirus++) {
            String nombre = "Virus-" + numVirus;
            Virus elVirus = new Virus(nombre, cuerpo);
            //elVirus.setPriority();
            losVirus.add(elVirus);

        }

        losVirus.forEach(Virus::start);

        for (Virus v: losVirus){
            v.join();
        }

    }
}
