package gestiune.farmacie.data.objects;

import gestiune.farmacie.controllers.RedirectController;
import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Clasa de mapare folosita pentru tabelul de gestiune a utilizatorilor
 */
public class UserTableRowData {
    /**
     * id de utilizator
     */
    private String userId;
    /**
     * id de angajat
     */
    private String employeeId;
    /**
     * nume de utilizator
     */
    private String username;
    /**
     * email
     */
    private String email;
    /**
     * prenume
     */
    private String firstname;
    /**
     * nume de familie
     */
    private String lastname;
    /**
     * data nasterii
     */
    private String birthdate;
    /**
     * data angajarii
     */
    private String hiredate;
    /**
     * actiuni : actualizare si stergere
     */
    private SplitMenuButton actions;
    /**
     * layout-ul principal al ferestrei
     */
    private BorderPane root;


    /**
     * intoarce layout-ul principal al ferestrei
     */
    public BorderPane getBorderPane() {
        return root;
    }

    /**
     *  intoarce id-ul de utilizator
     */
    public String getUserId() {
        return userId;
    }
    /**
     * intoarce id-ul de angajat
     */
    public String getEmployeeId() {
        return employeeId;
    }
    /**
     * intoarce numele de utilizator
     */
    public String getUsername() {
        return username;
    }
    /**
     * intoarce prenumele
     */
    public String getFirstname() {
        return firstname;
    }
    /**
     * intoarce numele de familie
     */
    public String getLastname() {
        return lastname;
    }
    /**
     * intoarce data nasterii
     */
    public String getBirthdate() {
        return birthdate;
    }
    /**
     * intoarce data angajarii
     */
    public String getHiredate() {
        return hiredate;
    }
    /**
     * intoarce referinta asupra butoanelor de actiune
     */
    public SplitMenuButton getActions() {
        return actions;
    }
    /**
     * intoarce email-ul
     */
    public String getEmail() {
        return email;
    }
    /**
     * seteaza id-ul de utilizator
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**
     * seteaza id-ul de angajat
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    /**
     * seteaza numele de utilizator
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * seteaza prenumele
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    /**
     * seteaza numele de familie
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /**
     * seteaza data nasterii
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    /**
     * seteaza data angajarii
     */
    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }
    /**
     * seteaza actiunile
     */
    public void setActions(SplitMenuButton actions) {
        actions = actions;
    }
    /**
     * seteaza layout-ul principal
     */
    public void setBorderPane(BorderPane root) {
        this.root = root;
    }
    /**
     * seteaza email-ul
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Initializarea datelor, adaugarea butoanelor de stergere si actualizare + adaugarea functionalitatilor
     * @param root panel-ul pe care se afla tabelul
     * @param user  Datele de utilizator pentru linia de tabel curenta
     */
    public UserTableRowData(BorderPane root, User user) {
        userId = user.getUserId();
        employeeId = user.getEmployeeId();
        username = user.getUsername();
        email = user.getEmail();
        firstname = user.getFirstname();
        lastname = user.getLastname();
        birthdate = PlatformInstance.getDateFormat().format(user.getBirthdate());
        hiredate = PlatformInstance.getDateFormat().format(user.getHiredate());
        actions = new SplitMenuButton();
        actions.setText("Actiuni");
        MenuItem actualizeazaMenuItem = new MenuItem("actualizeaza");
        MenuItem stergeMenuItem = new MenuItem("sterge");

        actualizeazaMenuItem.setOnAction(e -> {
            RedirectController redirect = new RedirectController();
            redirect.goToUpdateUser((Stage) root.getScene().getWindow(), user);
        });

        stergeMenuItem.setOnAction(e -> {
            UserRepository userRepo = new UserRepository();

            boolean isUserDeleted = userRepo.deleteUser(userId, employeeId);
            if(isUserDeleted){
                RedirectController redirect = new RedirectController();
                redirect.goToManageUsers((Stage) root.getScene().getWindow());
            }
        });
        actions.getItems().addAll(actualizeazaMenuItem, stergeMenuItem);

    }
}
