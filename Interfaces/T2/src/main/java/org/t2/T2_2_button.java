package org.t2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class T2_2_button extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button button1 = new Button("Bóton normal");

        Button button2 = new Button("Botón deshabilitado");
        button2.setDisable(true);

        Button button3 = new Button("Botón con texto muy largo replegable");
        button3.setWrapText(true);

        Button button4 = new Button("Botón con imagen");
        Image image = new Image("file:src/main/resources/img/linux.png");
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        button4.setGraphic(imageView);

        VBox vBox = new VBox(10, button1,button2, button3, button4);

        Scene scene = new Scene(vBox, 500, 400);
        stage.setScene(scene);
        stage.setTitle("T2.2 button");
        stage.show();
    }
}
