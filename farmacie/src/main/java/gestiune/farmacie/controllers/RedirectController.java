package gestiune.farmacie.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RedirectController {
    public void goToAplicationEntry(Stage stage)  {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/aplicationEntry.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToHome(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/Home.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToMyAccount(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gestiune/farmacie/controllers/myAccount.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
