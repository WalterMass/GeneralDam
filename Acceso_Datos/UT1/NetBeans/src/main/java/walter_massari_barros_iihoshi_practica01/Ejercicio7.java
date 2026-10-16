package walter_massari_barros_iihoshi_practica01;

import java.util.Scanner;

public class Ejercicio7 {
    /*
        7. Crea un programa con un menú en el que pediremos al usuario que nos
        diga cuál de los platos típicos que le mostramos por pantalla le gusta más.
        En el caso de que el usuario nos devuelva una opción no contemplada
        devolveremos una excepción. Haz que el programa maneje esa
        excepción y muestre al usuario una mensaje informándole de su error.
    */
    static Scanner sc = new Scanner(System.in);

    static Plato elegirPlato() throws ExcepcionOpcionNoContemplada{
        String plato = sc.nextLine();
        return switch (plato.trim()) {
            case "1" -> Plato.LANGOSTA_COCIDA;
            case "2" -> Plato.FISH_N_CHIPS;
            case "3" -> Plato.NIGIRIS_DE_SALMON;
            default -> throw new ExcepcionOpcionNoContemplada("La opcion tecleada no existe");
        };
    }

    static void main(String[] args) {
        System.out.println("Elige un plato:"
                +"\n1) Langosta Cocida."
                +"\n2) Fish & Chips."
                +"\n3) Nigiris De Salmon.\n"
        );

        try{
            Plato plato = elegirPlato();
            System.out.println("Buen provecho: "+plato);
        } catch (ExcepcionOpcionNoContemplada e) {
            System.out.println("error: "+e.getMessage());;
        }
    }
}
enum Plato {
    LANGOSTA_COCIDA, FISH_N_CHIPS, NIGIRIS_DE_SALMON
}

class ExcepcionOpcionNoContemplada extends Exception{
    public ExcepcionOpcionNoContemplada (String message){
        super(message);
    }
}