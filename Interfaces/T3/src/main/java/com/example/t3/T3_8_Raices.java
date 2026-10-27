package com.example.t3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class T3_8_Raices extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        datePicker.setStyle("-fx-fontsize: 9");
        datePicker.setPromptText("Introduzca la fecha");

        datePicker.setMaxSize(120, 150);

        AnchorPane.setLeftAnchor(datePicker, 10d);
        AnchorPane.setTopAnchor(datePicker, 20.0);
        AnchorPane.setBottomAnchor(datePicker, 20d);

        Button buttonAceptar = devuelveBotton("src/main/resources/png/aceptar.png", "Aceptar");
        Button buttonBorrar = devuelveBotton("src/main/resources/png/borrar.png", "Borrar");
        Button buttonCerrar = devuelveBotton("src/main/resources/png/cerrar.png", "Cerrar");

        HBox hBoxBotones = new HBox(buttonAceptar, buttonBorrar, buttonCerrar);
        AnchorPane.setRightAnchor(hBoxBotones, 10d);
        AnchorPane.setTopAnchor(hBoxBotones, 20d);
        AnchorPane.setBottomAnchor(hBoxBotones, 20d);

        anchorPane.getChildren().addAll(datePicker, hBoxBotones);

        FlowPane flowPaneAlumnos = new FlowPane();
        //todo

        List<VBox> alumnos = new ArrayList<>();

        String[] nombres = {
                "Alvarado Cervera, Kevin"
                ,"Álvarez Serna, Alejandro"
                ,"Barrio Calvo, Iván"
                ,"Barros Iihoshi, Walter"
                ,"Briceño Centeno, Jhonnah"
                ,"Camacho Torres, Carlos"
                ,"Carretero Fuentes, Ibai"
                ,"Domínguez Sampedro, Rubén"
                ,"Fernández González, Alejandro"
                ,"Flores Flores, Ángel"
                ,"González Moreno, Arturo"
                ,"Gonzalo Rodríguez, Unax"
                ,"Hogescu Marín, Álex"
                ,"Laminatao de los Santos, Ron"
                ,"Lara Lozano, Joaquín"
                ,"Martín Crespo, Daniel"
                ,"Morcillo Mota, Marcos"
                ,"Pérez Sánchez, Marcos"
                ,"Rodríguez Luna, Izan"
                ,"Sánchez Torres, Diego"
                ,"Serrano Alcalde, Rubén"
                ,"Valencia Echevarry, Juan"
        };

        String[] paths = {
                "null",
        };

        for (int i = 0; i < nombres.length; i++) {

        }

        ScrollPane scrollPane = new ScrollPane();

        VBox vBox = new VBox(anchorPane, scrollPane);

        Scene scene = new Scene(vBox, 960, 720);
        primaryStage.setTitle("T3.8.Raices");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public VBox devuelveVBoxAlumno(String pathImg, String nombreAlumno){

        if (pathImg.equals("null")){
            pathImg = "src/main/resources/png/placeHolder.png";
        }

        Image img = new Image("file:"+pathImg);
        ImageView vista = new ImageView(img);

        Label nombre = new Label(nombreAlumno);

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton radioButtonInjustificada = new RadioButton("I");
        radioButtonInjustificada.setToggleGroup(toggleGroup);

        RadioButton radioButtonJustificada = new RadioButton("J");
        radioButtonJustificada.setToggleGroup(toggleGroup);

        RadioButton radioButtonRetraso = new RadioButton("R");
        radioButtonRetraso.setToggleGroup(toggleGroup);

        HBox hBox = new HBox(radioButtonInjustificada, radioButtonJustificada, radioButtonRetraso);

        return new VBox(vista, nombre, hBox);
    }

    public Button devuelveBotton(String pathImg, String nombreBoton){
        Button button = new Button(nombreBoton);
        Image img = new Image("file:"+pathImg);
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        button.setGraphic(imageView);
        button.setContentDisplay(ContentDisplay.TOP);
        button.setPrefSize(90, 90);
        button.setAlignment(Pos.BOTTOM_CENTER);
        return button;
    }
}
/*
Alvarado Cervera, Kevin
Álvarez Serna, Alejandro
Barrio Calvo, Iván
Barros Iihoshi, Walter
Briceño Centeno, Jhonnah
Camacho Torres, Carlos
Carretero Fuentes, Ibai
Domínguez Sampedro, Rubén
Fernández González, Alejandro
Flores Flores, Ángel
González Moreno, Arturo
Gonzalo Rodríguez, Unax
Hogescu Marín, Álex
Laminatao de los Santos, Ron
Lara Lozano, Joaquín
Martín Crespo, Daniel
Morcillo Mota, Marcos
Pérez Sánchez, Marcos
Rodríguez Luna, Izan
Sánchez Torres, Diego
Serrano Alcalde, Rubén
Valencia Echevarry, Juan
*/