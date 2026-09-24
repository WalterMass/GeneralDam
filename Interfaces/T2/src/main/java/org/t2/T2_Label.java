package org.t2;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class T2_Label extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox =new VBox();
        Label label1 = new Label("Etiqueta_Simple");
        Label label2 = new Label("Etiqueta_de_color");
        vBox.getChildren().addAll(label1, label2);
    }
}
