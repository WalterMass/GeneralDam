/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.NoSuchFileException;

/**
 *
 * @author alumno
 */
public class Ejercicio5_1 {
    public static void main(String[] args) {
        try{
            actividad1();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void actividad1() throws IOException{
        File archivo = new File("src/Files/ficheroEj/Personas.txt");
        FileOutputStream fos = new FileOutputStream(archivo);
        
        File archivoDst = new File("src/Files/practica5/PersonasSerial.dad");
        FileInputStream fis = new FileInputStream(archivoDst);
        
        try(
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            
            if (!archivoDst.exists()) {
                archivo.getParentFile().mkdirs();
                archivo.createNewFile();
            }
            
            
            
        }catch(NoSuchFileException e){
            System.out.println(e.getMessage());
        }
    }
}

/*
1. Crea un programa que lea el fichero Personas.txt, y guarde su contenido
en una lista de objetos Persona (clase de la Práctica 03). Después
almacenará la información de la lista en un fichero serializado llamado
PersonasSerial.dat. Debe introducirse las personas de una en una, no
toda la lista como un único objeto.
*/
