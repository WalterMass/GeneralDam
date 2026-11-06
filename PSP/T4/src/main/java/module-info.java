module com.example.t4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.t4 to javafx.fxml;
    exports com.example.t4;
}