package gestiune.farmacie.data.business.objects;

import java.util.Date;
import java.util.List;

public class User {
    private List<UserRole> roles;
    private String employeeId;
    private String username;
    private String hashedPassword;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private Date hiredate;

    public User(){
        this("a","a","a","a","a",new Date(),new Date());
    }

    public User(String employeeId, String username, String hashedPassword, String firstname, String lastname,
                Date birthdate, Date hiredate) {
        this.employeeId = employeeId;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.hiredate = hiredate;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
