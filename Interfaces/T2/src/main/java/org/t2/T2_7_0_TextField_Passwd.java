package org.t2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T2_7_0_TextField_Passwd extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("T2.7.0 TextField_Passwd");
        TextField textField = new TextField();
        PasswordField passwordField = new PasswordField();

        textField.setPromptText("Type your username");
        passwordField.setPromptText("Type your password");

        VBox vBox = new VBox(textField, passwordField);
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
