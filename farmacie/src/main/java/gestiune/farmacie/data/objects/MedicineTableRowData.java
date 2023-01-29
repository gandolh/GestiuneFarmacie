package gestiune.farmacie.data.objects;

import gestiune.farmacie.controllers.RedirectController;
import gestiune.farmacie.data.access.MedicineRepository;
import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.Medicine;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MedicineTableRowData {
    private String id;
    private String pret;
    private String stock;
    private String category;
    private String provider;
    private SplitMenuButton Actions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public SplitMenuButton getActions() {
        return Actions;
    }

    public void setActions(SplitMenuButton actions) {
        Actions = actions;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }



private BorderPane root;
    public MedicineTableRowData(BorderPane rootBorderPane, Medicine medicine) {
        this.root = rootBorderPane;
        id = medicine.getId();
        pret = String.valueOf(medicine.getPrice());
        stock = String.valueOf(medicine.getStockCount());
        category = medicine.getCategorie().getTitlu();
        provider = medicine.getProviderMed().getDenumire();
        Actions = new SplitMenuButton();
        Actions.setText("Actiuni");
        MenuItem actualizeazaMenuItem = new MenuItem("actualizeaza");
        MenuItem stergeMenuItem = new MenuItem("sterge");

        actualizeazaMenuItem.setOnAction(e -> {
            RedirectController redirect = new RedirectController();
            redirect.goToUpdateMedicine((Stage) root.getScene().getWindow(), medicine);
        });

        stergeMenuItem.setOnAction(e -> {
            MedicineRepository medRepo = new MedicineRepository();

            try {
                medRepo.deleteMedicine(medicine.getId());
                RedirectController redirect = new RedirectController();
                redirect.goToManageUsers((Stage) root.getScene().getWindow());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        Actions.getItems().addAll(actualizeazaMenuItem, stergeMenuItem);
    }

}
