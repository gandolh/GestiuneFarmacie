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
private String stoc;
private String category;
private String provider;
private String Actions;
private SplitMenuButton actions;
private BorderPane root;
    public MedicineTableRowData(BorderPane rootBorderPane, Medicine medicine) {


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
