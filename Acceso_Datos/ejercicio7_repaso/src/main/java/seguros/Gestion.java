/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguros;

import data.Coche;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author alumno
 */
public class Gestion {
    public static Scanner sc = new Scanner(System.in);
    
    public void exe(){
        List<Coche> coches = new ArrayList();
        coches.add(new Coche("Dacia", "C4", 1, 2014, "Blanco", true, 10000));
        coches.add(new Coche("Mercedes Benz", "Clase B", 2, 2020, "Azul", true, 0));
        coches.add(new Coche("Audi", "A3", 3, 2018, "Rojo", true, 30000));
        coches.add(new Coche("McLaren", "F1" , 4 , 2021, "Amarillo", false, 1400));
        
        coches = coches.stream()
              .sorted(Comparator.comparing(Coche::getMatricula).reversed())
              .collect(Collectors.toList());
        
        menu(coches);
        
    }
    
    public void menu(List<Coche> coches){
        String opcion;
        do {
            opcion = preguntarAccion();
            switch (opcion) {
                case "1":
                    System.out.println("Mostrando Coches y sus caracteristicas");
                    listarCoches(coches);
                    break;
                case "2":
                    System.out.println("Modificando los datos de un coche");
                    break;
                case "3":
                    System.out.println("Eliminar un coche");
                    eliminarCoche(coches);
                    break;
                case "4":
                    System.out.println("Crear coche");
                    crearCoche(coches);
                    break;
                    
                case "5":
                    System.out.println("convertir a csv o xml");
                    String tipoDoc = sc.nextLine();
                    if (tipoDoc.equals("csv")){
                        
                    }else if(tipoDoc.equals("xml")){
                        
                    }
                    
                    break;
                case "salir":
                    System.out.println("Cerrando Menu");
                default: System.out.println("opcion no contemplatada, vuelve a provar.");
            }
            
        } while (!opcion.equalsIgnoreCase("salir"));
        
    }
    
    public String preguntarAccion() {
        String mensaje_menu
                = """
                  MENU
                  1) Listar todos los coches
                  2) Modificar datos de un cocheo
                  3) Eliminar un coche existente
                  4) Crear coche nuevo
                  4) Exportar informacion de coches a csv o xml
                  Teclea {salir} para salir del menu""";        
        System.out.println(mensaje_menu);
        try {
            String opcion = sc.nextLine();
            return opcion.trim();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return "error";
        }
    }
    
    private void volver() {
        System.out.println("\nPresiona Enter para volvear al menu");
        sc.nextLine();    
    }
    
    private Coche getCoche(List<Coche> coches){
        int matricula;
        HashMap<Integer, Coche> mapaCoches = (HashMap<Integer, Coche>) coches.stream()
                .collect(Collectors
                        .toMap(Coche::getMatricula, Coche::getCoche)
                );
        while(true){
            try{
                matricula = Integer.parseInt(sc.nextLine());
                if (mapaCoches.containsKey(matricula)){
                    return mapaCoches.get(matricula);
                }else{
                    throw new NumberFormatException("El coche que intentas seleccionar no existe");
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        } 
    }
    
    public void crearCoche(List<Coche> coches){
        System.out.println("introduz la marca");
        String marca = sc.nextLine();
        System.out.println("introduz el modelo");
        String modelo = sc.nextLine();
        System.out.println("introduz el numero de matricula");
        int matricula = getInt();
        System.out.println("introduz el año de matricula");
        int añoMatriculacion = getInt();
        System.out.println("introduz el color");
        String color = sc.nextLine();
        System.out.println("Esta en el garaje (s)");
        boolean estado = sc.nextLine().equals("s");
        System.out.println("introduz numero de kilometros recoridos");
        double kilometraje  = getDouble();
        
        Coche coche = new Coche(marca, modelo, matricula, añoMatriculacion, color, estado, kilometraje);
        coche.añadirALista(coches);
    }
    
    public void eliminarCoche(List<Coche> coches){
        HashMap<Integer, Coche> mapaCoches = (HashMap<Integer, Coche>) coches.stream()
                .collect(Collectors.toMap(
                        Coche::getMatricula,
                        Coche::getCoche)
                );
        
        int matricula = getInt();
        
        if (mapaCoches.containsKey(matricula) ){
            Coche coche = mapaCoches.get(matricula);
            boolean exito = coches.remove(coche);
            System.out.println( (exito ? "Exito al eliminar el coche" : "resultado inesperado"));
                    
        }else System.out.println("El coche no existe");
        
    }
    
    public void listarCoches(List<Coche> lista){
        System.out.println();
        lista.forEach( (c) -> System.out.println(c) );
        volver();
    }
    
    
    public void modificarDatosDeUnCoche(List<Coche> coches){
        Coche coche = getCoche(coches);
        HashMap<Integer, Coche> mapaCoches = (HashMap<Integer, Coche>) coches.stream()
                .collect(Collectors.toMap(
                        Coche::getMatricula,
                        Coche::getCoche)
                );
        int atributo = -1;
        do {
            switch (atributo) {
                case 1 -> modificarMarca(coche);
                case 2 -> modificarModelo(coche);
                case 3 -> modificarMatricula(coche, mapaCoches);
                case 4 -> modificarAñoMatriculacion(coche);
                case 5 -> modificarColor(coche);
                case 6 -> modificarEstado(coche);
                case 7 -> modificarKilometraje(coche);
                case 0 -> System.out.println("fin de modificacion");
                default -> System.out.println("opcion no contemplada");
            }
            
        }while (atributo != 0);
        
        volver();
    }
    
    public int preguntarAtributo(){
        String mensaje = """
                  introduzca el numero del dato que quiere modificar
                  1) Marca
                  2) Modelo
                  3) Matricula
                  4) Año de matriculacion
                  5) Color
                  6) Si esta en el garaje o no
                  7) Kilometraje
                  0) Terminar
                  """;
        System.out.println(mensaje);
        
        int opcion = Integer.parseInt(sc.nextLine());
        
        return opcion;
        
    }
    
    public int getInt(){
        while (true){
            try {
                String cadena = sc.nextLine();
                if (Integer.parseInt(cadena) <= 0 ){
                    throw new NumberFormatException("El numero no puede ser menor que 1");
                }
                return Integer.parseInt(cadena);
            }catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public double getDouble(){
        while (true){
            try {
                String cadena = sc.nextLine();
                if (Double.parseDouble(cadena) <= 0 ){
                    throw new NumberFormatException("El numero no puede ser menor que 1");
                }
                return Double.parseDouble(cadena);
            }catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void modificarMarca(Coche coche){
        System.out.println("Introduz el nombre de la marca");
        String nombre = sc.nextLine();
        coche.setMarca(nombre);        
        System.out.println(coche);
    }
    
    public void modificarModelo(Coche coche){
        System.out.println("Introduz el nombre del modelo");
        String nombre = sc.nextLine();
        coche.setModelo(nombre);
        System.out.println(coche);
    }

    public void modificarMatricula(Coche coche, HashMap<Integer, Coche> mapaCoches) {
        System.out.println("Introduz el numero de matricula");
        
        int numero = getInt();
        if (!mapaCoches.containsKey(numero)){
            coche.setMatricula(numero);
        }else System.out.println("No se puede duplicar una matricula");
        System.out.println(coche);    
    }
    
    public void modificarAñoMatriculacion(Coche coche){
        System.out.println("Introduz el numero de matricula");
        
        int numero = getInt();
        if (numero > 1820 && numero < 2027 ){
            coche.setMatricula(numero);
        }else System.out.println("Año no valido");
        System.out.println(coche);
    }
    
    public void modificarColor(Coche coche){
        System.out.println("Introduz el nombre del color");
        String nombre = sc.nextLine();
        coche.setColor(nombre);        
        System.out.println(coche);
    }
    
    public void modificarEstado(Coche coche){
        System.out.println("Cambiar estado a en garage(s) o fuera del garage(n)");
        String respuesta = sc.nextLine();
        switch (respuesta.charAt(0)) {
            case 's' -> coche.setDescansaEnGaraje(true);
            case 'n' -> coche.setDescansaEnGaraje(false);
            default -> System.out.println("opcion no valida");
        }
        System.out.println(coche);
    }
    
    public void modificarKilometraje(Coche coche){
        System.out.println("Introduz el numero de kilometros");
        
        double numero = getDouble();
        if (numero >= 0){
            coche.setKilometrajeAnual(numero);
        }else System.out.println("El kilometraje no puede ser negativo");
        System.out.println(coche);
    }
    
    
    
}
