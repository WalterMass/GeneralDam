package org.t2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T2_8_1_MenuBar extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = new BorderPane();

        MenuBar mainMenu = new MenuBar();

        Menu menuFileLv1 = new Menu("File");

        String[] namesLv1 = {};//todo
        int[] excluidosLv1 = {0,2,7,8,13,14,16};


        List<javafx.scene.control.MenuItem> menuItemsLv1 = getElementosList(namesLv1, excluidosLv1);


        for(int i = 0; i < namesLv1.length; i++){

        }


        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("T2.8.1 MenuBar");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    /*
        Esta funcion permite crear una lista enterrar de objetos tipo Menu y MenuItem basada excluyendo unicamente a las
        posiciones que se selecionen como false en el array "exlusivos"
        -El parametro "namesLv" lleva los nombres y el tamaño de la lista.
        -El parametro "exclusivos" determina que posiciones de la lista no son elementos tipo MenuItem mediante variables booleanas.
    * */
    public static List<javafx.scene.control.MenuItem> getElementosList(String[] namesLv, int[] excluidos){

        boolean[] boolMenuItems = new boolean[namesLv.length];

        // este array booleano es para determinar si el objeto que voy a crear es o no un Menu Item, manualmente excluyo los objetos tipo Menu
        Arrays.fill(boolMenuItems, true);
        for(Integer i:excluidos){
            boolMenuItems[i] = false;
        }

        List<javafx.scene.control.MenuItem> lista = new ArrayList<>();
        for(int i = 0; i < namesLv.length; i++){
            String name = namesLv[i];
            if (boolMenuItems[i]){
                lista.add(new javafx.scene.control.MenuItem(name));
            }else{
                lista.add(new javafx.scene.control.Menu(name));
            }
        }

        return lista;
    }
}
//class MenuData{
//
//    private MenuItem menuItem;
//    private String name;
//
//    public MenuData(MenuItem menuItem, String name) {
//        this.menuItem = menuItem;
//        this.name = name;
//    }
//
//    public boolean isMenuItem(){
//        return (menuItem instanceof Menu);
//    }
//
//    public MenuItem getMenuItem() {
//        return menuItem;
//    }
//
//    public void setMenuItem(MenuItem menuItem) {
//        this.menuItem = menuItem;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
