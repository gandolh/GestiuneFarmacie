package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.objects.PlatformInstance;
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
    private BorderPane rootBorderPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
        usernameField.setText(PlatformInstance.getUser().getUsername());
        firstNameField.setText(PlatformInstance.getUser().getFirstname());
        lastNameField.setText(PlatformInstance.getUser().getLastname());
        ;
        birthdateField.setText(
                PlatformInstance.getDateFormat()
                    .format(PlatformInstance.getUser().getBirthdate())
        );
        hiredateField.setText(
                PlatformInstance.getDateFormat()
                    .format(PlatformInstance.getUser().getHiredate())
        );


    }


}
