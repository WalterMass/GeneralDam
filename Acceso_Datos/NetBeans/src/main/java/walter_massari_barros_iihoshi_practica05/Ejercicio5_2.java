/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica05;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
//public class Ejercicio5_2 {
//    public static void main(String[] args) {
//        try{
//            actividad2();
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//    
//    public static void actividad2()throws Exception{
//        File org = new File("src/Files/ficheroEj/datos.dat");
//        List<Persona> personas = new ArrayList<>();
//
//        FileInputStream fis = new FileInputStream(org);
//        try(ObjectInputStream ois = new ObjectInputStream(fis)) {
//            
//            while(fis.available() != 0){
//                try{
//                    Persona persona =(Persona) ois.readObject();
//                    System.out.println("Exito al des-serializar: "+personas.add(persona));
//                }catch(ClassNotFoundException ex){
//                    System.getLogger(Ejercicio5_2.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
//                }
//                
//            }
//            
//            fis.close();
//
//        }catch(IOException e){
//            System.out.println(e.getMessage());
//        }
//        
//        personas.forEach(p -> System.out.println(p));
//    }
//}

public class Ejercicio5_2 {
    public static void main(String[] args) {
        try {
            actividad2();
        } catch (Exception e) {
            System.out.println("Error principal: " + e.getMessage());
        }
    }

    public static void actividad2() throws Exception {
        File org = new File("src/Files/practica5/PersonasSerial.dat");
        List<Persona> personas = new ArrayList<>();

        // El try-with-resources gestiona el cierre automático de streams
        try (ObjectInput
                Stream ois = new ObjectInputStream(new FileInputStream(org))) {
            
            while (true) {
                try {
                    Persona persona = (Persona) ois.readObject();
                    personas.add(persona);
                } catch (EOFException e) {
                    // Se ha alcanzado el final del archivo correctamente
                    break; 
                } catch (ClassNotFoundException ex) {
                    System.err.println("Clase Persona no encontrada: " + ex.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }

        // Mostrar el contenido de la lista
        if (personas.isEmpty()) {
            System.out.println("No se encontraron personas en el fichero o el archivo está vacío.");
        } else {
            personas.forEach(p -> System.out.println(p));
        }
    }
    
    
}

/*
2. Crea un programa que cargue el contenido del fichero PersonasSerial.dat
en una lista de Personas y escriba por pantalla toda la información de
cada una de las personas recuperadas.
*/