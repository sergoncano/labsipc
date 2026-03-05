package pract2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("KeyboardEvents.fxml"));

        Scene scene = new Scene(root, 600, 600);
        this.scene = scene;

        stage.setScene(scene);
        stage.show();
    }

    
}
