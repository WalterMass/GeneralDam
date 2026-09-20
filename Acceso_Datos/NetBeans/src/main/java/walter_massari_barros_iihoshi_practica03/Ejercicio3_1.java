/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica03;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author waltermassari
 */
public class Ejercicio3_1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        menu();
    }
    
    public static void menu() throws IOException{
        String opcion;
        do{
            opcion = preguntarAccion();
            switch(opcion){
                case "1": actividad1(new File("src/Files/datos.dat")); break;
                case "2": actividad2();break;
                case "3": ;break;
                case "4": ;break;
            }

        }while(!opcion.equalsIgnoreCase("salir"));
        
    }
    
    public static String preguntarAccion(){
        String mensaje_menu =
                "MENU\n"+
                "1) lee byte a byte el contenido del datos.dat\n"+
                "2) \n"+
                "3) \n"+
                "4) \n"+
                "{salir}"; 
        System.out.println(mensaje_menu);
        String opcion =sc.nextLine();
        try{
            return opcion.trim();
        }catch(Exception e){
            System.out.print(e.getMessage());
            return "error";
        }
    }

    private static void actividad1(File file) throws IOException{
        FileInputStream lector = new FileInputStream(file);
        byte[] lectura = new byte[100];
        int longitud;
        do{
            longitud = lector.read(lectura);
            if (longitud == -1){
                break;
            }else{
                for(int i = 0; i < longitud; i++){
                    System.out.println(lectura[i]+" byte");
                }
            }
            System.out.println("");
        }while(true);
        lector.close();
    }
    
    private static void actividad2() throws IOException{
        String rutaArchivo = "src/Files/ficheroEj/ejemplo.jpg"; 
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }

        // Buffer de 1000 bytes por bloque
        byte[] buffer = new byte[1000];

        try (FileInputStream fis = new FileInputStream(archivo)) {
            int bytesLeidos;
            int numeroBloque = 1;

            // fis.read(buffer) lee HASTA 1000 bytes y devuelve cuántos leyó realmente.
            // Devuelve -1 cuando llega al final del archivo (EOF).
            while ((bytesLeidos = fis.read(buffer)) != -1) {
                System.out.println("Bloque #" + numeroBloque + " | Bytes leídos: " + bytesLeidos);

                // Aquí procesas los datos del buffer
                // Ojo: Solo procesamos desde la posición 0 hasta 'bytesLeidos'
                procesarBloque(buffer, bytesLeidos);

                numeroBloque++;
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    private static void procesarBloque(byte[] buffer, int cantidadBytes) {
        // Ejemplo de procesamiento: imprimir los bytes en hexadecimal o utilizarlos
        // (En el último bloque, 'cantidadBytes' podría ser menor a 1000)
    }
   
}

