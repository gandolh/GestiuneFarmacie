package gestiune.farmacie.data.business.objects;

public class MedicineCategory {

    private String id;
    private String titlu;
    private String descriere;

    public MedicineCategory() {
        this.id="";
        this.titlu = "";
        this.descriere="";
    }

    public MedicineCategory(String id, String titlu, String descriere) {
        this.id = id;
        this.titlu = titlu;
        this.descriere = descriere;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
