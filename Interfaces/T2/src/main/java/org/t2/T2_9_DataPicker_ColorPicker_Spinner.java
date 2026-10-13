package org.t2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class T2_9_DataPicker_ColorPicker_Spinner extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Introduzca la fecha");
        datePicker.setValue(LocalDate.of(2026, 10, 13));
        ColorPicker colorPicker = new ColorPicker();
        Spinner spinner = new Spinner(0, 100, 10);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(datePicker, colorPicker, spinner);

        Scene scene = new Scene(hBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("T2.9.DatPicker_ColorPicker_Spinner");
        primaryStage.show();
    }
}
