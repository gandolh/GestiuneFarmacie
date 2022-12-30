package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.objects.PlatformInstance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.security.PrivilegedAction;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Label greetingLabel;
    @FXML
    private BorderPane rootBorderPane;
    @FXML
    public void goToMyAcount(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToMyAccount(stage);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
        greetingLabel.setText("Salut, " + PlatformInstance.getUser().getUsername());
    }
}
