package org.t2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class T2_1_Label extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.TOP_CENTER);
        Label label1 = new Label("HOLA MUNDO!");
        Label label2 = new Label("adios");

        vBox.getChildren().addAll(label1, label2);
        Scene scene = new Scene(vBox, 1920, 1080);
        primaryStage.setScene(scene);
        primaryStage.setTitle("T2.1.Label");
        primaryStage.show();
    }
}
