package com.example.t1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class T2_Label extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox =new VBox();
        Label label1 = new Label("Etiqueta_Simple");
        Label label2 = new Label("Etiqueta_de_color");
        Image image = new Image("file:linux.png");
        ImageView imageView = new ImageView(image);
        Label label3 = new Label();
        label3.setGraphic(imageView);
        vBox.getChildren().addAll(label1, label2, label3);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
