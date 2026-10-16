/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Ejercicio5_1 {
    public static void main(String[] args) {
        try{
            actividad1();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void actividad1() throws IOException{
        File archivo = new File("src/Files/ficheroEj/Personas.txt");
        File archivoDst = new File("src/Files/practica5/PersonasSerial.dat");
        
        List<Persona> personas = new ArrayList<>();
        if (!archivoDst.exists()) {
            archivoDst.getParentFile().mkdirs();
            archivoDst.createNewFile();
        }
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDst));
                ){
            
            
            while(br.ready()){
                String[] linea = br.readLine().split(";");
                personas.add(new Persona(
                        linea[0],
                        Integer.parseInt(linea[1]),
                        linea[2],
                        linea[3]
                ));
            }
            
            for(Persona p : personas){
                boolean verdad = escribirObjetoSeguro(oos, p);
                System.out.println(p+": "+verdad);
            }
            
            
        }catch(NoSuchFileException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean escribirObjetoSeguro(ObjectOutputStream oos, Object objeto) {
        try {
            oos.writeObject(objeto);
            oos.flush(); // Fuerza a que los datos se vacíen en el flujo
            return true; // Si llega aquí, la escritura fue exitosa
        } catch (IOException e) {
            // Aquí puedes registrar el error si lo necesitas (ej. e.printStackTrace())
            return false; // Si hay una excepción, falló la escritura
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
