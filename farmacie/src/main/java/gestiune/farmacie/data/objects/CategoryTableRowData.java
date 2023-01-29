package gestiune.farmacie.data.objects;

import gestiune.farmacie.controllers.RedirectController;
import gestiune.farmacie.data.access.MedicineRepository;
import gestiune.farmacie.data.business.objects.MedicineCategory;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 * o structura a unei linii din tabelul de categorii
 */
public class CategoryTableRowData {
    private String id;
    private String titlu;
    private String descriere;
    private SplitMenuButton actiuni;
    private BorderPane root;

    /**
     * getter pentru radacina
     * @return returneaza
     */

    public BorderPane getRoot() {
        return root;
    }

    /**
     * setter pentru radacina panolui
     * @param root locatie
     */
    public void setRoot(BorderPane root) {
        this.root = root;
    }

    /**
     * getter pentru id
     * @return returneaza
     */
    public String getId() {
        return id;
    }

    /**
     * setter pentru id
     * @param id id
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * preia titlul categoriei
     * @return returneaza
     */
    public String getTitlu() {
        return titlu;
    }


    /**
     * setter pentru titlul categoriei
     * @param titlu titlu
     */
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    /**
     * Getter pentru descriere
     * @return return
     */
    public String getDescriere() {
        return descriere;
    }

    /**
     * setter pentru descrierea categoriei
     * @param descriere descriere categoriei
     */
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    /**
     * Getter pt actiuni
     * @return return
     */
    public SplitMenuButton getActiuni() {
        return actiuni;
    }

    /**
     * setter pentru actiune
     * @param actiuni actiunea
     */
    public void setActiuni(SplitMenuButton actiuni) {
        this.actiuni = actiuni;
    }

    /**
     * Arhitectura pentru tabele
     * @param rootBorderPane panou
     * @param category categorie
     */
    public CategoryTableRowData(BorderPane rootBorderPane, MedicineCategory category) {
        this.root = rootBorderPane;
        id = category.getId();
        titlu = category.getTitlu();
        descriere = category.getDescriere();
        actiuni = new SplitMenuButton();
        actiuni.setText("Actiuni");
        MenuItem actualizeazaMenuItem = new MenuItem("actualizeaza");
        MenuItem stergeMenuItem = new MenuItem("sterge");

        actualizeazaMenuItem.setOnAction(e -> {
            RedirectController redirect = new RedirectController();
            redirect.goToUpdateMedicineCategory((Stage) root.getScene().getWindow(), category);
        });

        stergeMenuItem.setOnAction(e -> {
            MedicineRepository medRepo = new MedicineRepository();

            try {
                boolean isUserDeleted = false;
                medRepo.deleteMedicineCategory(category.getId());
                RedirectController redirect = new RedirectController();
                redirect.goToCategoriiMedicamenteView((Stage) root.getScene().getWindow());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
        actiuni.getItems().addAll(actualizeazaMenuItem, stergeMenuItem);


    }
}
