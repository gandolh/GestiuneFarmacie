package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.data.objects.UserTableData;
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
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManageUsersController implements Initializable {
    @FXML
    public BorderPane rootBorderPane;
    @FXML
    public TableView<UserTableData> userTable;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //configure columns
        usernameTC.setCellValueFactory(new PropertyValueFactory<>("username"));
        firstnameTC.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastnameTC.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        birthdateTC.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        hiredateTC.setCellValueFactory(new PropertyValueFactory<>("hiredate"));
        ActionsTC.setCellValueFactory(new PropertyValueFactory<>("Actions"));
        //get data
        UserRepository userRepo = new UserRepository();
        List<User> users = userRepo.getAllUsers();
        List<UserTableData> usersTableData = new ArrayList<>();
        for (User user: users) {
            usersTableData.add(new UserTableData( rootBorderPane,user));
        }
        userTable.getItems().addAll(usersTableData);

        //add navbar
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
    }

    @FXML
    public void goToCreateUser(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToCreateUser(stage);
    }




}
