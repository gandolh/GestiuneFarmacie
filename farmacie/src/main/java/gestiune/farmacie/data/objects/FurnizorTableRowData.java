package gestiune.farmacie.data.objects;

import gestiune.farmacie.controllers.RedirectController;
import gestiune.farmacie.data.access.MedicineRepository;
import gestiune.farmacie.data.business.objects.Provider;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class FurnizorTableRowData {
private String cui;
private String denumire;
private String adresa;
private String nrRegCom;
private String telefon;
private String codPostal;
private String iban;
private String dataInregistrare;
private String codCAEN;
private String email;
private SplitMenuButton actiuni;
private BorderPane root;

    public SplitMenuButton getActiuni() {
        return actiuni;
    }

    public void setActiuni(SplitMenuButton actiuni) {
        this.actiuni = actiuni;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNrRegCom() {
        return nrRegCom;
    }

    public void setNrRegCom(String nrRegCom) {
        this.nrRegCom = nrRegCom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getDataInregistrare() {
        return dataInregistrare;
    }

    public void setDataInregistrare(String dataInregistrare) {
        this.dataInregistrare = dataInregistrare;
    }

    public String getCodCAEN() {
        return codCAEN;
    }

    public void setCodCAEN(String codCAEN) {
        this.codCAEN = codCAEN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FurnizorTableRowData(BorderPane rootBorderPane, Provider provider) {
        this.root = rootBorderPane;
        cui = provider.getCui();
        denumire= provider.getDenumire();
        adresa = provider.getAdresa();
        nrRegCom = String.valueOf(provider.getNrRegCom());
        telefon = provider.getTelefon();
        codPostal = provider.getCodPostal();
        iban = provider.getIban();
        dataInregistrare = String.valueOf(provider.getDataInregistrare());
        codCAEN = String.valueOf(provider.getCodCAEN());
        email = provider.getEmail();
        actiuni = new SplitMenuButton();
        actiuni.setText("Actiuni");
        MenuItem actualizeazaMenuItem = new MenuItem("actualizeaza");
        MenuItem stergeMenuItem = new MenuItem("sterge");

        actualizeazaMenuItem.setOnAction(e -> {
            RedirectController redirect = new RedirectController();
            redirect.goToUpdateProvider((Stage) root.getScene().getWindow(), provider);
        });

        stergeMenuItem.setOnAction(e -> {
            MedicineRepository medRepo = new MedicineRepository();
            try {
                medRepo.deleteProvider(provider.getCui());
                RedirectController redirect = new RedirectController();
                redirect.goToFurnizori((Stage) root.getScene().getWindow());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });
        actiuni.getItems().addAll(actualizeazaMenuItem, stergeMenuItem);
    }
}
