package com.example.t3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class T3_5_Pizza extends Application {
    static final int NUM_CHECKBOX = 7;
    static double precio = 10.00d;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("T2.4.1 CheckBox: Pizza Price Calculator");
        BorderPane bp = new BorderPane();

        VBox vBox1 = new VBox();
        int[] precios = new int[NUM_CHECKBOX];
        CheckBox[] checkBoxes = new CheckBox[NUM_CHECKBOX];

        for (int i = 1; i < precios.length; i++){
            precios[i-1] = i;
        }
        // este precio pertenece a la propina, funciona algo diferente al resto, lo dejo en 0
        precios[6] = 0;

        checkBoxes[0] = new CheckBox("Extra Cheese: $"+precios[0]);
        checkBoxes[1] = new CheckBox("Pepperoni: $"+precios[1]);
        checkBoxes[2] = new CheckBox("Sausage: $"+precios[2]);
        vBox1.getChildren().addAll(checkBoxes[0],checkBoxes[1], checkBoxes[2]);

        VBox vBox2 = new VBox();
        checkBoxes[3] = new CheckBox("Green Pepper: $"+precios[3]);
        checkBoxes[4] = new CheckBox("Onion: $"+precios[4]);
        checkBoxes[5] = new CheckBox("Anchovies: $"+precios[5]);

        checkBoxes[6] = new CheckBox("Tip: $");
        TextField textField = new TextField( String.valueOf(precios[6]) );
        textField.setMaxSize(35, 20);
        HBox hBox1 = new HBox(checkBoxes[6], textField);
        vBox2.getChildren().addAll(checkBoxes[3], checkBoxes[4], checkBoxes[5], hBox1);

        Text text = new Text("Pizza Cost: $10.00");
        text.setFont(Font.font(20));

        Button button = new Button("Pizza Price Calculator");

        bp.setPadding(new Insets(20, 20, 10, 10));
        bp.setStyle("-fx-background-color: #b193cd");

        Button button2 = new Button("Ordenar");
        VBox vBox3 = new VBox(text, button2);
        vBox3.setAlignment(Pos.CENTER);

        bp.setLeft(vBox1);
        bp.setRight(vBox2);
        bp.setCenter(button);
        bp.setBottom(vBox3);
        BorderPane.setAlignment(text, Pos.BOTTOM_CENTER);


        Scene scene = new Scene(bp, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

        textField.setOnMouseClicked(event -> {
            checkBoxes[6].setSelected(true);
        });

        button.setOnAction(event -> {
            precio = 10.00d;
            precios[6] = Integer.parseInt(textField.getText());

            for (int i = 0; i < checkBoxes.length; i++){
                if (checkBoxes[i].isSelected()){
                    precio+= precios[i];
                }
            }
            text.setText("Pizza Cost: $"+precio);
        });


        button2.setOnAction(event -> {
            Label label2_1 = new Label("ORDER RECEIVED! Please wait");
            VBox vBox2_1 = new VBox(label2_1);
            vBox2_1.setAlignment(Pos.CENTER);
            vBox2_1.setStyle("-fx-font-size: 24; -fx-font-weight: bold");

            Scene scene2 = new Scene(vBox2_1,500, 200);
            primaryStage.setScene(scene2);
            primaryStage.show();
        });


    }
}
