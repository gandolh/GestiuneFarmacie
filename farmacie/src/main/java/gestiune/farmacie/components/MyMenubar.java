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


/**
 * Bara de navigatie principala a aplicatiei.  Este folosita ca si componenta inserata in majoritatea
 * scene-urilor
 */
public class MyMenubar extends MenuBar {


    /**
     * Butonul din bara de navigatie pentru Contul meu
     */
    private MenuItem contulMeu;
    /**
     * Meniul din bara de navigatie pentru Conturi
     */
    private Menu accounts;
    /**
     * Butonul din bara de navigatie pentru Gestionarea utilizatorilor
     */
    private MenuItem gestionareConturi;
    /**
     * Butonul din bara de navigatie pentru documentatie
     */
    private MenuItem documentation;
    /**
     * Butonul din bara de navigatie pentru Acasa
     */
    private Menu home;
    /**
     * Butonul din bara de navigatie pentru deconectare
     */
    private Menu logout;
    /**
     * Butonul din bara de navigatie catre raportare problems
     */
    private MenuItem raportareProbleme;

    private MenuItem appSettings;

    private Menu medicamenteMenu;
    private MenuItem medicamente;
    private MenuItem furnizori ;
    private MenuItem categoriiDeMedicamente;

    /**
     * ia path-ul de la javadoc din solutia actuala.
     * @return Calea catre index-ul de la javadoc
     */
    private static Path getJavaDocPath(){
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "farmacie","src","main","javadoc","index.html");
//        System.out.println(filePath.toString());
        return filePath;
    }


    /**
     * Crearea barii de navigatie ca si componenta JavcFx
     */
    public MyMenubar() {
        //Creare elemente menu
        buildMenuBar();
        setOnActions();
    }

    /**
     * Construieste structura barei de navigatie
     */
    private void buildMenuBar(){
        home = new Menu("Acasa");
        accounts = new Menu("Conturi");
        contulMeu = new MenuItem("Contul meu");
        gestionareConturi = new MenuItem("Gestionare conturi");
        Menu settings = new Menu("Setari");
        appSettings = new MenuItem("Setari de aplicatie");
        MenuItem userSettings = new MenuItem("Setari de utilizator");
        Menu help = new Menu("Ajutor");
        raportareProbleme = new MenuItem("Raportare probleme");
        documentation = new MenuItem("Documentatie");
        logout = new Menu("Deconectare");
        medicamenteMenu = new Menu("farmacie");
        medicamente = new MenuItem("medicamente");
        furnizori = new MenuItem("furnizori");
        categoriiDeMedicamente = new MenuItem("categorii de medicamente");
        //adauga contul meu
        accounts.getItems().add(contulMeu);
        medicamenteMenu.getItems().addAll(medicamente,furnizori,categoriiDeMedicamente);
        settings.getItems().addAll(userSettings, appSettings);
        help.getItems().addAll(raportareProbleme, documentation);
        this.getMenus().addAll(home,accounts,medicamenteMenu, settings,help, logout);
    }


    /**
     * Adauga evenimente
     */
    private void setOnActions(){
        //redirectionare catre contul meu la apasare
        contulMeu.setOnAction(e -> {
            Stage stage = (Stage) this.getScene().getWindow();
            RedirectController redirect = new RedirectController();
            redirect.goToMyAccount(stage);
        });

        //adaugare gestionare contul meu, doar daca utilizatorul este administrator
        if(PlatformInstance.getUser().getUsername().equals("admin")){
            accounts.getItems().add(gestionareConturi);
            gestionareConturi.setOnAction(e -> {
                Stage stage = (Stage) this.getScene().getWindow();
                RedirectController redirect = new RedirectController();
                redirect.goToManageUsers(stage);
            });
        }

        //adaugare deschidere browser la apasarea butonului de documentatie
        documentation.setOnAction(event->{
            PlatformInstance.getHostedServices().showDocument(
                    getJavaDocPath().toUri().toString());
        });


        raportareProbleme.setOnAction(event->{
            Stage stage = (Stage) this.getScene().getWindow();
            RedirectController redirect = new RedirectController();
            redirect.goToReportProblem(stage);
        });

        appSettings.setOnAction(event->{
            Stage stage = (Stage) this.getScene().getWindow();
            RedirectController redirect = new RedirectController();
            redirect.goToApplicationSettings(stage);
        });

        addGoHomeAction(home);
        addLogoutAction(logout);
    }


    /**
     * adaugare redirectionare catre acasa la apasarea unui Menu
     * @param home un element de tip Menu
     */
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

    /**
     * adaugare actiune deconectare
     * @param logout un element de tip Menu
     */
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
