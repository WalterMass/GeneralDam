package ejercicio1_venta_concurrente_de_entradas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int NUM_ENTRADAS = 100;
    public static final int NUM_VENDEDORES = 4;
    public static final int NUM_INTENTOS_VENDEDOR = 40;

    static void main(String[] args) {
        SalaDeVentas salaDeVentas = new SalaDeVentas(NUM_VENDEDORES, NUM_ENTRADAS, NUM_INTENTOS_VENDEDOR);
        salaDeVentas.comenzarVentas();
    }
}
