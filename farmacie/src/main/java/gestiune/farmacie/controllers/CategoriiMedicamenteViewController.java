package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.access.MedicineRepository;
import gestiune.farmacie.data.business.objects.Medicine;
import gestiune.farmacie.data.business.objects.MedicineCategory;
import gestiune.farmacie.data.objects.CategoryTableRowData;
import gestiune.farmacie.data.objects.MedicineTableRowData;
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
 * Controller pentru pagina de categorii de medicamente
 */
public class CategoriiMedicamenteViewController implements Initializable {
    /**
     * Constructor implicit
     */
    public CategoriiMedicamenteViewController() {
    }

    @FXML
    private BorderPane rootBorderPane;
    @FXML
    private Button AddMedicineBtn;
    @FXML
    private TableView<CategoryTableRowData> categoryTable;
    @FXML
    private TableColumn idTC;
    @FXML
    private TableColumn titluTC;
    @FXML
    private TableColumn descriereTC;
    @FXML
    TableColumn actiuniTC;


    /**
     *
     * @param location locatie
     * @param resources resurse
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureColumns();
        getData();
        addMenuBar();
    }
    private void configureColumns(){
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        titluTC.setCellValueFactory(new PropertyValueFactory<>("titlu"));
        descriereTC.setCellValueFactory(new PropertyValueFactory<>("descriere"));
        actiuniTC.setCellValueFactory(new PropertyValueFactory<>("actiuni"));
    }


    private void getData(){
        MedicineRepository medicineRepo = new MedicineRepository();
        List<MedicineCategory> medicineCategories = medicineRepo.getAllMedicineCategories();
        List<CategoryTableRowData> medicineCategoriesTableData = new ArrayList<>();
        for (MedicineCategory category: medicineCategories) {
            medicineCategoriesTableData.add(new CategoryTableRowData(rootBorderPane, category));
        }
        categoryTable.getItems().addAll(medicineCategoriesTableData);
    }

    /**
     * adauga bara de meniu
     */
    private void addMenuBar(){
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
    }


    /**
     * Redirectioneaza catre pagina de categorie
     * @param event eveniment
     */
    public void goToAddMedicineCategory(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToCreateMedCategory(stage);

    }
}
