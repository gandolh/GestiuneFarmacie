package gestiune.farmacie.controller;

import gestiune.farmacie.classes.PlatformInstance;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Label greetingLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        greetingLabel.setText("Salut, " + PlatformInstance.getUser().getUsername());
    }
}
