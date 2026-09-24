package walter_massari_barros_iihoshi_practica04;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author waltermassari
 */
public class Juego {
    private String nombre;
    private int edadMinima;
    private int minJugadores;
    private int maxJugadores;
    private int duracion;

    public Juego(String nombre, int edadmMinima, int minJugadores, int maxJugadores, int duracion) {
        this.nombre = nombre;
        this.edadMinima = edadmMinima;
        this.minJugadores = minJugadores;
        this.maxJugadores = maxJugadores;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadmMinima) {
        this.edadMinima = edadmMinima;
    }

    public int getMinJugadores() {
        return minJugadores;
    }

    public void setMinJugadores(int minJugadores) {
        this.minJugadores = minJugadores;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public void setMaxJugadores(int maxJugadores) {
        this.maxJugadores = maxJugadores;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return nombre + "; " + edadMinima + "; " + minJugadores + "; " + maxJugadores + "; " + duracion;
    }

    
    
    
}

//Nombre;EdadMínima;MinJugadores;MaxJugadores;Duración
