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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Ejercicio4_8 {
    public static void main(String[] args) {
        String rutaOrg = "src/Files";
        File fileOrg = new File(rutaOrg);
        
        String rutaDst = "src/Files/contenidoFiles.txt";
        File fileDst = new File(rutaDst);
        
        try{
            if (!fileOrg.exists()){
                fileOrg.mkdirs();
            }
            if (!fileDst.exists()){
                fileDst.createNewFile();
            }
            actividad8(fileDst, fileOrg);
            
        }catch (IOException e){
            
        }
    }
    
    public static void actividad8(File destino, File origen)throws IOException{
        File[] archivos = origen.listFiles();
        try (
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destino, true)))
            ){
            for (int i = 0; i < archivos.length-1; i++ ){
                String linea;
                if (archivos[i] != null){
                    if (archivos[i].isDirectory()){
                        linea = (i+1)+" - "+archivos[i].getName()+" - Directorio";
                    }else {
                        linea = (i+1)+" - "+archivos[i].getName()+" - Fichero";
                    }
                    System.out.println(linea);
                    bw.write(linea);
                    bw.newLine();
                }
                
            }
                bw.write("En el directorio "+origen.getName()+" hay "+archivos.length+" elementos");
                bw.newLine();
        }
    }
    /*crear un archivo de texto formateado donde escriba
    línea a línea cada nombre precedido por un número correlativo y su tipo
    (si es un fichero o un directorio). Al finalizar el listado, se debe incluir una
    línea de cierre que indique la cantidad total de elementos contabilizados.
    Si la carpeta de informe ya contiene un archivo con el mismo nombre, su
    contenido previo debe reemplazarse por completo*/
}
