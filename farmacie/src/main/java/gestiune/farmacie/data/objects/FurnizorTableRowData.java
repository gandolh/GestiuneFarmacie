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

/**
 * Clasa pentru tabelul de furnizori
 */
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

    /**
     * getter pt actiuni
     * @return return
     */
    public SplitMenuButton getActiuni() {
        return actiuni;
    }

    /**
     * Setter pt actiuni
     * @param actiuni actiuni
     */
    public void setActiuni(SplitMenuButton actiuni) {
        this.actiuni = actiuni;
    }

    /**
     * getter pentru ROOT
     * @return retunr
     */
    public BorderPane getRoot() {
        return root;
    }

    /**
     *Setter pentru Toor
     * @param root root
     */
    public void setRoot(BorderPane root) {
        this.root = root;
    }

    /**
     * getter pt cui
     * @return return
     */
    public String getCui() {
        return cui;
    }

    /**
     * Setter pt cui
     * @param cui cui
     */
    public void setCui(String cui) {
        this.cui = cui;
    }

    /**
     * Getter pt denumire
     * @return retunr
     */

    public String getDenumire() {
        return denumire;
    }

    /**
     * Setter pt denumire
     * @param denumire denumire
     */
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    /**
     * Getter pt adresa
     * @return return
     */

    public String getAdresa() {
        return adresa;
    }

    /**
     * Setter pt adresa
     * @param adresa adresa
     */

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Getter pt Nr de inregistrare in registrul comertului
     * @return return
     */

    public String getNrRegCom() {
        return nrRegCom;
    }

    /**
     * Setter pe tru nr de inregistrare in registrul comertului
     * @param nrRegCom nrregcom
     */
    public void setNrRegCom(String nrRegCom) {
        this.nrRegCom = nrRegCom;
    }

    /**
     * Getter pt telefon
     * @return ret
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * setter [t telefon
     * @param telefon telefon
     */

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * Getter pt cod postal
     * @return ret
     */
    public String getCodPostal() {
        return codPostal;
    }

    /**
     * Setter pt cod postal
     * @param codPostal cod
     */
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    /**
     * Getter pt iban
     * @return return
     */
    public String getIban() {
        return iban;
    }

    /**
     * Setter pt iban
     * @param iban iban
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * getter pt data de inregistrare
     * @return return
     */
    public String getDataInregistrare() {
        return dataInregistrare;
    }

    /**
     * Setter pt data de inregistrare
     * @param dataInregistrare data
     */
    public void setDataInregistrare(String dataInregistrare) {
        this.dataInregistrare = dataInregistrare;
    }

    /**
     * Getter pt cod caen
     * @return return
     */
    public String getCodCAEN() {
        return codCAEN;
    }

    /**
     * Setter pt cod caen
     * @param codCAEN cod
     */
    public void setCodCAEN(String codCAEN) {
        this.codCAEN = codCAEN;
    }

    /**
     * Getter pt email
     * @return retunr
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter pt email
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Arhitectura pentru tabelele
     * @param rootBorderPane ceva
     * @param provider altcv
     */
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
