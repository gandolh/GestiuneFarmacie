package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.data.objects.UserTableRowData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller-ul specific gestionarii de utilizatori
 */
public class ManageUsersController implements Initializable {
    @FXML
    public BorderPane rootBorderPane;
    @FXML
    public TableView<UserTableRowData> userTable;
    @FXML
    public TableColumn emailTC;
    @FXML
    public TableColumn usernameTC;
    @FXML
    public TableColumn firstnameTC;
    @FXML
    public TableColumn lastnameTC;
    @FXML
    public TableColumn birthdateTC;
    @FXML
    public TableColumn hiredateTC;
    @FXML
    public TableColumn ActionsTC;
    @FXML
    public Button createUserBtn;

    /**
     * Initializeaza macheta de gestionare a utilizatorilor prin configurarea tabelului de utilizatori
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
        configureColumns();
        getData();
        addMenuBar();
    }


    /**
     * Configurarea tabelului de utilizatori
     */
    private void configureColumns(){
        usernameTC.setCellValueFactory(new PropertyValueFactory<>("username"));
        emailTC.setCellValueFactory(new PropertyValueFactory<>("email"));
        firstnameTC.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastnameTC.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        birthdateTC.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        hiredateTC.setCellValueFactory(new PropertyValueFactory<>("hiredate"));
        ActionsTC.setCellValueFactory(new PropertyValueFactory<>("Actions"));
    }


    /**
     * Preluarea datelor pentru tabelul de utilizatori
     */
    private void getData(){
        UserRepository userRepo = new UserRepository();
        List<User> users = userRepo.getAllUsers();
        List<UserTableRowData> usersTableData = new ArrayList<>();
        for (User user: users) {
            usersTableData.add(new UserTableRowData( rootBorderPane,user));
        }
        userTable.getItems().addAll(usersTableData);
    }

    /**
     * Adaugarea barei de navigatie
     */
    private void addMenuBar(){
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
    }

    /**
     * Redirectionare catre fereastra de creare a unui utilizator
     * @param event
     */
    @FXML
    private void goToCreateUser(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToCreateUser(stage);
    }




}
