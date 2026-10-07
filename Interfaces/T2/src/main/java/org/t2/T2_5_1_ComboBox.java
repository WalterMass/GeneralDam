package org.t2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class T2_5_1_ComboBox extends Application {
    public static final int CANTIDAD = 30;
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox();
        primaryStage.setTitle("T2.5.1 ComboBox");

        List<Label> labels1 = new ArrayList<>();
        ComboBox comboBox1 = new ComboBox();
        hBox.getChildren().add(comboBox1);
        for (int i = 0; i < CANTIDAD; i++){
            labels1.add(new Label(String.valueOf(i+1)));
        }
        comboBox1.getItems().addAll(labels1);

        List<Label>labels2 = new ArrayList<>();
        ComboBox comboBox2 = new ComboBox();
        hBox.getChildren().add(comboBox2);
        for (int i = 0; i < CANTIDAD; i++){

            String color = String.format("#%06X", i * 20);

            Label label = new Label();
            label.setStyle(
                    "-fx-background-color: " + color + ";" +
                            "-fx-padding: 5;" +
                            "-fx-arc-width: 25;" +
                            "-fx-arc-height: 10;"
            );

            labels2.add(label);
        }
        comboBox2.getItems().addAll(labels2);

        String[] fuentes = {
                "Arial",
                "Calibri",
                "Cambria",
                "Comic Sans MS",
                "Consolas",
                "Courier New",
                "Georgia",
                "Helvetica",
                "Impact",
                "Lucida Console",
                "Lucida Sans",
                "Microsoft Sans Serif",
                "Palatino Linotype",
                "Segoe UI",
                "Tahoma",
                "Times New Roman",
                "Trebuchet MS",
                "Verdana",
                "Century Gothic",
                "Garamond",
                "Book Antiqua",
                "Franklin Gothic Medium",
                "Gill Sans",
                "Rockwell",
                "Baskerville",
                "Copperplate",
                "Futura",
                "Optima",
                "Perpetua",
                "Candara"
        };

        ComboBox comboBox3 = new ComboBox();
        List<Label> labels3 = new ArrayList<>();
        hBox.getChildren().add(comboBox3);
        for (int i = 0; i < CANTIDAD; i++){
            Label label = new Label(fuentes[i]);
            label.setStyle("-fx-font-family: '"+fuentes[i]+"' ;"+" -fx-arc-height: 10; -fx-arc-width: 25;");
            labels3.add(label);
        }

        comboBox3.getItems().addAll(labels3);

        hBox.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(hBox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
