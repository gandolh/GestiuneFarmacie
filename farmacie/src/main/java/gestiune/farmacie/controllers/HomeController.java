package gestiune.farmacie.controllers;

import gestiune.farmacie.data.objects.PlatformInstance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Label greetingLabel;


    @FXML
    public void goToMyAcount(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToMyAccount(stage);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        greetingLabel.setText("Salut, " + PlatformInstance.getUser().getUsername());
    }
}
