/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguros;

import java.io.IOException;

/**
 *
 * @author alumno
 */
public class Gestion {
    public static void menu() throws IOException {
        String opcion;
        do {
            opcion = preguntarAccion();
            switch (opcion) {
                case "1":
                    System.out.println("opcion");
                    break;
                case "2":
                    System.out.println("opcion");
                    break;
                case "3":
                    System.out.println("opcion");
                    break;
                case "4":
                    System.out.println("opcion");
                    break;
            }
            
        } while (!opcion.equalsIgnoreCase("salir"));
        
    }
    
    public static String preguntarAccion() {
        String mensaje_menu
                = "MENU\n"
                + "1) \n"
                + "2) \n"
                + "3) \n"
                + "4) \n"
                + "teclea: {salir} para salir del menu";        
        System.out.println(mensaje_menu);
        String opcion = sc.nextLine();
        try {
            return opcion.trim();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return "error";
        }
}
