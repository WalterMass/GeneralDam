package org.t2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T2_8_1_MenuBar extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = new BorderPane();

        MenuBar mainBar = new MenuBar();
        borderPane.setTop(mainBar);

        Menu menuFileLv1 = new Menu("File");
        mainBar.getMenus().addAll(menuFileLv1,new Menu("jose"));
        String[] namesLv1 = {"New",
                "Open...",
                "Recent Projects",
                "Close Project",
                "Settings...",
                "Project Structure...",
                "Plugins...",
                "File Properties",
                "Local History",
                "Save All",
                "Reload All from Disk",
                "Repair IDE",
                "Invalidate Caches...",
                "Manage IDE Settings",
                "New Projects Setup",
                "Save File as Template",
                "Export",
                "Print...",
                "Power Save Mode",
                "Exit"};

        int[] excluidosLv1 = {0,2,7,8,13,14,16};


        List<javafx.scene.control.MenuItem> menuItemsLv1 = getElementosList(namesLv1, excluidosLv1);

        for (MenuItem menuItem : menuItemsLv1) {
            menuFileLv1.getItems().add(menuItem);
        }

        Scene scene = new Scene(borderPane);
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

    public static void setImagenesNivel( List<javafx.scene.control.MenuItem> lista,
                                         int[] incluidosImg, String[] rutasImg,
                                         int[] incluidosAtj, String[] atajos){
            for(int i = 0; i < lista.size(); i++){
                if (i == incluidosImg[i]){
                    Image image = new Image(rutasImg[i]);
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(15);
                    imageView.setFitHeight(15);
                    lista.get(i)
                    /*
                    Image image1_4_3 = new Image("file:src/main/resources/img/linux.png");
                    ImageView imageView1_4_3 = new ImageView(image1_4_3);
                    imageView1_4_3.setFitHeight(15);
                    imageView1_4_3.setFitWidth(15);
                    menuItem1_4_3.setGraphic(imageView1_4_3);
                    * */
                }
            }
    }
}

