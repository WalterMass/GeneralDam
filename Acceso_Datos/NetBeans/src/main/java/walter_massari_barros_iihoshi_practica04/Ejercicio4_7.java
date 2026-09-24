/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 *
 * @author alumno
 */
public class Ejercicio4_7 {

    public static void main(String[] args) {
        actividad7();
       
    }
    
    public static void actividad7(){
        File directorioBinario = new File("src/Files/Datos");
        if (!directorioBinario.exists()){
            directorioBinario.mkdirs();
        }
        
        File archivo = new File(directorioBinario, "archivo"); 
        
        try (FileOutputStream fos = new FileOutputStream(archivo, true)) {

            for (int i = 1; i <= 10; i++) {
                int valor = 5 * i;
                fos.write(valor);
            }

            System.out.println("Datos binarios añadidos con éxito en: " + archivo.getName());

        } catch (IOException e) {
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
}

/*7. Construye una aplicación en Java que organice el almacenamiento binario 
de  datos  numéricos  en  el  sistema  de  archivos.  El  programa  debe 
comprobar si existe una carpeta específica destinada a guardar datos; si 
no existe, debe crearla. A continuación, generará un archivo binario dentro 
de dicha carpeta y escribirá en él una secuencia de bytes con los valores 
de la tabla de multiplicar del número 5 (del 5 al 50). En caso de que el 
archivo ya existiera de ejecuciones previas, el programa deberá añadir la 
nueva serie de números al final del fichero existente sin borrar los datos 
anteriores. El tratamiento de las posibles anomalías en la entrada y salida 
de datos debe gestionarse de forma explícita.
*/
