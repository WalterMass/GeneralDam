/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walter_massari_barros_iihoshi_practica05;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class Alimento implements Serializable{
    private String id;
    private int energiaAportar100g;
    private int hidratosCarbono100g;
    private int azucares100g;
    private int grasasSaturadas100g;
    private int grasasInsaturadas100g;
    private int proteinas100g;

    public Alimento(String id, int energiaAportar100g, int hidratosCarbono100g, int azucares100g, int grasasSaturadas100g, int grasasInsaturadas100g, int proteinas100g) {
        this.id = id;
        this.energiaAportar100g = energiaAportar100g;
        this.hidratosCarbono100g = hidratosCarbono100g;
        this.azucares100g = azucares100g;
        this.grasasSaturadas100g = grasasSaturadas100g;
        this.grasasInsaturadas100g = grasasInsaturadas100g;
        this.proteinas100g = proteinas100g;
    }

    public Alimento() {
    }

    @Override
    public String toString() {
        return "Alimento{" + "id=" + id + ", energiaAportar100g=" + energiaAportar100g + ", hidratosCarbono100g=" + hidratosCarbono100g + ", azucares100g=" + azucares100g + ", grasasSaturadas100g=" + grasasSaturadas100g + ", grasasInsaturadas100g=" + grasasInsaturadas100g + ", proteinas100g=" + proteinas100g + '}';
    }
    
    
    
    
    public static int comprobarAlimento(Alimento alimento){
        int suma = 
        alimento.hidratosCarbono100g +
        alimento.grasasSaturadas100g +
        alimento.grasasInsaturadas100g +
        alimento.proteinas100g;
        return suma;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEnergiaAportar100g() {
        return energiaAportar100g;
    }

    public void setEnergiaAportar100g(int energiaAportar100g) {
        this.energiaAportar100g = energiaAportar100g;
    }

    public int getHidratosCarbono100g() {
        return hidratosCarbono100g;
    }

    public void setHidratosCarbono100g(int hidratosCarbono100g) {
        this.hidratosCarbono100g = hidratosCarbono100g;
    }

    public int getAzucares100g() {
        return azucares100g;
    }

    public void setAzucares100g(int azucares100g) {
        this.azucares100g = azucares100g;
    }

    public int getGrasasSaturadas100g() {
        return grasasSaturadas100g;
    }

    public void setGrasasSaturadas100g(int grasasSaturadas100g) {
        this.grasasSaturadas100g = grasasSaturadas100g;
    }

    public int getGrasasInsaturadas100g() {
        return grasasInsaturadas100g;
    }

    public void setGrasasInsaturadas100g(int grasasInsaturadas100g) {
        this.grasasInsaturadas100g = grasasInsaturadas100g;
    }

    public int getProteinas100g() {
        return proteinas100g;
    }

    public void setProteinas100g(int proteinas100g) {
        this.proteinas100g = proteinas100g;
    }
    
    
}
