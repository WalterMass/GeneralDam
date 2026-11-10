import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class T4_2_Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("com/example/fxml/t4/t4_0.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("T4.2 Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
