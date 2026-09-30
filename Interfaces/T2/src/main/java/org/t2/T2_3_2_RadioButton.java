package org.t2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class T2_3_2_RadioButton extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        List<RadioButton> radioButtons = new ArrayList<>();
        ToggleGroup toggleGroup = new ToggleGroup();
        VBox vBox = new VBox(5);

        Text text = new Text("10 + 20 ?");
        vBox.getChildren().add(text);
        vBox.setStyle("-fx-background-color: peachpuff");

        for (int i = 1; i <= 4; i++){
            String num = ""+(i*10);
            RadioButton radioButton = new RadioButton(num);
            radioButtons.add(radioButton);
            radioButton.setToggleGroup(toggleGroup);
            vBox.getChildren().add(radioButton);
        }



        vBox.setAlignment(Pos.CENTER);


        Scene scene = new Scene(vBox, 500, 400);



        primaryStage.setScene(scene);
        primaryStage.setTitle("T2.3.2 Radiobutton");
        primaryStage.show();
    }
}
