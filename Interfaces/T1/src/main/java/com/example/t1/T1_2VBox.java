package com.example.t1;

import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class T1_2VBox  extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("T1.2.2 VBox");

        Button button1 = new Button();
        Button button2 = new Button();

        String textB1 = "Botón-1    ";
        String textB2 = "Botón-2";

        button1.setText(textB1);
        button2.setText(textB2);

        Button miniButton1 = new Button("miniButton-1");
        Button miniButton2 = new Button("miniButton-2");

        Text text = new Text("Text");
        text.setFill(Color.RED);

        CheckBox checkBox = new CheckBox();
        checkBox.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        VBox vBox = new VBox();
        VBox vBoxChildren = new VBox();

        vBoxChildren.getChildren().addAll(miniButton1,miniButton2);
        vBox.getChildren().addAll(button1,vBoxChildren,text,checkBox);


        vBox.setAlignment(Pos.CENTER);
        vBoxChildren.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBoxChildren.setSpacing(3);


        Scene scene = new Scene(vBox, 400,400);

        stage.setScene(scene);
        stage.show();
    }
}
