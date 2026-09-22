package com.example.t1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class T1_7_TilePane extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("T1_7_TilePane");
        TilePane tilePane = new TilePane();

        tilePane.setHgap(10);
        tilePane.setVgap(10);
        for (int i = 0 ; i < 20 ; i++){
            Button button = new Button("botn "+(i+1));
            tilePane.getChildren().add(button);
        }

        Scene scene = new Scene(tilePane);
        stage.setScene(scene);
        stage.show();


    }
}
