package com.example.t1;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class T1_1_hBox extends Application {
    @Override
    // crea stage
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(T1_1_hBox.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/

        //crea boton
        Button button1 = new Button();
        String texto1 = "Boton1";
        button1.setText(texto1);

        //crea boton 2
        Button button2 = new Button();
        String texto2 = "Boton2";
        button2.setText(texto2);
        // crea HBox
        HBox hBox = new HBox();
        // añade boton a HBox
        hBox.getChildren().addAll(button1,button2);
        // mete el HBox en la
        Scene scene = new Scene(hBox, 200, 200);
        // mete la escena en el stage
        stage.setScene(scene);
        stage.setTitle("STAGE");
        //muestra el stage
        stage.show();
    }
}
