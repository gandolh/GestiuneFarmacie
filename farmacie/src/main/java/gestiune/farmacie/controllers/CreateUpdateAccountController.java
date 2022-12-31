package gestiune.farmacie.controllers;

import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.objects.PlatformInstance;
import gestiune.farmacie.utils.DateConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.attribute.FileAttribute;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
import java.util.ResourceBundle;

public class CreateUpdateAccountController implements Initializable {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button resetPasswordBtn;
    @FXML
    private RowConstraints resetPasswordGridRow;
    @FXML
    private DatePicker birthdateField;
    @FXML
    private DatePicker hiredateField;
    @FXML
    private BorderPane rootBorderPane;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button addOrUpdateBtn;





    public void cancel(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToManageUsers(stage);
    }

    public void add(ActionEvent event) {
        boolean isUserCreated = false;
        String username = usernameField.getText();
        String password = passwordField.getText();
        String firstname = firstNameField.getText();
        String lastname = lastNameField.getText();
        Date birthdate = Date.valueOf(birthdateField.getValue());
        Date hiredate = Date.valueOf(hiredateField.getValue());
        UserRepository userRepo = new UserRepository();
        isUserCreated = userRepo.createUser(username, password, firstname, lastname, birthdate, hiredate);

        if (isUserCreated == true) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            RedirectController redirect = new RedirectController();
            redirect.goToManageUsers(stage);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    public void initializeCreate(){
        resetPasswordBtn.setVisible(false);
        passwordField.setVisible(true);
        addOrUpdateBtn.setText("adauga");
        birthdateField.setValue(LocalDate.now());
        hiredateField.setValue(LocalDate.now());
    }

    public void initializeUpdate(){
        resetPasswordBtn.setVisible(true);
        passwordField.setVisible(false);
        addOrUpdateBtn.setText("actualizeaza");
        usernameField.setText(PlatformInstance.getUser().getUsername());
        firstNameField.setText(PlatformInstance.getUser().getFirstname());
        lastNameField.setText(PlatformInstance.getUser().getLastname());
        passwordField.clear();
        birthdateField.setValue(DateConverter.convertToLocalDateViaInstant(PlatformInstance.getUser().getBirthdate()));
        hiredateField.setValue(DateConverter.convertToLocalDateViaInstant(PlatformInstance.getUser().getHiredate()));
    }


    public void resetPassword(){
        System.out.println("Reset password");
    }
}
