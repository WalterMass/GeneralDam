package walter_massari_barros_iihoshi_practica01;

import java.util.Scanner;

public class Ejercicio6 {
    /*
        6. Crea una clase EdadFueraDeRango y un programa que cuente con un
        metodo que solicite al usuario su edad. Si la edad recibida está fuera del
        rango del 0 al 120 lanzará la excepción, el metodo main la capturará y
        avisará al usuario.
    */

    static int solicitarEdad() throws ExceptionEdadFueraDeRango{
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu edad");
        int edad = sc.nextInt();
        if (edad < 0 || edad > 120){
            throw new ExceptionEdadFueraDeRango("edad fuera de rango");
        }
        return edad;
    }

    static void main(String[] args) {
        try {
            int edad = solicitarEdad();
            System.out.println("Estas dentro del rango");
        } catch (ExceptionEdadFueraDeRango e) {
            System.out.println("error: " + e.getMessage());
        }
    }

}
class ExceptionEdadFueraDeRango extends Exception{
    public ExceptionEdadFueraDeRango(String message){
        super(message);
    }
}
