package com.example.t3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3_4_setOnAction_CheckBox extends Application {
    String mensaje = "Ud ha selecionado: ";

    @Override
    public void start(Stage primaryStage) throws Exception {

        CheckBox checkBox1 = new CheckBox("opcion 1");
        CheckBox checkBox2 = new CheckBox("opcion 2");
        CheckBox checkBox3 = new CheckBox("opcion 3");

        Label label = new Label(mensaje);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(checkBox1, checkBox2, checkBox3, label);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5d);

        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setTitle("T3.4setOnAction_CheckBox");
        primaryStage.setScene(scene);
        primaryStage.show();

        //todo set on action

    }
}
