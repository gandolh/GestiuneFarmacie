package gestiune.farmacie.data.business.objects;

/**
 * Clasa pentru structura permisiunilor unui utilizator
 */
public class UserPermissions {
    private String value;
    private String id;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
