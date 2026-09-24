package com.example.t1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class T1_8_AchorPane extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("T1_8_AnchorPane");
        Button button1 = new Button("boton 1");
        Button button2 = new Button("boton 2");
        Button button3 = new Button("boton 3");
        Button button4 = new Button("boton 4");
        Button button5 = new Button("boton 5");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(button1, button2, button3, button4, button5);

        AnchorPane.setBottomAnchor(button4, 10d);
        AnchorPane.setTopAnchor(button4, 200d);
        AnchorPane.setRightAnchor(button1, 100d);
        AnchorPane.setLeftAnchor(button1, 100d);

        Scene scene = new Scene(anchorPane, 500, 500);
        stage.setScene(scene);
        stage.show();

    }
}
