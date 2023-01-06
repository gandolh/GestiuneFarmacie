package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.objects.PlatformInstance;
import gestiune.farmacie.utils.EmailOperations;
import gestiune.farmacie.vault.DatabaseCredentials;
import gestiune.farmacie.vault.EmailCredentials;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class ApplicationSettingsController implements Initializable {
    public BorderPane rootBorderPane;
    @FXML
    private TextField appDateFormat;
    @FXML
    private TextField sqlDateFormat;
    @FXML
    private TextField username;
    @FXML
    private TextField emailAdmin;
    @FXML
    private TextField emailSMTP;
    @FXML
    private TextField procPath;
    @FXML
    private PasswordField paroleSMTP;
    @FXML
    private TextField databaseUser;
    @FXML
    private TextField DatabaseServer;
    @FXML
    private TextField DatabasePort;
    @FXML
    private TextField DatabaseName;
    @FXML
    private PasswordField databasePassword;
    @FXML
    private TextField emailTemplatePath;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        emailTemplatePath.setText(EmailOperations.getEmailTemplatePath());
        appDateFormat.setText(((SimpleDateFormat)PlatformInstance.getDateFormat()).toPattern());
        sqlDateFormat.setText(((SimpleDateFormat)PlatformInstance.getDateFormat()).toPattern());
        procPath.setText(PlatformInstance.getProcsPath());
        username.setText(PlatformInstance.getUser().getUsername());
        emailAdmin.setText(PlatformInstance.getUser().getEmail());
        databaseUser.setText(DatabaseCredentials.getUser());
        emailSMTP.setText(EmailCredentials.getSmtpEmail());
        databasePassword.setText(DatabaseCredentials.getPassword());
        DatabaseName.setText(DatabaseCredentials.getDatabaseName());
        DatabasePort.setText(DatabaseCredentials.getPort());
        DatabaseServer.setText(DatabaseCredentials.getServer());
        paroleSMTP.setText(EmailCredentials.getSmtpPassword());
        addMenuBar();
    }

    private void addMenuBar(){
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
    }
}
