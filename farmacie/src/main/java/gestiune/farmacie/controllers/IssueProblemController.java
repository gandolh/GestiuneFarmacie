package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.utils.EmailOperations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class IssueProblemController implements Initializable {
    @FXML
    private BorderPane rootBorderPane;
    @FXML
    private TextField subjectField;
    @FXML
    private TextArea corpTextArea;

    public void trimiteProblema(ActionEvent event) {
        sendSuportMail(subjectField.getText(),  corpTextArea.getText());
    }

    public void sendSuportMail(String subject, String corp){
        UserRepository userRepo = new UserRepository();
        String adminEmail = userRepo.getAdminEmail();
        EmailOperations.send(adminEmail, corp, subject );
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Email de suport trimis");
        alert.setHeaderText("Email de suport trimis");
        alert.setContentText("Problema dumneavoastra a fost trimis cu succes catre un administrator");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addMenuBar();
    }
    private void addMenuBar(){
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
    }

}
