package gestiune.farmacie.controllers;

import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.utils.DateConverter;
import gestiune.farmacie.utils.EmailOperations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * Controller-ul specific scenei de adaugare sau actualizare a unui utilizator
 */
public class CreateUpdateAccountController implements Initializable {
    /**
     * Controller javaFX
     */
    public CreateUpdateAccountController() {
    }

    /**
     * Textfield pentru pentru numele de utilizator
     */
    @FXML
    private TextField usernameField;
    /**
     * Textfield pentru pentru prenume
     */
    @FXML
    private TextField firstNameField;
    /**
     * Textfield pentru pentru numele de familie
     */
    @FXML
    private TextField lastNameField;
    /**
     * Textfield pentru pentru parola
     */
    @FXML
    private TextField passwordField;
    /**
     * Textfield pentru pentru email
     */
    @FXML
    private TextField emailField;
    /**
     * Textfield pentru resetare parola
     */
    @FXML
    private Button resetPasswordBtn;
    /**
     * Textfield pentru linia din grid pentru resetarea parolei
     */
    @FXML
    private RowConstraints resetPasswordGridRow;
    /**
     * Datepicker pentru data nasterii
     */
    @FXML
    private DatePicker birthdateField;
    /**
     * Datepicker pentru data angajarii
     */
    @FXML
    private DatePicker hiredateField;
    /**
     * Referinta asupra elementului de layout
     */
    @FXML
    private BorderPane rootBorderPane;
    /**
     * Referinta asupra butonului de anulare asupra actiunii de editare sau creere a unui utilizator
     */
    @FXML
    private Button cancelBtn;
    /**
     * Referinta asupra butonului de editare sau creere a unui utilizator
     */
    @FXML
    private Button addOrUpdateBtn;
    /**
     * Referint aasupra utilizatorului caruia este necesara editarea datelor
     */
    private User selectedUser;


    /**
     * Redirectionare catre scena de gestionare a conturilor
     * @param event ActionEvent
     */
    public void cancel(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToManageUsers(stage);
    }

    /**
     * Metoda corespunzatoare butonului de adaugare a unui nou utilizator
     * @param event ActionEvent
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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(validate( username,  firstname,  lastname,  email,  dateFormat.format(birthdate), dateFormat.format(hiredate))){
            createUser((Stage) ((Node) event.getSource()).getScene().getWindow(),
                    username,email, password, firstname, lastname, birthdate, hiredate);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("date invalide");
            alert.setHeaderText("date invalide");
            alert.setContentText("Va rugam verificati datele introduse");
            alert.showAndWait();
        }


    }

    /**
     *
     * @return
     */
    public Boolean validate(String username, String firstname, String lastname, String email, String birthdate,
                             String hiredate){
        Boolean isUsernameValid = validateUserName(username);
        Boolean isfirstnameValid = validateFirstName(firstname);
        Boolean islastnameValid = validateLastName(lastname);
        Boolean isemailValid = validateEmail(email);
        Boolean isbirthdatValid = validateBirthdate(birthdate);
        Boolean ishiredateValid = validateHiredate(hiredate);

        return isUsernameValid && isfirstnameValid && isbirthdatValid && isemailValid && islastnameValid && isbirthdatValid && ishiredateValid;

    }

    public Boolean validateUserName(String username){

        return username.matches("[A-Za-z0-9]+");
    }

    public Boolean validateFirstName(String firstname){

        return firstname.matches("[A-Z][a-z]+");    }

    public Boolean validateLastName(String lastname) {

        return lastname.matches("[A-Z][a-z]+");

    }

    public Boolean validateEmail(String email) {

        return email.matches("[\\w-]+@([\\w-]+\\.)+[\\w-]{2,4}");

    }

    public  Boolean validateBirthdate(String birthdate){

        return birthdate.matches("(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}");

    }

    public  Boolean validateHiredate(String hiredate){

        return hiredate.matches("(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}");

    }

    /**
     * Crearea unui utilizator
     * @param stage Reprezinta o referinta catre fereastra curenta
     * @param username nume de utilizator
     * @param email email
     * @param password parola
     * @param firstname prenume
     * @param lastname nume de familie
     * @param birthdate data nasterii
     * @param hiredate data angajarii
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
     * @param event ActionEvent
     */
    public void update(ActionEvent event){
        String username = usernameField.getText();
        String email = emailField.getText();
        String firstname = firstNameField.getText();
        String lastname = lastNameField.getText();
        Date birthdate = Date.valueOf(birthdateField.getValue());
        Date hiredate = Date.valueOf(hiredateField.getValue());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(validate( username,  firstname,  lastname,  email,  dateFormat.format(birthdate), dateFormat.format(hiredate))){
            updateUser(stage, username, email, selectedUser.getUserId(), firstname, lastname, birthdate,
                    hiredate,selectedUser.getEmployeeId());
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("date invalide");
            alert.setHeaderText("date invalide");
            alert.setContentText("Va rugam verificati datele introduse");
            alert.showAndWait();
        }

    }


    /**
     * actualizarea unui utilizator
     * @param stage Fereastra curenta
     * @param username nume de utilizator
     * @param email email
     * @param userId id de utilizator
     * @param firstname prenume
     * @param lastname nume de familie
     * @param birthdate data nasterii
     * @param hiredate data angajarii
     * @param employeeId id de angajat
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
     * @param user utilizatorul caruia i se doreste actualizarea datelor
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
