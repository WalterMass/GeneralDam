package data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alumno
 */
public class Coche {
    private String marca;
    private String modelo;
    private int matricula;
    private int añoMatriculacion;
    private String color;
    private boolean descansaEnGaraje;
    private double kilometrajeAnual;

    public Coche(String marca, String modelo, int matricula ,int añoMatriculacion, String color, boolean descansaEnGaraje, double kilometrajeAnual) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.añoMatriculacion = añoMatriculacion;
        this.color = color;
        this.descansaEnGaraje = descansaEnGaraje;
        this.kilometrajeAnual = kilometrajeAnual;
    }
    
    public void añadirALista(List<Coche> lista){
      boolean existo = lista.add(this);
      lista = lista.stream()
              .sorted(Comparator.comparing(Coche::getMatricula).reversed())
              .collect(Collectors.toList());
        System.out.println(existo);
    }
    
    public Coche getCoche(){
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelos() {
        return modelo;
    }

    public void setModelos(String modelos) {
        this.modelo = modelos;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    

    public int getAñoMatriculacion() {
        return añoMatriculacion;
    }

    public void setAñoMatriculacion(int añoMatriculacion) {
        this.añoMatriculacion = añoMatriculacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDescansaEnGaraje() {
        return descansaEnGaraje;
    }

    public void setDescansaEnGaraje(boolean descansaEnGaraje) {
        this.descansaEnGaraje = descansaEnGaraje;
    }

    public double getKilometrajeAnual() {
        return kilometrajeAnual;
    }

    public void setKilometrajeAnual(double kilometrajeAnual) {
        this.kilometrajeAnual = kilometrajeAnual;
    }

    @Override
    public String toString() {
        return marca + "; " + modelo + "; " + matricula + "; " + añoMatriculacion + "; " + color + "; " + descansaEnGaraje + "; " + kilometrajeAnual;
    }

   
    
    
    
}
