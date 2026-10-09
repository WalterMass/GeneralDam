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
public class Vivienda {
    private String direcion;
    private List<Habitante> habitantes;

    public Vivienda(String direcion, List<Habitante> habitantes) {
        this.direcion = direcion;
        this.habitantes = habitantes;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public List<Habitante> getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(List<Habitante> habitantes) {
        this.habitantes = habitantes;
    }
    
    
}
