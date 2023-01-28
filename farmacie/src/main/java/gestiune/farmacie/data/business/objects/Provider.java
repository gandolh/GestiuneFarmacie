package gestiune.farmacie.data.business.objects;

import java.sql.Date;

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

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNrRegCom() {
        return nrRegCom;
    }

    public void setNrRegCom(int nrRegCom) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodCAEN() {
        return codCAEN;
    }

    public void setCodCAEN(int codCAEN) {
        this.codCAEN = codCAEN;
    }

    public Date getDataInregistrare() {
        return dataInregistrare;
    }

    public void setDataInregistrare(Date dataInregistrare) {
        this.dataInregistrare = dataInregistrare;
    }
}
