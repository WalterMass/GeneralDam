package walter_massari_barros_iihoshi_practica01;

import java.util.Random;

public class Ejercicio3 {
    /*
    3. Haz un metodo que genera un número entero aleatorio entre 0 y 999. En
    el caso de que el número generado sea par, lanza una excepción con el
    mensaje de “Es un número par”, y en caso contrario, lanza una excepción
    con el texto “Es un número impar”.*/
    static int generarNumero(){
        Random r = new Random();
        return r.nextInt(0, 1000);
    }
    static void main(String[] args) throws Exception {
        int numero = generarNumero();
        if (numero % 2 == 0){
            throw new Exception("Es un número par");
        }else{
            throw new Exception("Es un número impar");
        }
    }
}
