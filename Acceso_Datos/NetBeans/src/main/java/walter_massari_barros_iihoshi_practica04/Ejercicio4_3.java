/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Ejercicio4_3 {
    public static void main(String[] args) {
        try{
           actividad3();
         
        }catch(Exception e){
        }
    }
    
    public static void actividad3()throws IOException, FileNotFoundException{
        String rutaOrg = "src/Files/numeros.txt";
        File fileOrg = new File(rutaOrg);
        
        String rutaDst = "src/Files/pares.txt";
        File fileDst = new File(rutaDst);
        if (fileOrg.exists()){
            if (!fileDst.exists()) fileDst.createNewFile();
            
            try(
                    FileInputStream fis = new FileInputStream(fileOrg);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    
                    FileOutputStream fos  = new FileOutputStream(fileDst, true);
                    OutputStreamWriter osw = new OutputStreamWriter( fos);
                    BufferedWriter bw = new BufferedWriter(osw);
                ){
                
                List<Integer> nums = new ArrayList<>();
                while(br.ready()){
                    String linea = br.readLine();
                    try{
                       int num = Integer.parseInt(linea);
                       if ((num%2) == 0){
                           boolean b = nums.add(num);
                           System.out.println(b);
                       }
                    }catch(NumberFormatException e){}
                }
                for(Integer n : nums){
                    bw.write(n+", ");
                }
               
                
            }catch(IOException e){}
            
        }else return;
                
    }
}
