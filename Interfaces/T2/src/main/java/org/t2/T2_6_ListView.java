package org.t2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class T2_6_ListView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("T2.6 ListView");
        ListView listView = new ListView();
        listView.getItems().add("Matemáticas");
        listView.getItems().add("Fisica y Quimica");
        listView.getItems().add("JavaFX");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Pane pane = new Pane();
        pane.getChildren().add(listView);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
