package gestiune.farmacie.data.objects;

import gestiune.farmacie.controllers.RedirectController;
import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.Medicine;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MedicineTableRowData {
    private String id;
    private String pret;
    private String stock;
    private String category;
    private String provider;
    private String Actions;

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

    public String getActions() {
        return Actions;
    }

    public void setActions(SplitMenuButton actions) {
        this.actions = actions;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public void setActions(String actions) {
        Actions = actions;
    }

    private SplitMenuButton actions;
private BorderPane root;
    public MedicineTableRowData(BorderPane rootBorderPane, Medicine medicine) {
        id = medicine.getId();
        pret = String.valueOf(medicine.getPrice());
        stock = String.valueOf(medicine.getStockCount());
        category = medicine.getCategorie().getTitlu();
        provider = medicine.getProviderMed().getDenumire();
        actions = new SplitMenuButton();
        actions.setText("Actiuni");
        MenuItem actualizeazaMenuItem = new MenuItem("actualizeaza");
        MenuItem stergeMenuItem = new MenuItem("sterge");

//        actualizeazaMenuItem.setOnAction(e -> {
//            RedirectController redirect = new RedirectController();
//            redirect.goToUpdateUser((Stage) root.getScene().getWindow(), user);
//        });
//
//        stergeMenuItem.setOnAction(e -> {
//            UserRepository userRepo = new UserRepository();
//
//            boolean isUserDeleted = userRepo.deleteUser(userId, employeeId);
//            if(isUserDeleted){
//                RedirectController redirect = new RedirectController();
//                redirect.goToManageUsers((Stage) root.getScene().getWindow());
//            }
//        });
//        actions.getItems().addAll(actualizeazaMenuItem, stergeMenuItem);
    }

}
