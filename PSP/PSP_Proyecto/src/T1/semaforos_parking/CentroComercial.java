package T1.semaforos_parking;

import java.util.ArrayList;
import java.util.List;

public class CentroComercial {
    public static final int NUM_COCHES = 5;
    public static final int PLAZAS_PARKING = 2;

    static void main() {
        Parking parking = new Parking(PLAZAS_PARKING);
        List<Coche> coches = new ArrayList<>();

        for (int i  = 0; i < NUM_COCHES; i++){
            Coche coche = new Coche(i+1, parking);
            coches.add(coche);
        }

        coches.forEach(Coche::start);

    }
}