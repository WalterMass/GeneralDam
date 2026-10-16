/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica06;

import java.util.List;

/**
 *
 * @author waltermassari
 */
public class Pueblo {
    private String nombre;
    private int extension;
    private List<Vivienda> viviendas;

    public Pueblo(String nombre, int extension, List<Vivienda> viviendas) {
        this.nombre = nombre;
        this.extension = extension;
        this.viviendas = viviendas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public List<Vivienda> getViviendas() {
        return viviendas;
    }

    public void setViviendas(List<Vivienda> viviendas) {
        this.viviendas = viviendas;
    }
    
    
    
}
