package com.example.t1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class T1_6_3_BorderPain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("T1_6_2_BorderPain");
        BorderPane bp1 = new BorderPane();

        Label label11 = new Label("top 1");
        Label label12 = new Label("top 2");
        Label label13 = new Label("top 3");
        Label label14 = new Label("top 4");
        //
        label11.setFont(Font.font("verdana", FontWeight.BOLD, 30));
        label12.setFont(Font.font("verdana", FontWeight.BOLD, 30));
        label13.setFont(Font.font("verdana", FontWeight.BOLD, 30));
        label14.setFont(Font.font("verdana", FontWeight.BOLD, 30));

        label11.setBackground(Background.fill(Color.web("#FA8072")));
        label12.setBackground(Background.fill(Color.web("#FFFFFF")));
        label13.setBackground(Background.fill(Color.web("#0000FF")));
        label14.setBackground(Background.fill(Color.web("#008000")));


        BorderPane bp2 = new BorderPane();

        Label label21 = new Label("top 1");
        Label label22 = new Label("top 2");
        Label label23 = new Label("top 3");
        Label label24 = new Label("top 4");
        Label label25 = new Label("top 5");

        bp1.setTop(label11);
        bp1.setLeft(label12);
        bp1.setCenter(bp2);
        bp1.setRight(label13);
        bp1.setBottom(label14);

        bp2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        label11.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label12.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label13.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label14.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        StackPane stackPane21= crearStackPane(label21, "FA8072");
        StackPane stackPane22= crearStackPane(label22, "FFFFFF");
        StackPane stackPane23= crearStackPane(label23, "FF00FF");
        StackPane stackPane24= crearStackPane(label24, "0000FF");
        StackPane stackPane25= crearStackPane(label25, "008000");

        bp2.setTop(stackPane21);
        bp2.setLeft(stackPane22);
        bp2.setCenter(stackPane23);
        bp2.setRight(stackPane24);
        bp2.setBottom(stackPane25);

        Scene scene = new Scene(bp1);

        stage.setScene(scene);

        stage.show();


//        Scene scene= new Scene();
    }

    public StackPane crearStackPane(Label label, String color){
        StackPane sp = new StackPane(label);
        sp.setStyle("-fx-background-color: #"+color);
        sp.setPadding(new Insets(15));
        return sp;
    }

}
