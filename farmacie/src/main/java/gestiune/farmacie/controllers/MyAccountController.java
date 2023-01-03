package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.data.objects.PlatformInstance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Controller-ul specific "contului meu"
 */
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
    @FXML
    private TextField emailField;
    @FXML
    private BorderPane rootBorderPane;
    @FXML
    private TextField passwordField;

    /**
     * Adaugare bara de navigatie si completare cu datele utilizatorului curent
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
        fillFields(PlatformInstance.getUser());

    }

    /**
     * adaugare bara de navigatie
     */
    private void addMenuBar(){
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
    }


    /**
     * Completare campuri cu ajutorul unui utilizator
     * @param user Datele de utilizator pentru completarea campurilor machetei
     */
    private void fillFields(User user){
        usernameField.setText(user.getUsername());
        firstNameField.setText(user.getFirstname());
        lastNameField.setText(user.getLastname());
        emailField.setText(user.getEmail());
        ;
        birthdateField.setText(
                PlatformInstance.getDateFormat()
                        .format(user.getBirthdate())
        );
        hiredateField.setText(
                PlatformInstance.getDateFormat()
                        .format(user.getHiredate())
        );
    }


    /**
     * Schimbarea parolei utilizatorului curent
     * @param event
     */
    public void changePassword(ActionEvent event){
        UserRepository userRepo = new UserRepository();
        userRepo.changePassword(PlatformInstance.getUser().getUserId(), passwordField.getText());
    }


}
