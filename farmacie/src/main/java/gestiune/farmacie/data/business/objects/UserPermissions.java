package gestiune.farmacie.data.business.objects;

/**
 * Clasa pentru structura permisiunilor unui utilizator
 */
public class UserPermissions {
    /**
     * String ce reprezinta o permisiune a unui utilizator. Daca o actiune necesita o anumita valoare
     * iar rolul utilizatorului nu o contine atunci nu este autorizata.
     */
    private String value;
    /**
     * identificatorul unic pentru permisiune
     */
    private String id;

    /**
     * preia un string ce reprezinta permisiunea
     * @return un string ce reprezinta permisiunea
     */
    public String getValue() {
        return value;
    }

    /**
     * seteaza un string ce reprezinta permisiunea
     * @param value un string ce reprezinta permisiunea
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * preia identificatorul unic pentru permisiune
     * @return identificatorul unic pentru permisiune
     */
    public String getId() {
        return id;
    }

    /**
     * seteaza identificatorul unic pentru permisiune
     * @param id identificatorul unic pentru permisiune
     */
    public void setId(String id) {
        this.id = id;
    }
}
