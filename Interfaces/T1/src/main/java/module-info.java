module com.example.t1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.t1 to javafx.fxml;
    exports com.example.t1;
}