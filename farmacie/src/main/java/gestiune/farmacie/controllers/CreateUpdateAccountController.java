package gestiune.farmacie.controllers;

import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.time.ZoneId;
import java.util.Date;

public class CreateUpdateAccountController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField passwordField;
    @FXML
    private DatePicker birthdateField;
    @FXML
    private DatePicker hiredateField;
    @FXML
    private BorderPane rootBorderPane;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button addBtn;

    public void cancel(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToManageUsers(stage);
    }

    public void add(ActionEvent event){
        boolean isUserCreated = false;
        String username = usernameField.getText();
        String password = passwordField.getText();
        String firstname = firstNameField.getText();
        String lastname = lastNameField.getText();
        Date birthdate = Date.from(birthdateField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date hiredate = Date.from(hiredateField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        UserRepository userRepo = new UserRepository();
        isUserCreated = userRepo.createUser(username,password, firstname, lastname, birthdate, hiredate);

        if(isUserCreated ==true){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            RedirectController redirect = new RedirectController();
            redirect.goToManageUsers(stage);
        }

    }

}
