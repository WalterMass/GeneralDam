package com.example.t1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class T1_5_GridPane extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("T1_5_GridPane");

        GridPane gridPane = new GridPane();

        Button[] buttons = new Button[4];
        for (int i = 0; i < 4; i++){
            String name = "Button-"+(i+1);
            Button button = new Button(name);
            buttons[i] = button;
        }
        gridPane.add(buttons[0], 0, 0);
        gridPane.add(buttons[1], 1, 1);
        gridPane.add(buttons[2], 2, 2);
        gridPane.add(buttons[3], 3, 1);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();


    }
}
