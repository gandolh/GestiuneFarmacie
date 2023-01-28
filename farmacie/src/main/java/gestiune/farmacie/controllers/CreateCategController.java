package gestiune.farmacie.controllers;

import gestiune.farmacie.data.access.MedicineRepository;
import gestiune.farmacie.data.business.objects.Medicine;
import gestiune.farmacie.data.business.objects.MedicineCategory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Work in progress
 */
public class CreateCategController {
    /**
     * Work in progress
     */
    public CreateCategController() {
    }

    /**
     * Work in progress
     */
    @FXML
    private TextField fieldId;
    /**
     * Work in progress
     */
    @FXML
    private TextField fieldTitlu;
    /**
     * Work in progress
     */
    @FXML
    private TextArea areaDescriere;
    /**
     * Work in progress
     */
    @FXML
    private Button buttonAdd;
    /**
     * Work in progress
     */
    @FXML
    private Button buttonCancel;

    public void cancel(ActionEvent actionEvent) {
    }

    public void addCategory(ActionEvent actionEvent) {

        MedicineCategory mc = new MedicineCategory(fieldId.getText(),fieldTitlu.getText(),areaDescriere.getText());
        MedicineRepository repo = new MedicineRepository();
        repo.addCategory(mc);
    }
}
