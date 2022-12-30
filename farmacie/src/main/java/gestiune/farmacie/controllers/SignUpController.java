package gestiune.farmacie.controllers;

import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmField;
    @FXML
    private Button signButton;

    public void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToAplicationEntry(stage);
    }

    public void SignUp(ActionEvent event) throws IOException {

        UserRepository userRepo = new UserRepository();
        User user = new User();
        userRepo.createUser(
        );


        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToHome(stage);
    }


}
