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
            file.mkdir();
        }
    }
    
    public static void apartadoC() throws IOException{
      //Crear un subdirectorio de “practica0101” llamado “subdirectorio0102”.
      String ruta = "src/practica0101/subdirectorio0102";
        File file = new File(ruta);
        if(!file.exists()){
            file.mkdir();
        }
    
    }
    
    public static void apartadoD() throws IOException{
    // d) Crear la siguiente estructura de directorios “practica0201/subdirectorio0201”.
        String ruta = "src/practica0101/subdirectorio0102";
        File file = new File(ruta);
        if(!file.exists()){
            file.mkdirs();
        }
    }
    
    
    
    /*
        e) Crear un fichero en el directorio “practica0101” llamado “fichero01”.
        f) Crear un fichero en el directorio “subdirectorio0101” llamado “fichero02”.
        g) Crear un fichero en el directorio “subdirectorio0102” llamado “fichero03”.
        h) Mover el fichero “fichero02” al directorio “practica0101”.
        i) Mover el fichero “fichero03” al directorio “practica0101” pero renómbralo a
        “fichero04”.
        j) Mostrar por pantalla el contenido del directorio “practica0101”.
        k) Mostrar por pantalla los nombres solo de los ficheros del directorio
        “practica0101”.
        l) Renombrar todos los ficheros que haya en el directorio “practica0101”
        añadiendo a su nombre “ren”.
        m) Eliminar todos los subdirectorios del directorio “practica0101
    */
            
}
