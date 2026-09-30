package org.t2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class T2_4_1_CheckBox extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("T2.4.1 CheckBox: Pizza Price Calculator");
        BorderPane bp = new BorderPane();

        VBox vBox1 = new VBox();
        CheckBox checkBox1 = new CheckBox("Extra Cheese");
        CheckBox checkBox2 = new CheckBox("Pepperoni");
        CheckBox checkBox3 = new CheckBox("Sausage");
        vBox1.getChildren().addAll(checkBox1, checkBox2, checkBox3);

        VBox vBox2 = new VBox();
        CheckBox checkBox4 = new CheckBox("Green Pepper");
        CheckBox checkBox5 = new CheckBox("Onion");
        CheckBox checkBox6 = new CheckBox("Anchovies");
        vBox2.getChildren().addAll(checkBox4, checkBox5, checkBox6);

        Text text = new Text("Pizza Cost: $10.00");
        text.setFont(Font.font(20));

        Button button = new Button("Pizza Price Calculator");

        bp.setPadding(new Insets(20, 20, 10, 10));
        bp.setStyle("-fx-background-color: #b193cd");

        bp.setLeft(vBox1);
        bp.setRight(vBox2);
        bp.setBottom(text);
        bp.setCenter(button);
        BorderPane.setAlignment(text, Pos.BOTTOM_CENTER);

        Scene scene = new Scene(bp, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
