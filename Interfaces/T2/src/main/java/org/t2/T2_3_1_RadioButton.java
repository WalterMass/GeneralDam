package org.t2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T2_3_1_RadioButton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        RadioButton radioButton1 = new RadioButton("opcion1");
        RadioButton radioButton2 = new RadioButton("opcion2");

        ToggleGroup toggleGroup = new ToggleGroup();

        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);

        HBox hBox = new HBox(60, radioButton1, radioButton2);
        hBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(hBox, 500, 400);



        primaryStage.setScene(scene);
        primaryStage.setTitle("T2.3 Radiobutton");
        primaryStage.show();

    }
}
