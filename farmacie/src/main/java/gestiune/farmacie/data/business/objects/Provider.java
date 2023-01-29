package gestiune.farmacie.data.business.objects;

import java.sql.Date;

/**
 * Clasa de provider
 */
public class Provider {

    private String cui;
    private String adresa;
    private String denumire;
    private int nrRegCom;
    private String telefon;
    private String codPostal;
    private String iban;
    private String email;
    private int codCAEN;
    private Date dataInregistrare;

    /**
     * Da
     * @param cui da
     * @param adresa da
     * @param denumire da
     * @param nrRegCom da
     * @param telefon da
     * @param codPostal da
     * @param iban da
     * @param email da
     * @param codCAEN da
     * @param dataInregistrare da
     */
    public Provider(String cui, String adresa, String denumire, int nrRegCom, String telefon, String codPostal, String iban, String email, int codCAEN, Date dataInregistrare) {
        this.cui = cui;
        this.adresa = adresa;
        this.denumire = denumire;
        this.nrRegCom = nrRegCom;
        this.telefon = telefon;
        this.codPostal = codPostal;
        this.iban = iban;
        this.email = email;
        this.codCAEN = codCAEN;
        this.dataInregistrare = dataInregistrare;
    }

    /**
     * Constructor implicit
     */
    public Provider() {
        this.cui ="";
        this.adresa = "";
        this.denumire = "";
        this.nrRegCom = 21003;
        this.telefon = "";
        this.iban="";
        this.email="";
        this.codCAEN= 2001;
        this.dataInregistrare = new Date(System.currentTimeMillis());
    }

    /**
     * Getter
     * @return ret
     */
    public String getCui() {
        return cui;
    }

    /**
     * Setter
     * @param cui cui
     */
    public void setCui(String cui) {
        this.cui = cui;
    }

    /**
     * Getter
     * @return ret
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Setter
     * @param adresa da
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Denumire
     * @return ret
     */
    public String getDenumire() {
        return denumire;
    }

    /**
     * Setter
     * @param denumire da
     */
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    /**
     * Da
     * @return da
     */
    public int getNrRegCom() {
        return nrRegCom;
    }

    /**
     * Da
     * @param nrRegCom da
     */

    public void setNrRegCom(int nrRegCom) {
        this.nrRegCom = nrRegCom;
    }

    /**
     * Da
     * @return da
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Setter telefon
     * @param telefon da
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * Da
     * @return da
     */
    public String getCodPostal() {
        return codPostal;
    }

    /**
     * DA
     * @param codPostal :(
     */
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    /**
     * Si aici tot java doc
     * @return :)
     */

    public String getIban() {
        return iban;
    }

    /**
     * Setter iban
     * @param iban tot javadoc
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * Da
     * @return ok
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter email
     * @param email da
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Ceva
     * @return return
     */
    public int getCodCAEN() {
        return codCAEN;
    }

    /**
     * Setter
     * @param codCAEN cad
     */
    public void setCodCAEN(int codCAEN) {
        this.codCAEN = codCAEN;
    }

    /**
     * Setter
     * @return da
     */
    public Date getDataInregistrare() {
        return dataInregistrare;
    }

    /**
     * Asta e setter
     * @param dataInregistrare da
     */
    public void setDataInregistrare(Date dataInregistrare) {
        this.dataInregistrare = dataInregistrare;
    }
}
