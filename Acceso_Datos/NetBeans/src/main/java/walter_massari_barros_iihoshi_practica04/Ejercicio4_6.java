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
import java.io.OutputStreamWriter;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author waltermassari
 */
public class Ejercicio4_6 {
    public static void main(String[] args) {
        try{
            actividad6();
        }catch (Exception e){}
    }

    private static void actividad6() throws IOException,NoSuchFileException{
        Scanner sc = new Scanner(System.in);
        String ruta = "src/Files/ficheroEj/juegos.csv";
        File file = new File(ruta);
        List<Juego> juegos = new ArrayList();
        List<Juego> recomendacion;
        
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            String linea;
            while(br.ready()){
                linea = br.readLine();
                String[] atributos = linea.split(";");
                String nombre = atributos[0];
                int edadMinima = Integer.parseInt(atributos[1]);
                int minJugadores = Integer.parseInt(atributos[2]);
                int maxJugadores = Integer.parseInt(atributos[3]);
                int duracion = Integer.parseInt(atributos[4]);
                juegos.add(new Juego(nombre, edadMinima, minJugadores, maxJugadores, duracion));
            }
            
            System.out.println("edad del jugador más joven:");
            int minEdad = Integer.parseInt(sc.nextLine());
            System.out.println("cantidad de jugadores:");
            int numJugadores = Integer.parseInt(sc.nextLine());
            System.out.println("tiempo disponible en minutos");
            int duracionPartida = Integer.parseInt(sc.nextLine());
            
            recomendacion = juegos.stream().filter(j -> 
                    j.getEdadMinima() <= minEdad &&
                    j.getDuracion() <= duracionPartida &&
                    j.getMaxJugadores() >= numJugadores
                    ).collect(Collectors.toList());
            
            System.out.println("\nEstas son las opciones disponibles con esos criterios:");
            recomendacion.forEach(p -> System.out.println(p));
            
            System.out.println("Deseas guardar la recomendacion(s)?");
            boolean guardar = sc.nextLine().equalsIgnoreCase("s");
            
            if (guardar){
                File dstFile = new File("src/Files/juegosRecomendados.csv");
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dstFile)))){
                    if (!dstFile.exists()){
                        dstFile.createNewFile();
                    }
                        for(Juego j : recomendacion){
                            bw.write(j.toString());
                            bw.newLine();
                        }
                }
            }
            
            
            
            
        }catch(NumberFormatException e){
            
        }
    }
}
/*6. Crea un programa que nos recomendará juegos de mesa en función de
las necesidades de nuestro grupo de jugadores.
En primer lugar, el programa leerá el fichero “juegos.csv”, que almacena
en cada línea las características de un juego, correspondiente con la
siguiente estructura:
Nombre;EdadMínima;MinJugadores;MaxJugadores;Duración

Después nos pedirá la edad de nuestro jugador más jóven, cuántos
jugadores somos y cuánto tiempo tenemos para jugar.
En función de esos datos, nos devolverá por pantalla los nombres de los
juegos del listado original a los que podríamos jugar.
Finalmente nos preguntará si queremos guardar la recomendación en un
fichero, si decimos que sí, se guardará en un fichero
“juegosRecomendados.csv” donde cada fila contendrá los datos de un
juego, de forma similar al fichero “juegos.csv”.*/