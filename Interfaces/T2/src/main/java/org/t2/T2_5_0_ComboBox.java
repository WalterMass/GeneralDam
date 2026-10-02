package org.t2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T2_5_0_ComboBox extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("T2.5.0 ComboBox");
        ComboBox comboBox1 = new ComboBox();
        comboBox1.getItems().addAll("Opc1", "Opc2", "Opc3");
        comboBox1.setPromptText("Elige");

        ComboBox comboBox2 = new ComboBox();
        Label label1 = new Label("ROJO");
        Label label2 = new Label("AMARILLO");
        Label label3 = new Label("AZUL");

        label1.setStyle("-fx-background-color: red; -fx-font-weight: 20;");
        label2.setStyle("-fx-background-color: yellow; -fx-font-family: FreeMono;");
        label3.setStyle("-fx-background-color: blue");

        comboBox2.setPromptText("Andora");
        comboBox2.getItems().addAll(label1, label2, label3);

        HBox hBox = new HBox(comboBox2);
        hBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hBox, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
