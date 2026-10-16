package walter_massari_barros_iihoshi_practica01;

import java.util.Random;

public class Ejercicio5 {
    /*
        5. Crea una clase ExcepcionDivisionPorCero y un programa que tenga un
        metodo que realice la división de dos números enteros. Este metodo
        lanzará esta excepción si caso de intentar dividir por cero y el metodo
        main recogerá la excepción, informando del error al usuario.
    */

    static void division(int num1, int num2)throws ExcepcionDivisionPorCero{
        if (num2 == 0){
            throw new ExcepcionDivisionPorCero("error, division entre 0");
        }
        System.out.println((num1/num2));
    }
    static void main(String[] args) {
        Random r = new Random();
        try {
            division(r.nextInt(1, 10), 0);
        }catch (ExcepcionDivisionPorCero e){
            System.out.println("No se puede dividir entre cero");
        }
    }

}
class ExcepcionDivisionPorCero extends Exception {
    public ExcepcionDivisionPorCero(String message) {
        super(message);
    }
}

