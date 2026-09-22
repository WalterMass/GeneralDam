package com.example.t1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class T1_6_2_BorderPane extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();

        Label label1 = new Label("Top");
        Label label2 = new Label("Left");
        Label label3 = new Label("Center");
        Label label4 = new Label("Right");
        Label label5 = new Label("Bottom");


        label1.setStyle("-fx-alignment: center; -fx-background-color: #37ff00;");
        label2.setStyle("-fx-alignment: center; -fx-background-color: #fff200;");
        label3.setStyle("-fx-alignment: center; -fx-background-color: #0033ff;");
        label4.setStyle("-fx-alignment: center; -fx-background-color: #fff200;");
        label5.setStyle("-fx-alignment: center; -fx-background-color: #37ff00;");

        label1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);




        borderPane.setTop(label1);
        borderPane.setLeft(label2);
        borderPane.setCenter(label3);
        borderPane.setRight(label4);
        borderPane.setBottom(label5);

        BorderPane.setAlignment(label1,Pos.CENTER);
        BorderPane.setAlignment(label2,Pos.CENTER);
        BorderPane.setAlignment(label3,Pos.CENTER);
        BorderPane.setAlignment(label4,Pos.CENTER);
        BorderPane.setAlignment(label5, Pos.CENTER);

        Scene scene = new Scene(borderPane, 400, 400);
        stage.setScene(scene);
        stage.setTitle("T1_6_2_BorderPane");
        stage.show();
    }
}
