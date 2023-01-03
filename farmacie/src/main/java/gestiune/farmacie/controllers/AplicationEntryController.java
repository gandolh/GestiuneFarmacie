package gestiune.farmacie.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller-ul pentru scena principala a aplicatiei JavaFx
 */
public class AplicationEntryController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Redirectionare catre scena login
     * @param event
     * @throws IOException
     */
    @FXML
    private void goToLogIn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Redirectionare catre scena Signup
     * @param event
     * @throws IOException
     */
    @FXML
    private void goToSignUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}