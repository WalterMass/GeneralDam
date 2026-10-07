package org.t2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class T2_8_0_MenuBar extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("menu1");
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        menuBar.getMenus().addAll(menu1, menu2, menu3);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        BorderPane.setAlignment(menuBar, Pos.TOP_CENTER);

        MenuItem menuItem1 = new MenuItem("menu1.1");
        MenuItem menuItem2 = new MenuItem("menu1.2");
        MenuItem menuItem3 = new MenuItem("menu1.3");

        Menu menu1_4 = new Menu("menu1.4");
        menu1.getItems().addAll(menuItem1,menuItem2,menuItem3,menu1_4);

        MenuItem menuItem1_4_1 = new MenuItem("menu1.4.1");
        MenuItem menuItem1_4_2 = new MenuItem("menu1.4.2");
        MenuItem menuItem1_4_3 = new MenuItem("menu1.4.3");

        menu1_4.getItems().addAll(menuItem1_4_1, menuItem1_4_2, menuItem1_4_3);

        menuItem1_4_2.setAccelerator(KeyCombination.keyCombination("Ctrl+k"));

        Image image1_4_3 = new Image("file:src/main/resources/img/linux.png");
        ImageView imageView1_4_3 = new ImageView(image1_4_3);
        imageView1_4_3.setFitHeight(15);
        imageView1_4_3.setFitWidth(15);
        menuItem1_4_3.setGraphic(imageView1_4_3);

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        menu1.getItems().add(2, separatorMenuItem);

        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("T2.8.0 MenuBar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
