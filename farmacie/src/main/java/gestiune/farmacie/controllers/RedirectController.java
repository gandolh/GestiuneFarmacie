package gestiune.farmacie.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RedirectController {
    public void goToAplicationEntry(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("aplicationEntry.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToHome(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
