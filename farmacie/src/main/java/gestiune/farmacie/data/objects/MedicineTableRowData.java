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

/**
 * Clasa pentru medicamente
 */
public class MedicineTableRowData {
    private String id;
    private String pret;
    private String stock;
    private String category;
    private String provider;
    private SplitMenuButton Actions;

    /**
     * Getter pt id
     * @return ret
     */

    public String getId() {
        return id;
    }

    /**
     * Setter pt id
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter pt pret
     * @return ret
     */
    public String getPret() {
        return pret;
    }

    /**
     * Setter pt pret
     * @param pret pret
     */
    public void setPret(String pret) {
        this.pret = pret;
    }

    /**
     * Getter pt stoc
     * @return ret
     */
    public String getStock() {
        return stock;
    }

    /**
     * Setter pt stoc
     * @param stock stoc
     */
    public void setStock(String stock) {
        this.stock = stock;
    }

    /**
     * Getter pt categorie
     * @return ret
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter pt categorie
     * @param category categ
     */

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter pt provider
     * @return ret
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Setter pt provider
     * @param provider provider
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * Clasa pt MenuBar
     * @return ret
     */
    public SplitMenuButton getActions() {
        return Actions;
    }


    /**
     * Actiunea
     * @param actions actiune
     */
    public void setActions(SplitMenuButton actions) {
        Actions = actions;
    }

    /**
     * Getter pt root
     * @return ret
     */
    public BorderPane getRoot() {
        return root;
    }

    /**
     * Setter pt root
     * @param root root
     */

    public void setRoot(BorderPane root) {
        this.root = root;
    }



    private BorderPane root;

    /**
     * Tabel arhitectural al row data pe tabel in coloana pe linie
     * @param rootBorderPane root
     * @param medicine med
     */
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
