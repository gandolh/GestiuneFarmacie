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

/**
 * Controller-ul pentru inregistrare
 */
public class LogInController implements Initializable {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    /**
     * Redirectionare catre punctul de intrare in aplicatie
     * @param event
     * @throws IOException
     */
    public void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToAplicationEntry(stage);
    }


    /**
     * Efectuarea autentificarii sau aruncarea unui mesaj de eroare in caz contrar
     * @param event
     * @throws IOException
     */
    public void logIn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        UserRepository userRepo = new UserRepository();
        boolean isUser = userRepo.getIsUser(usernameField.getText(), passwordField.getText());
        if (isUser) {
            authorizeUser(userRepo, stage);
        } else {
            showError();
        }
    }

    /**
     * Salvarea utilizatorului pentru uz ulterior si redirectionarea catre pagina de acasa
     * @param userRepo Clasa ajutatoare ce se ocupa de gestionarea utilizatorilor
     * @param stage Referinta asupra ferestrei curente
     */
    private void authorizeUser(UserRepository userRepo, Stage stage){
        User user = userRepo.getUser(usernameField.getText(),passwordField.getText());
        PlatformInstance.setUser(user);
        RedirectController redirect = new RedirectController();
        redirect.goToHome(stage);
    }


    /**
     * Afiseaza un modal de eroare
     */
    private void showError(){
        MyDialog dialog = new MyDialog(Alert.AlertType.ERROR);
    }


    /**
     * Precompletarea datelor initiale, din comoditate.
     * a nu se reproduce in productie
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

        //ONLY FOR DEBUG
        usernameField.setText("admin");
        passwordField.setText("admin");
    }
}
