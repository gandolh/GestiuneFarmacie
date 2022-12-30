package gestiune.farmacie.components;

import gestiune.farmacie.controllers.RedirectController;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MyMenubar extends MenuBar {
    public MyMenubar(){
        Menu conturi = new Menu("Conturi");
        MenuItem contulMeu = new MenuItem("Contul meu");
        MenuItem gestionareConturi = new MenuItem("Gestionare conturi");
        Menu setari = new Menu("Setari");
        MenuItem setariDeSistem = new MenuItem("Setari de sistem");
        MenuItem setariDePlatforma = new MenuItem("Setari de platforma");
        Menu ajutor = new Menu("Ajutor");
        MenuItem raportareProbleme = new MenuItem("Raportare probleme");
        MenuItem documentatie = new MenuItem("Documentatie");
        conturi.getItems().add(contulMeu);
        conturi.getItems().add(gestionareConturi);
        setari.getItems().add(setariDePlatforma);
        setari.getItems().add(setariDeSistem);
        ajutor.getItems().add(raportareProbleme);
        ajutor.getItems().add(documentatie);
        this.getMenus().add(conturi);
        this.getMenus().add(setari);
        this.getMenus().add(ajutor);

        contulMeu.setOnAction(e -> {
            Stage stage = (Stage) this.getScene().getWindow();
            RedirectController redirect = new RedirectController();
                redirect.goToMyAccount(stage);
        });

    }


}
