package gestiune.farmacie.components;

import gestiune.farmacie.Main;
import gestiune.farmacie.controllers.RedirectController;
import gestiune.farmacie.data.objects.PlatformInstance;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyMenubar extends MenuBar {
    private static Path getJavaDocPath(){
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "farmacie","src","main","javadoc","index.html");
//        System.out.println(filePath.toString());
        return filePath;
    }
    public MyMenubar() {
        Menu home = new Menu("Acasa");
        Menu accounts = new Menu("Conturi");
        MenuItem contulMeu = new MenuItem("Contul meu");
        MenuItem gestionareConturi = new MenuItem("Gestionare conturi");
        Menu settings = new Menu("Setari");
        MenuItem systemSettings = new MenuItem("Setari de sistem");
        MenuItem platformSettings = new MenuItem("Setari de platforma");
        Menu help = new Menu("Ajutor");
        MenuItem raportareProbleme = new MenuItem("Raportare probleme");
        MenuItem documentation = new MenuItem("Documentatie");
        Menu logout = new Menu("Deconectare");

        //add my account
        accounts.getItems().add(contulMeu);
        contulMeu.setOnAction(e -> {
            Stage stage = (Stage) this.getScene().getWindow();
            RedirectController redirect = new RedirectController();
            redirect.goToMyAccount(stage);
        });

        //add gestionareUtilizatori doar daca e admin
        if(PlatformInstance.getUser().getUsername().equals("admin")){
            accounts.getItems().add(gestionareConturi);
            gestionareConturi.setOnAction(e -> {
                Stage stage = (Stage) this.getScene().getWindow();
                RedirectController redirect = new RedirectController();
                redirect.goToManageUsers(stage);
            });
        }
        documentation.setOnAction(event->{
            PlatformInstance.getHostedServices().showDocument(
                    getJavaDocPath().toUri().toString());
        });
        settings.getItems().addAll(platformSettings, systemSettings);
        help.getItems().addAll(raportareProbleme, documentation);
        this.getMenus().addAll(home,accounts,settings,help, logout);

        addGoHomeAction(home);
        addLogoutAction(logout);

    }

    private void addGoHomeAction(Menu home) {

        final MenuItem menuItem = new MenuItem();
        home.getItems().add(menuItem);
        home.addEventHandler(Menu.ON_SHOWN, event -> home.hide());
        home.addEventHandler(Menu.ON_SHOWING, event -> home.fire());
        home.setOnShown(e -> {
            Stage stage = (Stage) this.getScene().getWindow();
            RedirectController redirect = new RedirectController();
            redirect.goToHome(stage);
        });
    }
    private void addLogoutAction(Menu logout) {

        final MenuItem menuItem = new MenuItem();
        logout.getItems().add(menuItem);
        logout.addEventHandler(Menu.ON_SHOWN, event -> logout.hide());
        logout.addEventHandler(Menu.ON_SHOWING, event -> logout.fire());
        logout.setOnShown(e -> {
            Stage stage = (Stage) this.getScene().getWindow();
            RedirectController redirect = new RedirectController();
            redirect.goToAplicationEntry(stage);
        });
    }

}
