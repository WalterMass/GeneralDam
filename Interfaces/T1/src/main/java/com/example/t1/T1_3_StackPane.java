package com.example.t1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class T1_3_StackPane extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("T1.3 VBox");

        String textB1 = "Botón-1";
        String textB2 = "Botón-2";

        Button button1 = new Button(textB1);
        Button button2 = new Button(textB2);

        button1.setPrefSize(100, 100);
        button2.setPrefSize(100,100);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(button1,button2);


        Scene scene = new Scene(stackPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
