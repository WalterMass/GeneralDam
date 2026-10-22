package com.example.t3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EjemploAchorPane extends Application {

    @Override
    public void start(Stage stage) {

        AnchorPane root = new AnchorPane();

        Label label = new Label("Nombre:");
        TextField textField = new TextField();
        Button button = new Button("Aceptar");

        // Posicionar el Label
        AnchorPane.setTopAnchor(label, 20.0);
        AnchorPane.setLeftAnchor(label, 20.0);

        // Posicionar el TextField
        AnchorPane.setTopAnchor(textField, 50.0);
        AnchorPane.setLeftAnchor(textField, 20.0);
        AnchorPane.setRightAnchor(textField, 20.0);

        // Posicionar el botón
        AnchorPane.setBottomAnchor(button, 20.0);
        AnchorPane.setRightAnchor(button, 20.0);

        // Añadir los elementos al AnchorPane
        root.getChildren().addAll(label, textField, button);

        Scene scene = new Scene(root, 400, 250);

        stage.setTitle("Ejemplo de AnchorPane");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
