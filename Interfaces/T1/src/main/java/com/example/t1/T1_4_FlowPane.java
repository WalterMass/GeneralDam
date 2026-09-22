package com.example.t1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class T1_4_FlowPane extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        int buttonsNumber = 20;

        stage.setTitle("T4_FlowPane");
        Text flow1 = new Text("Flow Pane 1");
        Text flow2 = new Text("Flow Pane 2");

        FlowPane flowPane1 = new FlowPane();
        FlowPane flowPane2 = new FlowPane();

        flow1.setFill(Color.RED);
        flow2.setFill(Color.BLUE);


        Button[] buttons = new Button[buttonsNumber];

        VBox vBox = new VBox();
        vBox.getChildren().addAll(flow1, flowPane1, flow2, flowPane2);
        vBox.setSpacing(40);

        for (int i = 0; i < buttonsNumber; i++){
            String name = "Botón-"+(i+1);

            Button button1 = new Button(name);
            buttons[i] = button1;
            flowPane1.getChildren().add(buttons[i]);

            Button button2 = new Button(name);
            flowPane2.getChildren().add(button2);
        }

        Button button12 =(Button)flowPane2.getChildren().get(11);
        button12.setText("ESTE ES EL 12");

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();

    }
}
