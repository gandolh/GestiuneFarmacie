package gestiune.farmacie.data.business.objects;

import java.util.List;

/**
 * Clasa pentru rolul unui utilizator
 */
public class UserRole {

    /**
     * Constructorul gol
     */
    public UserRole() {
    }

    /**
     * Constructorul cu parametrii
     * @param id id-ul de identificare unic al rolului
     * @param roleName numele rolului
     * @param permissions permisiuni
     */
    public UserRole(String id, String roleName, List<UserPermissions> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.permissions = permissions;
    }

    /**
     * identificatorul unic pentru rolul curent
     */
    private String id;
    /**
     * Numele rolului
     */
    private String roleName;
    /**
     * O lista de permisiuni pentru rolul curent
     */
    private List<UserPermissions> permissions;

    /**
     * intoarce identificatorul unic pentru rolul curent
     * @return identificatorul unic pentru rolul curent
     */
    public String getId() {
        return id;
    }

    /**
     * seteaza identificatorul unic pentru rolul curent
     * @param id identificatorul unic pentru rolul curent
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * intoarce numele rolului
     * @return numele rolului
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * seteaza numele rolului
     * @param roleName numele rolului
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * intoarce lista de permisiuni
     * @return lista de permisiuni
     */
    public List<UserPermissions> getPermissions() {
        return permissions;
    }

    /**
     * seteaza lista de permisiuni
     * @param permissions lista de permisiuni
     */
    public void setPermissions(List<UserPermissions> permissions) {
        this.permissions = permissions;
    }
}
