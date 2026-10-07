package org.t2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class T2_7_1_TextField_Passwd extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("T2.7.0 TextField_Passwd");

        GridPane gridPane = new GridPane();

        Label lableTitle = new Label();
        lableTitle.setText("Welcome! Please sign in.");
        lableTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label labelUser = new Label();
        labelUser.setText("UserName: ");

        Label labelPasswd = new Label();
        labelPasswd.setText("Password: ");

        TextField textField = new TextField();
        PasswordField passwordField = new PasswordField();

        textField.setPromptText("Type your username");
        passwordField.setPromptText("Type your password");

        CheckBox checkBox = new CheckBox();
        HBox hBoxShowPasswd = new HBox(new Label("Show password characters? "), checkBox);

        Button buttonSignIn = new Button();
        buttonSignIn.setText("Sign In");


        gridPane.add(lableTitle, 3, 0);
        gridPane.add(labelUser, 2, 1);
        gridPane.add(textField, 3, 1);
        gridPane.add(labelPasswd, 2, 2);
        gridPane.add(passwordField, 3, 2);
        gridPane.add(hBoxShowPasswd, 3, 3);
        gridPane.add(buttonSignIn, 3, 4);

        gridPane.setStyle("-fx-background-color: rgb(249, 230, 153);");


        Scene scene = new Scene(gridPane, 500, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
/**/