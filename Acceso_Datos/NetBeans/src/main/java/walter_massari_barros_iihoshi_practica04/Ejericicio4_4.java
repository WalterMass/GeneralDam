/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author waltermassari
 */
public class Ejericicio4_4 {
    public static void main(String[] args) {
        try{
            actividad4();
        }catch (Exception e){}
    }

    private static void actividad4() throws IOException, NoSuchFileException{    
       String[] titulos = {"Darksouls", "Sekiro", "BloodBorne"};
       int[] años = {2008,2018,2015};
       String autor = "Hidetaka Miyazaki";
       String[] isbn = {"01b","02a","03c",};
       
       List<Libro> libros = new ArrayList();
       for(int i = 0; i < 3; i++){
           libros.add(new Libro(titulos[i], autor, años[i], isbn[i]));
       }
       File file = new File("src/Files/libros.csv"); 
       
       if (!file.exists()){
          file.createNewFile();
       }
       try(
               BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));){
           
            for(Libro l:libros){
                bw.write(l.toString());
                bw.newLine();
            }
           
       }catch (IOException e){
       }
    }
    
}

/*4. Crea un programa que guarde la información de una lista de objetos de la
clase Libro en un fichero llamado “libros.csv”. La clase Libro incluirá los
siguientes atributos:
a. Título
b. Autor
c. Año publicación
d. ISBN
La información de cada libro se almacenará en una línea distinta del
fichero. Y el formato de la línea será el siguiente:
Titulo;Autor;Año publicación;ISBN*/