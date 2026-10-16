/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica02;

import java.io.*;


public class Ejercicio2_1 {
  
    public static void main(String[] args) throws IOException{
        System.out.println("ejercicio 2.1");
        try{
                apartadoM();
        }catch(IOException e){
            System.out.println("");
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
    
    public static void apartadoE() throws IOException{
//  e) Crear un fichero en el directorio “practica0101” llamado “fichero01”.
        String rutaPadre = "src/practica0101";
        File dirPadre = new File(rutaPadre);
        String ruta = "src/practica0101/fichero01.txt";
        File file = new File(ruta);
        if(!dirPadre.exists()){
            dirPadre.mkdir();
        }
        file.createNewFile();
    }
    
    public static void apartadoF() throws IOException{
//  f) Crear un fichero en el directorio “subdirectorio0101” llamado “fichero02”.
        String rutaEstructura = "src/practica0101/subdirectorio0101";
        String rutaFich = "src/practica0101/subdirectorio0101/fichero2";
        File estructura = new File(rutaEstructura);
        if (!estructura.exists()){
            estructura.mkdirs();
        }
        File file = new File(rutaFich);
        file.createNewFile();
    }
    
    public static void apartadoG() throws IOException {
    //g) Crear un fichero en el directorio “subdirectorio0102” llamado “fichero03”. 
        String rutaEstructura = "src/practica0101/subdirectorio0102";
        String rutaFich = "src/practica0101/subdirectorio0101/fichero3";
        File estructura = new File(rutaEstructura);
        if (!estructura.exists()){
            estructura.mkdirs();
        }
        File file = new File(rutaFich);
        file.createNewFile();
    }
    
    public static void apartadoH() throws IOException{
    //h) Mover el fichero “fichero02” al directorio “practica0101”.
        String rutaOrg = "src/practica0101/subdirectorio0101/fichero2";
        String rutaDst = "src/practica0101/fichero2";
        File file = new File(rutaOrg);
        if (!file.exists()){
            apartadoF();
        }
        
        File dst = new File(rutaDst);
        file.renameTo(dst);
        
        System.out.printf(file+" \n"+dst);
    }
    
    public static void apartadoI() throws IOException {
//        i) Mover el fichero “fichero03” al directorio “practica0101” pero renómbralo a
//        “fichero04”.
        String rutaOrg = "src/practica0101/subdirectorio0101/fichero3";
        String rutaDst = "src/practica0101/fichero4";
        File file = new File(rutaOrg);
        if (!file.exists()){
            apartadoG();
        }
        
        File dst = new File(rutaDst);
        file.renameTo(dst);
        
        System.out.printf(file+" \n"+dst);
    }
    
    public static void apartadoJ() throws IOException{
//  j) Mostrar por pantalla el contenido del directorio “practica0101”.
        File dir = new File("src/practica0101");
        if(!dir.exists()){
            apartadoI();
        }
        File[] dirs = dir.listFiles();
        System.out.println(dir.getName());
        for(File d : dirs){
            System.out.println("\t"+d.getName());
            if (d.isDirectory()){
                File[] dirSub1 = d.listFiles();
                for(File dd : dirSub1){
                    System.out.println("\t\t"+dd.getName());
                }
            }
        }
    }
    
    
    public static void apartadoK() throws IOException{
    //  k) Mostrar por pantalla los nombres solo de los ficheros del directorio “practica0101”.
        File dir = new File("src/practica0101");
        if(!dir.exists()){
            apartadoI();
        }
        File[] dirs = dir.listFiles();
        System.out.println(dir.getName());
        for(File d : dirs){
            if (d.isFile()) {System.out.println("\t"+d.getName());}        
        }
    }
    
    public static void apartadoL() throws IOException{
    //Renombrar todos los ficheros que haya en el directorio “practica0101”añadiendo a su nombre “ren”.
        File dir = new File("src/practica0101");
        if(!dir.exists()){
            apartadoI();
        }
        File[] dirs = dir.listFiles();
        System.out.println(dir.getName());
        for(File d : dirs){
            if (d.isFile()) {
                String nombre = d.getName()+"ren";
                String ruta = "src/practica0101/"+nombre;
                File fichero = new File(ruta);
                d.renameTo(fichero);
                System.out.println("\t"+ruta);
            }        
        }

    }
    
    public static void apartadoM() throws IOException{
    //m) Eliminar todos los subdirectorios del directorio “practica0101
        File dir = new File("src/practica0101");
        if(!dir.exists()){
            apartadoI();
        }
        File[] dirs = dir.listFiles();
        
        for (File d:dirs){
            if (d.isDirectory()){
                System.out.println(d.getName()+" borrado?: " + d.delete());
            }
        }
    }
    
}
    /*
        
        
        
        
    */

