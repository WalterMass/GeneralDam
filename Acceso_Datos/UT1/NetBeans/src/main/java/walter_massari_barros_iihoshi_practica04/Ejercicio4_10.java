/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Ejercicio4_10 {
    
     public static void main(String[] args) {
        String rutaOrg = "src/Files/tdm.txt";
        File fileOrg = new File(rutaOrg);
        
        String rutaDst = "src/Files/tdmMayus.txt";
        File fileDst = new File(rutaDst);
        
        try{
            if (!fileOrg.exists()){
                throw new ExcepcionFicheroOrigenNoEncontrado("No se ha podido encontrar el archivo de origne");
            }
            if (!fileDst.exists()){
                
                fileDst.getParentFile().mkdirs();
                fileDst.createNewFile();
            }
            actividad10(fileOrg, fileDst);
            
        }catch (ExcepcionFicheroOrigenNoEncontrado | IOException e){
            System.out.println(e.getMessage()); 
        }
    }

    private static void actividad10(File fileOrg, File fileDst)throws IOException{
        List<String> lineas  = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileOrg)))){
            while(br.ready()){
                String linea = br.readLine().trim().toUpperCase();
                lineas.add(linea);
            }

        }catch(IOException e){
            throw new IOException("Error al leer el fichero");
        }
        
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDst)))){
            for(String l : lineas){
                bw.write(l);
                bw.newLine();
            }
        }catch(IOException e){
            throw new IOException("Error al escribir en el fichero");
        }
    }
    
}
/*10. Construye una aplicación en Java que procese un archivo de texto plano
mediante filtrado y transformación de sus cadenas de caracteres. El
programa debe leer un archivo de entrada línea por línea, convertir todo
el texto a mayúsculas, eliminar los espacios en blanco iniciales y finales,
y escribir las líneas procesadas en un nuevo archivo de texto formateado.
La lógica de lectura, transformación y escritura se debe implementar
dentro de un método auxiliar que declare expresamente la propagación
de excepciones de entrada/salida hacia el método principal. Para la
escritura, se deben conectar secuencialmente flujos de bytes,
convertidores de caracteres y escrituras con búfer, asegurando el vaciado
de los datos y el cierre ordenado de todas las capas interconectadas*/