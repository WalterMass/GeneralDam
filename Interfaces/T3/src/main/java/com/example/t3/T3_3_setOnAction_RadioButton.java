package com.example.t3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3_3_setOnAction_RadioButton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        RadioButton radioButton1 = new RadioButton("Opcion1");
        RadioButton radioButton2 = new RadioButton("Opcion2");
        Label label = new Label();

        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(radioButton1, radioButton2, label);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5d);

        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setTitle("T3.1.0.setOnAction_Button");
        primaryStage.setScene(scene);
        primaryStage.show();

        radioButton1.setOnAction(event -> {
                label.setText("Has elegido la opcion 1");
            }
        );

        radioButton2.setOnAction(event -> {
                    label.setText("Has elegido la opcion 2");
                }
        );
    }
}
