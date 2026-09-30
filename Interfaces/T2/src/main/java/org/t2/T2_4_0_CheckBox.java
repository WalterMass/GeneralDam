package org.t2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T2_4_0_CheckBox extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        CheckBox checkBox1 = new CheckBox("opcion1");
        CheckBox checkBox2 = new CheckBox("opcion2");

        HBox hBox = new HBox(5, checkBox1, checkBox2);
        hBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(hBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("T2.4.0 checkbox");
        primaryStage.show();

    }
}
