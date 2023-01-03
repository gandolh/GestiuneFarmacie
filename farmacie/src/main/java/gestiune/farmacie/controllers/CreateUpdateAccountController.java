package gestiune.farmacie.controllers;

import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.utils.DateConverter;
import gestiune.farmacie.utils.EmailOperations;
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
import java.time.LocalDate;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * Controller-ul specific scenei de adaugare sau actualizare a unui utilizator
 */
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
    private TextField emailField;
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

    private User selectedUser;


    /**
     * Redirectionare catre scena de gestionare a conturilor
     * @param event
     */
    public void cancel(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToManageUsers(stage);
    }

    /**
     * Metoda corespunzatoare butonului de adaugare a unui nou utilizator
     * @param event
     */
    @FXML
    private void add(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String firstname = firstNameField.getText();
        String lastname = lastNameField.getText();
        String email = emailField.getText();
        Date birthdate = Date.valueOf(birthdateField.getValue());
        Date hiredate = Date.valueOf(hiredateField.getValue());
        createUser((Stage) ((Node) event.getSource()).getScene().getWindow(),
                username,email, password, firstname, lastname, birthdate, hiredate);

    }

    /**
     * Crearea unui utilizator
     * @param stage Reprezinta o referinta catre fereastra curenta
     * @param username
     * @param email
     * @param password
     * @param firstname
     * @param lastname
     * @param birthdate
     * @param hiredate
     */
    private void createUser(Stage stage,String username,String email, String password, String firstname,
                           String lastname, Date birthdate, Date hiredate){
        boolean isUserCreated = false;
        UserRepository userRepo = new UserRepository();
        isUserCreated = userRepo.createUser(username,email, password, firstname, lastname, birthdate, hiredate);
        if (isUserCreated == true) {
            RedirectController redirect = new RedirectController();
            redirect.goToManageUsers(stage);
        }
    }


    /**
     * Actiunea corespunzatoare butonului de actualizare
     * @param event
     */
    public void update(ActionEvent event){
        String username = usernameField.getText();
        String email = emailField.getText();
        String firstname = firstNameField.getText();
        String lastname = lastNameField.getText();
        Date birthdate = Date.valueOf(birthdateField.getValue());
        Date hiredate = Date.valueOf(hiredateField.getValue());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        updateUser(stage, username, email, selectedUser.getUserId(), firstname, lastname, birthdate,
                hiredate,selectedUser.getEmployeeId());
    }


    /**
     * actualizarea unui utilizator
     * @param stage Fereastra curenta
     * @param username
     * @param email
     * @param userId
     * @param firstname
     * @param lastname
     * @param birthdate
     * @param hiredate
     * @param employeeId
     */
    private void updateUser(Stage stage,String username, String email, String userId, String firstname, String lastname, Date birthdate, Date hiredate, String employeeId){
        boolean isUserUpdated = false;
        UserRepository userRepo = new UserRepository();
        isUserUpdated = userRepo.updateUser(username, email, userId, firstname, lastname, birthdate,
                hiredate,employeeId);
        if (isUserUpdated == true) {
            RedirectController redirect = new RedirectController();
            redirect.goToManageUsers(stage);
        }
    }

    /**
     * Initializarea componentei
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) { }


    /**
     * Initializarea scenei specific crearii
     */
    public void initializeCreate(){
        resetPasswordBtn.setVisible(false);
        passwordField.setVisible(true);
        addOrUpdateBtn.setText("adauga");
        addOrUpdateBtn.setOnAction(this::add);
        birthdateField.setValue(LocalDate.now());
        hiredateField.setValue(LocalDate.now());

    }

    /**
     * Initializarea scenei specific actualizarii
     * @param user
     */
    public void initializeUpdate(User user){
        this.selectedUser = user;
        resetPasswordBtn.setVisible(true);
        passwordField.setVisible(false);
        addOrUpdateBtn.setText("actualizeaza");
        addOrUpdateBtn.setOnAction(this::update);
        usernameField.setText(selectedUser.getUsername());
        firstNameField.setText(selectedUser.getFirstname());
        lastNameField.setText(selectedUser.getLastname());
        emailField.setText(selectedUser.getEmail());
        passwordField.clear();
        birthdateField.setValue(DateConverter.convertToLocalDateViaInstant(selectedUser.getBirthdate()));
        hiredateField.setValue(DateConverter.convertToLocalDateViaInstant(selectedUser.getHiredate()));
    }

    /**
     * Reseteaza parola unui utilizator
     */
    public void resetPassword(){
        String newPassword = String.valueOf(UUID.randomUUID());
        UserRepository userRepo = new UserRepository();
        boolean isPaswordReseted = userRepo.changePassword(selectedUser.getUserId(), newPassword);
        if(isPaswordReseted)
            EmailOperations.sendResetPassword(selectedUser.getEmail(), newPassword);

    }

    /**
     * Trimite utilizatorul selectat
     * @return Utilizatorul selectat pentru scena curenta
     */
    public User getSelectedUser() {
        return selectedUser;
    }

    /**
     * Seteaza utilizatorul selectat
     * @param selectedUser Utilizatorul selectat pentru scena curenta
     */
    public void setSelectedUser(User selectedUser) {
        selectedUser = selectedUser;
    }
}
