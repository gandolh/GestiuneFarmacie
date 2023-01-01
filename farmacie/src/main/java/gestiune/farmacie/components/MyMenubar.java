package gestiune.farmacie.components;

import gestiune.farmacie.controllers.RedirectController;
import gestiune.farmacie.data.objects.PlatformInstance;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLOutput;

public class MyMenubar extends MenuBar {
    public MyMenubar() {
        Menu acasa = new Menu("Acasa");
        Menu conturi = new Menu("Conturi");
        MenuItem contulMeu = new MenuItem("Contul meu");
        MenuItem gestionareConturi = new MenuItem("Gestionare conturi");
        Menu setari = new Menu("Setari");
        MenuItem setariDeSistem = new MenuItem("Setari de sistem");
        MenuItem setariDePlatforma = new MenuItem("Setari de platforma");
        Menu ajutor = new Menu("Ajutor");
        MenuItem raportareProbleme = new MenuItem("Raportare probleme");
        MenuItem documentatie = new MenuItem("Documentatie");

        //add my account
        conturi.getItems().add(contulMeu);
        contulMeu.setOnAction(e -> {
            Stage stage = (Stage) this.getScene().getWindow();
            RedirectController redirect = new RedirectController();
            redirect.goToMyAccount(stage);
        });

        //add gestionareUtilizatori doar daca e admin
        if(PlatformInstance.getUser().getUsername().equals("admin")){
            conturi.getItems().add(gestionareConturi);
            gestionareConturi.setOnAction(e -> {
                Stage stage = (Stage) this.getScene().getWindow();
                RedirectController redirect = new RedirectController();
                redirect.goToManageUsers(stage);
            });
        }
        setari.getItems().addAll(setariDePlatforma, setariDeSistem);
        ajutor.getItems().addAll(raportareProbleme, documentatie);
        this.getMenus().addAll(acasa,conturi,setari,ajutor);

        addGoHomeAction(acasa);

    }

    private void addGoHomeAction(Menu acasa) {

        final MenuItem menuItem = new MenuItem();
        acasa.getItems().add(menuItem);
        acasa.addEventHandler(Menu.ON_SHOWN, event -> acasa.hide());
        acasa.addEventHandler(Menu.ON_SHOWING, event -> acasa.fire());
        acasa.setOnShown(e -> {
            Stage stage = (Stage) this.getScene().getWindow();
            RedirectController redirect = new RedirectController();
            redirect.goToHome(stage);
        });
    }


}
