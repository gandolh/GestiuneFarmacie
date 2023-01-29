package gestiune.farmacie.controllers;

import gestiune.farmacie.components.MyMenubar;
import gestiune.farmacie.data.access.MedicineRepository;
import gestiune.farmacie.data.business.objects.MedicineCategory;
import gestiune.farmacie.data.business.objects.Provider;
import gestiune.farmacie.data.objects.CategoryTableRowData;
import gestiune.farmacie.data.objects.FurnizorTableRowData;
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
 * Initiaza furnizor medicamente
 */
public class FurnizorMedicamenteViewController implements Initializable {
    /**
     * Consturctro implicit
     */
    public FurnizorMedicamenteViewController() {
    }

    @FXML
    private BorderPane rootBorderPane;
    @FXML
    private Button addFurnizorBtn;
    @FXML
    private TableView<FurnizorTableRowData> furnizorTable;
    @FXML
    private TableColumn cuiTC;
    @FXML
    private TableColumn denumireTC;
    @FXML
    private TableColumn adresaTC;
    @FXML
    private TableColumn nrRegComTC;
    @FXML
    private TableColumn telefonTC;
    @FXML
    private TableColumn codPostalTC;
    @FXML
    private TableColumn ibanTC;
    @FXML
    private TableColumn dataInregistrareTC;
    @FXML
    private TableColumn codCAENTC;
    @FXML
    private TableColumn emailTC;

    /**
     * Adauga un furnizor
     * @param event eveniment
     */
    public void goToAddFurnizor(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RedirectController redirect = new RedirectController();
        redirect.goToAddFurnizor(stage);
    }

    /**
     * Initializeaza pagina
     * @param location locatie
     * @param resources resurse
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureColumns();
        getData();
        addMenuBar();
    }

    /**
     * Configureaza fiecare coloana din tabelul pentru furnizori
     */

    private void configureColumns(){
        cuiTC.setCellValueFactory(new PropertyValueFactory<>("cui"));
        denumireTC.setCellValueFactory(new PropertyValueFactory<>("denumire"));
        adresaTC.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        nrRegComTC.setCellValueFactory(new PropertyValueFactory<>("nrRegCom"));
        telefonTC.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        codPostalTC.setCellValueFactory(new PropertyValueFactory<>("codPostal"));
        ibanTC.setCellValueFactory(new PropertyValueFactory<>("iban"));
        dataInregistrareTC.setCellValueFactory(new PropertyValueFactory<>("dataInregistrare"));
        codCAENTC.setCellValueFactory(new PropertyValueFactory<>("codCAEN"));
        emailTC.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailTC.setCellValueFactory(new PropertyValueFactory<>("actiuni"));
    }

    /**
     * Getter pt data
     */

    private void getData(){
        MedicineRepository medicineRepo = new MedicineRepository();
        List<Provider> providers = medicineRepo.getAllProviders();
        List<FurnizorTableRowData> providersTableData = new ArrayList<>();
        for (Provider provider: providers) {
            providersTableData.add(new FurnizorTableRowData(rootBorderPane, provider));
        }
        furnizorTable.getItems().addAll(providersTableData);
    }


    /**
     * Adauga bara de meniu
     */
    private void addMenuBar(){
        MyMenubar myMenubar = new MyMenubar();
        rootBorderPane.setTop(myMenubar);
    }
}
