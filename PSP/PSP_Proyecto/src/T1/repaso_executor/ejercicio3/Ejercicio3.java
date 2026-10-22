package T1.repaso_executor.ejercicio3;

public class Ejercicio3 {

    static final String[] LIBROS = {
            "Don Quijote de la Mancha",
            "Cien años de soledad",
            "El principito",
            "1984",
            "La sombra del viento",
            "El señor de los anillos",
            "Orgullo y prejuicio",
            "Crimen y castigo",
            "Los miserables"
    };

    static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(LIBROS);
        biblioteca.estudiar();
    }

}
