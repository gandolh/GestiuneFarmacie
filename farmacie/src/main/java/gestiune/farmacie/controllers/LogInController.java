package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyDialog;
import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.data.objects.PlatformInstance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    public void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToAplicationEntry(stage);
    }

    public void logIn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        UserRepository userRepo = new UserRepository();
        boolean isUser = userRepo.getIsUser(usernameField.getText(), passwordField.getText());
        if (isUser) {
            User user = userRepo.getUser(usernameField.getText(),passwordField.getText());
            PlatformInstance.setUser(user);
            RedirectController redirect = new RedirectController();
            redirect.goToHome(stage);
        } else {
            MyDialog dialog = new MyDialog(Alert.AlertType.ERROR);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //ONLY FOR DEBUG
        usernameField.setText("admin");
        passwordField.setText("admin");
    }
}
