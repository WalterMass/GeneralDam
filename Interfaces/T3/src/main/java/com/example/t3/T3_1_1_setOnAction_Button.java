package com.example.t3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class T3_1_1_setOnAction_Button extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5d);

        AtomicInteger valueButton1 = new AtomicInteger();

        Button button1 = new Button("Incrementar contador");
        Button button2 = new Button("Reiniciar");
        Label label = new Label(String.valueOf(valueButton1.get()));

        vBox.getChildren().addAll(button1, button2, label);

        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setTitle("T3.1.1.setOnAction_Button");
        primaryStage.setScene(scene);
        primaryStage.show();

        button1.setOnAction(event -> {
                valueButton1.getAndIncrement();
                label.setText(String.valueOf(valueButton1));
            }
        );

        button2.setOnAction(event -> {
                valueButton1.set(0);
                label.setText("0");
            }
        );
    }
}
