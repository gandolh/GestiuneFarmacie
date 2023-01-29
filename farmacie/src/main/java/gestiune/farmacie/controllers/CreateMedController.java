package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyDialog;
import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.access.MedicineRepository;
import gestiune.farmacie.data.business.objects.Medicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Work in progress
 */
public class CreateMedController implements Initializable {
    public BorderPane rootBorderPane;


    public CreateMedController() {
    }


    @FXML
    private ComboBox<String> comboBoxMed;

    @FXML
    private ComboBox<String> comboBoxFurnizor;

    @FXML
    private TextField textPret;

    @FXML
    private TextField textStoc;

    @FXML
    private TextField textComentarii;

    @FXML
    private Button buttonAdd;

    @FXML
    private  Button buttonCancel;

    @FXML
    private Button buttonPlus;

    @FXML
    private Button buttonMinus;

    private void addMenuBar(){
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
    }


    public void decreaseStoc(ActionEvent event) {
        if(Integer.parseInt(textStoc.getText()) > 0)
            textStoc.setText(String.valueOf(Integer.parseInt(textStoc.getText())-1));

    }

    public void increaseStoc(ActionEvent event) {
        textStoc.setText(String.valueOf(Integer.parseInt(textStoc.getText())+1));
    }

    public void cancel(ActionEvent event) {
        redirectToMedicines(event);
    }

    public void add(ActionEvent event) {
        Medicine med = new Medicine();
        med.setId(UUID.randomUUID().toString());
        med.setStockCount(Integer.parseInt(textStoc.getText()));
        med.setComentarii(textComentarii.getText());
        med.setPrice(Double.parseDouble(textPret.getText()));
        MedicineRepository medRepo = new MedicineRepository();
        med.setCategorie( medRepo.getMedicineCategory(comboBoxMed.getValue()));
        med.setProviderMed( medRepo.getProvider(comboBoxFurnizor.getValue()));



        if(buttonAdd.getText() == "Actualizeaza"){
            try {
                medRepo.updateMedicine(med);
                new MyDialog("furnizor actualizat cu success","","");
                redirectToMedicines(event);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else{
            try {
                medRepo.addMedicine(med);
                new MyDialog("furnizor adaugat cu success","","");
                redirectToMedicines(event);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textStoc.setText("0");
        MedicineRepository medRepo = new MedicineRepository();
        List<String> medicineCategories = medRepo.getAllMedicineCategories().stream().map(el -> el.getTitlu()).collect(Collectors.toList());
        List<String> providers = medRepo.getAllProviders().stream().map(el -> el.getDenumire()).collect(Collectors.toList());
        addMenuBar();
        ObservableList<String> obMedicineCategories = FXCollections.observableList(medicineCategories);
        ObservableList<String> obProviders = FXCollections.observableList(providers);
        comboBoxMed.getItems().clear();
        comboBoxMed.setItems(obMedicineCategories);
        comboBoxMed.getSelectionModel().selectFirst();

        comboBoxFurnizor.getItems().clear();
        comboBoxFurnizor.setItems(obProviders);
        comboBoxFurnizor.getSelectionModel().selectFirst();
    }


    private void redirectToMedicines(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToMedicamenteView(stage);
    }

    public void initializeUpdate(Medicine medicine) {
        buttonAdd.setText("Actualizeaza");
        comboBoxMed.setValue(medicine.getCategorie().getTitlu());
        comboBoxFurnizor.setValue(medicine.getProviderMed().getDenumire());
        textPret.setText(String.valueOf(medicine.getPrice()));
        textStoc.setText(String.valueOf(medicine.getStockCount()));
        textComentarii.setText(String.valueOf(medicine.getComentarii()));

    }
}
