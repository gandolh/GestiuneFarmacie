package gestiune.farmacie.data.objects;

import gestiune.farmacie.controllers.RedirectController;
import gestiune.farmacie.data.access.MedicineRepository;
import gestiune.farmacie.data.business.objects.MedicineCategory;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class CategoryTableRowData {
    private String id;
    private String titlu;
    private String descriere;
    private SplitMenuButton actiuni;
    private BorderPane root;


    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public SplitMenuButton getActiuni() {
        return actiuni;
    }

    public void setActiuni(SplitMenuButton actiuni) {
        this.actiuni = actiuni;
    }

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
