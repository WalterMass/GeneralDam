/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package walter_massari_barros_iihoshi_practica01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Walter Massari Barros Iihoshi
 */
public class Ejercicio1 {
    
    
//Escribe un programa en java que reciba 4 números enteros por teclado, y
//si alguno de ellos es de un tipo que no sea entero, captura una excepción
//de tipo InputMismatchException java.util.InputMismatchException),
// (hay que importar imprime su clase traza(excepcion.printStackTrace())
// y termina el metodo,si no hay excepción, imprime la suma de los números.
    static void pedirNumerosSuma(){
        Scanner sc = new Scanner(System.in);

        try{
            int acumulador = 0;

            for (int i = 0; i < 4; i++){
                System.out.println("Escribe un numero: "+(i+1)+"º" );
                int num = sc.nextInt();
                acumulador = (acumulador + num);
            }
            System.out.print(" la suma es igual a "+acumulador);

        } catch (InputMismatchException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Has introducido un valor que no era un número enterro");
        }
    }
    static void main(String[] args) {
        pedirNumerosSuma();
    }
    
}
