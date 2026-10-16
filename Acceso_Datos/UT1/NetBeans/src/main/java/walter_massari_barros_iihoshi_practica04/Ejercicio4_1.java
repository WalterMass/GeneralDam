/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author alumno
 */
public class Ejercicio4_1 {
    
    public static void main(String[] args) {
        try {
            actividad1();
        }catch(FileNotFoundException e){
        }catch(IOException o){
        }
    }
    public static void actividad1() throws FileNotFoundException, IOException{
        String ruta = "src/Files/fibonnaci.txt";
        File fibo = new File(ruta);
        FileOutputStream fos = new FileOutputStream(ruta);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        
        if (!fibo.exists()){
            fibo.createNewFile();
        }
        
        int[] secuencia = new int[10];
        secuencia[0] = 0;
        secuencia[1] = 1;
        secuencia[2] = 1;
        for (int i = 2; i < 10; i++){
            secuencia[i] = secuencia[i-2] + secuencia[i-1];
        }
        
        for(int i : secuencia){
            String digito = i+" ";
            bw.write(digito);
            System.out.print(digito);
        }
        
        bw.close();
        osw.close();
        fos.close();
    }
    /*
    2. Crea un programa que pida al usuario que escriba pequeños textos por
    pantalla. Cada vez que pulse intro se volverá a pedir otro texto, a no ser
    que no haya escrito nada más, en cuyo caso dejará de pedir que el usuario
    escriba. El programa escribirá cada texto que el usuario ha escrito en una
    línea de un fichero con extensión .txt.
    */
    
}
/*
public class Ejercicio4_ {
    public static void main(String[] args) {
        try{
            
        }catch(Exception e){
        }
    }
    
    public static void actividad(){
        
    }
}
*/