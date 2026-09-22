package com.example.t1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class T1_6_1_BorderPane extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        String[] mensajes = new String[5];
        for (int i = 0; i < 5; i++){
            String m = "Boton "+(i+1);
            mensajes[i] = m;
        }
        Button button1 = new Button(mensajes[0]);
        Button button2 = new Button(mensajes[1]);
        Button button3 = new Button(mensajes[2]);
        Button button4 = new Button(mensajes[3]);
        Button button5 = new Button(mensajes[4]);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(button1);
        borderPane.setLeft(button2);
        borderPane.setCenter(button3);
        borderPane.setRight(button4);
        borderPane.setBottom(button5);

        BorderPane.setAlignment(button1,Pos.CENTER);
        BorderPane.setAlignment(button2,Pos.CENTER);
        BorderPane.setAlignment(button3,Pos.CENTER);
        BorderPane.setAlignment(button4,Pos.CENTER);
        BorderPane.setAlignment(button5, Pos.CENTER);

        Scene scene = new Scene(borderPane);

        stage.setScene(scene);
        stage.setTitle("T1_6_BorderPane1");
        stage.show();
    }
}
