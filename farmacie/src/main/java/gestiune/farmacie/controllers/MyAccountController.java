package gestiune.farmacie.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MyAccountController implements Initializable {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField birthdateField;
    @FXML
    private TextField hiredateField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameField.setText("2");
        firstNameField.setText("2");
        lastNameField.setText("2");
        birthdateField.setText("2");
        hiredateField.setText("2");
    }
}
