package gestiune.farmacie.data.business.objects;

/**
 * Clasa oentru categorii
 */
public class MedicineCategory {

    private String id;
    private String titlu;
    private String descriere;

    /**
     * Constructor implicit
     */
    public MedicineCategory() {
        this.id="";
        this.titlu = "";
        this.descriere="";
    }

    /**
     * Cnstrucotr
     * @param id id
     * @param titlu titlu
     * @param descriere descriere
     */

    public MedicineCategory(String id, String titlu, String descriere) {
        this.id = id;
        this.titlu = titlu;
        this.descriere = descriere;
    }

    /**
     * Getter pt id
     * @return ret
     */
    public String getId() {
        return id;
    }

    /**
     * Setter pt id
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter pt titlu
     * @return ret
     */

    public String getTitlu() {
        return titlu;
    }

    /**
     * Setter titlu
     * @param titlu titlu
     */

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    /**
     * Getter pt descriere
     * @return ret
     */
    public String getDescriere() {
        return descriere;
    }

    /**
     * Setter pt descriere
     * @param descriere desc
     */

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
