package org.t2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class T2_8_1_MenuBar extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();

        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("T2.8.0 MenuBar");
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
}
