package T1.repaso_executor.ejercicio4;

public class Ejercicio4 {
    public static final String[] NOMBRE_HERRAMIENTAS = {"DESTORNILLADOR", "ALICATES", "TALADRO"};
    public static final int[] ACT_NUM_TRABAJADORES = {2, 1, 1};
    public  static final String[][] HERRAMIENTAS_NECESARIAS_EN_ACT = {
            {"DESTORNILLADOR", "TALADRO"},
            {"DESTORNILLADOR, ALICATES"},
            {"TALADRO, DESTORNILLADOR, ALICATES"}
    };


    static void main(String[] args) {
        Obra obra = new Obra();
        obra.empezarObra(NOMBRE_HERRAMIENTAS, ACT_NUM_TRABAJADORES, HERRAMIENTAS_NECESARIAS_EN_ACT);
    }

}
/*Ejercicio 4
Existen varias actividades de reparación que necesitan determinadas herramientas para
llevarse a cabo, a saber: un taladro, un destornillador y unos alicates. De estas herramientas
solo hay una de cada tipo. La actividad A1 necesita un destornillador y un taladro. La actividad
A2 necesita un destornillador y unos alicates. La actividad A3 necesita un taladro, un
destornillador y unos alicates. Las actividades las realizan, continuamente, un conjunto de
agentes. Existen dos agentes que realizan la actividad A1, un agente que realiza la actividad A2
y un agente que realiza la actividad A3. Cada actividad tarda en realizarse un tiempo de entre
50 y 200 ms.
Realiza una simulación de estas actividades. Las actividades se realizan de forma indefinida.


Ejercicio 4.1
Realiza lo mismo pero utilizando semáforos de 1 permiso para las herramientas.*/