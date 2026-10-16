/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author waltermassari
 */
public class Ejercicio2_2 {
    static Scanner sc = new Scanner(System.in);
    /*
        2. Crea un programa que, mediante un menú por consola, permita al usuario
        realizar una serie acciones partiendo de la ruta de inicio del programa. Estas
        acciones son: 
            1 crear un directorio (o una estructura de directorios) 
            2 crear un fichero, eliminar un directorio 
            3 eliminar un fichero 
            4 listar el contenido de un directorio
            5 eliminar todos los ficheros de un directorio.
        Cuando se realice una de las acciones seleccionadas en el menú, se informará
        al usuario y volverá a aparecer el menú para que pueda realizar otra acción. En
        el menú habrá una opción mediante la cual se podrá salir del programa.        
    */
    public static void main(String[] args) {
        try {
            menu();
        }catch(IOException e){
            System.out.println("Algo anda mal");
        }
    }
    
    public static void menu() throws IOException{
        String opcion;
        do{
            opcion = preguntarAccion();
            switch(opcion){
                case "1": a1(sc.nextLine()); break;
                case "2": a2();break;
                case "3": a3(sc.nextLine());break;
                case "4": a4(sc.nextLine());break;
            }

        }while(!opcion.equalsIgnoreCase("salir"));
        
    }
    
    public static String preguntarAccion(){
        String mensaje_menu =
                "MENU\n"+
                "1) crear un directorio o una estructura de directorios\n"+
                "2) crear un fichero o eliminar un directorio\n"+
                "3) listar el contenido de un directorio/fichero\n"+
                "4) eliminar todos los ficheros de un directorio\n"+
                "{salir}"; 
        System.out.println(mensaje_menu);
        String opcion =sc.nextLine();
        try{
            return opcion.trim();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "error";
        }
    }
    
    public static void a4(String ruta){
        File file = new File(ruta);
        if (file.exists()){
            File[] dirs = file.listFiles();
        
        for (File d:dirs){
            if (d.isFile()){
                System.out.println(d.getName()+" borrado?: " + d.delete());
            }
        }
        }else System.out.println("El directorio no existe");
    }
    
    public static void a3(String ruta) throws IOException{
        File dir = new File(ruta);
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
    
    public static void a2() throws IOException{
        System.out.println("teclea C para crear y E para eliminar");
        String opcion_a2 = sc.nextLine().toUpperCase().trim();
        System.out.println("teclea la ruta");
        String ruta = sc.nextLine();
        File file = new File(ruta);
        switch (opcion_a2){
            case "C":
                if (!file.exists()){
                    System.out.println("creado?: "+file.createNewFile());
                }else System.out.println("El fichero ya existe");
                
                break;
            
            case "E":
                if (file.exists()){
                    System.out.println("borrado?: "+file.delete());
                }else System.out.println("El documento no existe");
                
                break;
                
        }
        
    }
    
    public static void a1(String ruta) throws IOException{
        File estructura = new File(ruta);
        if (!estructura.exists()){
            estructura.mkdirs();
            
        }
        
    }
    
}
