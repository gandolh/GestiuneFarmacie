package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyDialog;
import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.access.DatabaseConnection;
import gestiune.farmacie.data.access.MedicineRepository;
import gestiune.farmacie.data.business.objects.Provider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CreateProviderController  implements Initializable {
    @FXML
    private BorderPane rootBorderPane;


    public CreateProviderController() {
    }


    @FXML
    private Button buttonANAF;

    @FXML
    private Button buttonAdaugare;

    @FXML
    private Button buttonCancel;

    @FXML
    private TextField fieldCUI;

    @FXML
    private TextField fieldDenumire;

    @FXML
    private TextField fieldAdresa;

    @FXML
    private TextField fieldNrReg;

    @FXML
    private TextField fieldCodCAEN;

    @FXML
    private TextField fieldTelefon;

    @FXML
    private TextField fieldCod;

    @FXML
    private TextField fieldIban;

    @FXML
    private DatePicker fieldInreg;

    @FXML
    private TextField fieldEmail;

    public void interogateANAF(ActionEvent event) {
    }

    public void cancel(ActionEvent event) {
        RedirectToProviders(event);

    }
    private void RedirectToProviders(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToFurnizori(stage);
    }

    public void add(ActionEvent event) {
        Provider provider = new Provider();
        provider.setCui(fieldCUI.getText());
        provider.setDenumire(fieldDenumire.getText());
        provider.setAdresa(fieldAdresa.getText());
        provider.setNrRegCom(Integer.parseInt(fieldNrReg.getText()));
        provider.setTelefon(fieldTelefon.getText());
        provider.setCodPostal(fieldCod.getText());
        provider.setIban(fieldIban.getText());
        provider.setDataInregistrare(Date.valueOf(fieldInreg.getValue()));
        provider.setCodCAEN(Integer.parseInt(fieldCodCAEN.getText()));
        provider.setEmail(fieldEmail.getText());
        MedicineRepository medRepo = new MedicineRepository();
        if(buttonAdaugare.getText() == "Actualizeaza"){
            try {
                medRepo.updateProvider(provider);
                new MyDialog("furnizor actualizat cu success","","");
                RedirectToProviders(event);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                medRepo.addProvider(provider);
                new MyDialog("furnizor adaugat cu success","","");
                RedirectToProviders(event);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    private void addMenuBar(){
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addMenuBar();
    }

    public void initializeUpdate(Provider provider) {
        fieldCUI.setDisable(true);
        buttonAdaugare.setText("Actualizeaza");
        fieldCUI.setText(provider.getCui());
        fieldDenumire.setText(provider.getDenumire());
        fieldAdresa.setText(provider.getAdresa());
        fieldNrReg.setText(String.valueOf(provider.getNrRegCom()));
        fieldCodCAEN.setText(String.valueOf(provider.getCodCAEN()));
        fieldTelefon.setText(provider.getTelefon());
        fieldCod.setText(provider.getCodPostal());
        fieldIban.setText(provider.getIban());
        fieldInreg.setValue(provider.getDataInregistrare().toLocalDate());
        fieldEmail.setText(provider.getEmail());
    }
}
