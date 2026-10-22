package com.example.t3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3_2_setOnAction_TextField extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label1 = new Label("Enter u name");
        TextField textField = new TextField();
        textField.setMaxWidth(200);
        Label label2 = new Label();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(label1, textField,label2);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5d);

        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setTitle("T3.1.0.setOnAction_Button");
        primaryStage.setScene(scene);
        primaryStage.show();

        textField.setOnAction(event -> {
                label2.setText("Hola "+textField.getText());
            }
        );
    }
}
