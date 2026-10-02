package org.t2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        String color = String.format("#-%04d", 0);
        ComboBox comboBox2 = new ComboBox();
        hBox.getChildren().add(comboBox2);
        for (int i = 0; i < CANTIDAD; i++){
            color += 20;
            Label label = new Label();
            labels2.add(label);
            labels2.get(i).setStyle("-fx-background-color: #"+color+"; -fx-arc-width: 25; -fx-arc-height: 10");
        }
        comboBox2.getItems().addAll(labels2);

        hBox.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(hBox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
