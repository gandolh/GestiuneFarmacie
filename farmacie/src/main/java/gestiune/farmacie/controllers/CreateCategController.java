package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyDialog;
import gestiune.farmacie.data.access.MedicineRepository;
import gestiune.farmacie.data.business.objects.MedicineCategory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * Work in progress
 */
public class CreateCategController implements Initializable {

    public BorderPane rootBorderPane;

    public CreateCategController() {
    }


    @FXML
    private TextField fieldId;
    @FXML
    private TextField fieldTitlu;

    @FXML
    private TextArea areaDescriere;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonCancel;


    private void redirectToCategories(ActionEvent actionEvent){
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToCategoriiMedicamenteView(stage);
    }
    
    public void cancel(ActionEvent actionEvent) {
        redirectToCategories(actionEvent);
    }
    public void addCategory(ActionEvent actionEvent) {
        if(buttonAdd.getText().equals("actualizeaza")){
            MedicineCategory mc = new MedicineCategory(fieldId.getText(),fieldTitlu.getText(),areaDescriere.getText());
            MedicineRepository repo = new MedicineRepository();
            try {
                repo.updateCategory(mc);
                new MyDialog("S-a actualizat categoria","S-a actualizat categoria",
                        "S-a actualizat categoria");
                redirectToCategories(actionEvent);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            MedicineCategory mc = new MedicineCategory(fieldId.getText(),fieldTitlu.getText(),areaDescriere.getText());
            MedicineRepository repo = new MedicineRepository();
            try {
                repo.addCategory(mc);
                new MyDialog("S-a creat noua categorie","S-a creat noua categorie",
                        "S-a creat noua categorie");
                redirectToCategories(actionEvent);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fieldId.setText(UUID.randomUUID().toString());
    }

    public void initializeUpdate(MedicineCategory category) {
        fieldId.setText(category.getId());
        fieldTitlu.setText(category.getTitlu());
        areaDescriere.setText(category.getDescriere());
        buttonAdd.setText("actualizeaza");

    }
}
