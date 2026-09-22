/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejericicio4_2 {
    public static void main(String[] args) {
        try {
            actividad2();
        }catch(FileNotFoundException e)
        {
        }catch(IOException o)
        {
        }
    }
    
    public static void actividad2()throws FileNotFoundException, IOException{
        Scanner sc = new Scanner(System.in);
        
        String ruta = "src/Files/extension.txt";
        File file = new File(ruta);
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        while (true){
            System.out.println("Introduce un texto");
            String linea = sc.nextLine();
            if (linea.isEmpty() || linea.isBlank()){
                bw.close();
                osw.close();
                fos.close();
                break;
            }else{
                bw.write(linea);
                bw.newLine();
            }
        }
        
    }
}
