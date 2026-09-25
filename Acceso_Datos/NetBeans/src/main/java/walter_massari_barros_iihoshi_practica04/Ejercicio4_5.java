package walter_massari_barros_iihoshi_practica04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author waltermassari
 */
public class Ejercicio4_5 {
    public static void main(String[] args) {
        try{
            actividad5();
        }catch (Exception e){}
    }
    
    public static void actividad5() throws IOException,NoSuchFileException{
        Scanner sc = new Scanner(System.in);
        
        System.out.println("escribe la ruta del fichero que quieres copiar");
        String origen = sc.nextLine();
        
        System.out.println("escribe la ruta del fichero que quieres copiar");
        String destino = sc.nextLine();
        
        File org = new File(origen);
        File dst = new File(destino);
        
        if (!org.exists()){
            return;
        }
                
        try (FileInputStream fis = new FileInputStream(org);
             FileOutputStream fos = new FileOutputStream(dst)) {

            byte[] buffer  = new byte[8192];
            int leidos;
            while ((leidos = fis.read(buffer)) != -1){
                fos.write(buffer, 0, leidos);
            }
            
            
            
        }
        

    }
}
/*5. Crea un programa que haga copias de cualquier tipo de fichero. El usuario
nos proporcionará por consola la ruta del fichero de origen y la ruta del
fichero destino.*/
