package gestiune.farmacie.data.objects;
import gestiune.farmacie.data.business.objects.User;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;
public class UserTableData {
    private String username;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String hiredate;
    private SplitMenuButton actions;

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getHiredate() {
        return hiredate;
    }

    public SplitMenuButton getActions() {
        return actions;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public void setActions(SplitMenuButton actions) {
        actions = actions;
    }

    public UserTableData(User user) {
        username = user.getUsername();
        firstname = user.getFirstname();
        lastname = user.getLastname();
        birthdate = PlatformInstance.getDateFormat().format(user.getBirthdate());
        hiredate = PlatformInstance.getDateFormat().format(user.getHiredate());
        actions = new SplitMenuButton();
        actions.setText("Actiuni");
        MenuItem actualizeazaMenuItem = new MenuItem("actualizeaza");
        MenuItem stergeMenuItem = new MenuItem("sterge");

//        actualizeazaMenuItem.setOnAction(e->{
//            System.out.println("actualizeaza");
//        });
//
//        stergeMenuItem.setOnAction(e->{
//            System.out.println("sterge");
//        });
        actions.getItems().addAll(actualizeazaMenuItem,stergeMenuItem);

    }
}
