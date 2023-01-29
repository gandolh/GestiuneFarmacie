package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.objects.PlatformInstance;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * user controller
 */
public class UserSettingsController implements Initializable {
    /**
     * root borderPane
     */
    public BorderPane rootBorderPane;

    /**
     * Constructor implicit
     */
    public UserSettingsController() {
    }

    /**
     * Initializare
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addMenuBar();
    }

    /**
     * Adaugare menu bar
     */
    private void addMenuBar(){
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
    }
}
