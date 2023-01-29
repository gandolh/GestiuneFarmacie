package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.access.MedicineRepository;
import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.Medicine;
import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.data.objects.MedicineTableRowData;
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

public class MedicamenteViewController implements Initializable {

    public MedicamenteViewController() {
    }
    @FXML
    private BorderPane rootBorderPane;

    @FXML
    private TableView<MedicineTableRowData> userTable;

    @FXML
    private TableColumn idTC;

    @FXML
    private TableColumn pretTC;

    @FXML
    private TableColumn stocTC;

    @FXML
    private TableColumn categoryTC;

    @FXML
    private TableColumn providerTC;
    @FXML
    private TableColumn ActionsTC;

    @FXML
    private Button AddMedicineBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureColumns();
        getData();
        addMenuBar();
    }

    private void configureColumns(){
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        pretTC.setCellValueFactory(new PropertyValueFactory<>("pret"));
        stocTC.setCellValueFactory(new PropertyValueFactory<>("stock"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<>("category"));
        providerTC.setCellValueFactory(new PropertyValueFactory<>("provider"));
        ActionsTC.setCellValueFactory(new PropertyValueFactory<>("Actions"));
    }


    private void getData(){
        MedicineRepository medicineRepo = new MedicineRepository();
        List<Medicine> medicines = medicineRepo.getAllMedicine();
        List<MedicineTableRowData> medicinesTableData = new ArrayList<>();
        for (Medicine medicine: medicines) {
            medicinesTableData.add(new MedicineTableRowData(rootBorderPane, medicine));
        }
        userTable.getItems().addAll(medicinesTableData);
    }


    private void addMenuBar(){
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
    }


    public void goToAddMedicine(ActionEvent event) {
        //TODO
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToCreateMedicine(stage);
    }
}
