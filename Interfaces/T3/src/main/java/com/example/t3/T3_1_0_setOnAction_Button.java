package com.example.t3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class T3_1_0_setOnAction_Button extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("Haz click");
        Label label = new Label();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(button, label);

        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setTitle("T3.1.0.setOnAction_Button");
        primaryStage.setScene(scene);
        primaryStage.show();

        button.setOnAction(event -> {
                label.setText("Arigato Onichan!");
            }
        );

        /*button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText("Arigato Onichan!");

            }
        });*/
    }
}
