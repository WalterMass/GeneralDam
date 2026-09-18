/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica02;

import java.io.*;


public class Ejercicio2_1 {
  
    public static void main(String[] args) throws IOException{
        try{
            apartadoA();
            apartadoB();
            apartadoC();
            
        }catch(IOException e){
            System.out.println("");;
        }
    }
    
    public static void apartadoA() throws IOException {
        String ruta = "src/practica0101";
        File file = new File(ruta);
       
        if (!file.exists()){
            file.mkdir();
        }
        
    }
    
    public static void apartadoB() throws IOException{
//   b) Crear un subdirectorio de “practica0101” llamado “subdirectorio0101”.
        String ruta = "src/practica0101/subdirectorio0101";
        File file = new File(ruta);
        if(!file.exists()){
            file.mkdirs();
        }
    }
    
    public static void apartadoC() throws IOException{
      //Crear un subdirectorio de “practica0101” llamado “subdirectorio0102”.
      String ruta = "src/practica0101/subdirectorio0102";
        File file = new File(ruta);
        if(!file.exists()){
            file.mkdirs();
        }
    }
            
}
