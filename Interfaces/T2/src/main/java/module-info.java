module org.t2.t2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.t2 to javafx.fxml;
    exports org.t2;
}