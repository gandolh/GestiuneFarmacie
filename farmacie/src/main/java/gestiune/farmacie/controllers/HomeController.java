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

/**
 * Controller-ul pentru pagina de acasa
 */
public class HomeController implements Initializable {

    /**
     * Controller JavaFX
     */
    public HomeController() {
    }

    /**
     * Label pentru afisarea unui mesaj de salut utilizatorului
     */
    @FXML
    private Label greetingLabel;
    /**
     * Layout-ul principal al ferestrei
     */
    @FXML
    private BorderPane rootBorderPane;

    /**
     * Redirectionare catre pagina contul meu
     * @param event
     * @throws IOException
     */
    @FXML
    private void goToMyAcount(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToMyAccount(stage);
    }

    /**
     * Adaugarea barei de navigatie la pornirea aplicatiei
     * @param url
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resourceBundle
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addMenuBar();
    }


    /**
     * Adaugarea barei de navigatie la pornirea aplicatiei
     */
    private void addMenuBar(){
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
        greetingLabel.setText("Salut, " + PlatformInstance.getUser().getUsername());
    }
}
