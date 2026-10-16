package walter_massari_barros_iihoshi_practica01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {

/*    2. Crea un metodo que se encarga de recoger por consola números que le
    proporcione el usuario. Si el usuario introduce otro tipo de dato que no sea
    número entero el metodo deberá propagar la excepción al metodo main y
    este lo recogerá y escribirá un mensaje informando del error.*/

    static void metodo() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int numero = -1;

        // 0 termina el bucle
        while (numero != 0){
            System.out.println("Introduce un numero enterro");
            numero = sc.nextInt();
            System.out.println(numero+ " es un enterro");
        }
    }

    static void main(String[] args) {
        try{
            metodo();
        } catch (InputMismatchException e) {
            System.out.println("Ha ocurrido un error: "+e.toString());
        }finally {
            System.out.println("Fin");
        }
    }
}
