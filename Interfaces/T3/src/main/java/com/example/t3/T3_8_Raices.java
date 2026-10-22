package com.example.t3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class T3_8_Raices extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        datePicker.setStyle("-fx-fontsize: 9");
        datePicker.setPromptText("Introduzca la fecha");

        datePicker.setMaxSize(80, 100);

        AnchorPane.setLeftAnchor(datePicker, 20.0);
        AnchorPane.setTopAnchor(datePicker, 20.0);
        anchorPane.getChildren().addAll(datePicker);

        ScrollPane scrollPane = new ScrollPane();

        VBox vBox = new VBox(anchorPane, scrollPane);


        Scene scene = new Scene(vBox, 960, 720);
        primaryStage.setTitle("T3.8.Raices");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
