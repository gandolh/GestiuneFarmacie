package gestiune.farmacie.data.business.objects;

import java.sql.Date;
import java.util.List;

/**
 * Clasa pentru structura unui utilizator de aplicatie
 */
public class User {
    /**
     * Lista de roluri ale unui utilizator
     */
    private List<UserRole> roles;
    /**
     * Id-ul de utilizator
     */
    private String userId;
    /**
     * id-ul de angajat
     */
    private String employeeId;
    /**
     * Numele de utilizator
     */
    private String username;
    /**
     * email-ul
     */
    private String email;
    /**
     * parola hashuita cu ajutorul algoritmului BCrypt si salt.
     */
    private String hashedPassword;
    /**
     * prenumele
     */
    private String firstname;
    /**
     * numele de familie
     */
    private String lastname;
    /**
     * data nasterii -- cu sql.date
     */
    private Date birthdate;
    /**
     * data angajarii -- cu sql.date
     */
    private Date hiredate;

    /**
     * Constructorul gol folosit in cazul construirii unui set de date de test
     */
    public User() {
        this("a","a", "a", "a", "a", "a",
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
    }

    /**
     * Constructorul complet
     * @param userId id de utilizator
     * @param employeeId id de angajat
     * @param username nume de utilizator
     * @param hashedPassword parola hashuita
     * @param firstname prenume
     * @param lastname nume de familie
     * @param birthdate data nasterii
     * @param hiredate data angajarii
     */
    public User(String userId, String employeeId, String username, String hashedPassword, String firstname,
                String lastname, Date birthdate, Date hiredate) {
        this.userId = userId;
        this.employeeId = employeeId;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.hiredate = hiredate;
    }

    /**
     * Constructorul fara id-uri in cazul crearii acestora la nivelul bazei de date
     * @param username nume de utilizator
     * @param hashedPassword parola hashuita
     * @param firstname prenume
     * @param lastname nume de familie
     * @param birthdate data nasterii
     * @param hiredate data angajarii
     */
    public User(String username, String hashedPassword, String firstname, String lastname, Date birthdate, Date hiredate) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.hiredate = hiredate;
    }

    /**
     * Seteaza prenumele
     * @param firstname prenumele
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Seteaza numele de familie
     * @param lastname numele de familie
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Seteaza data nasterii
     * @param birthdate  data nasterii
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Seteaza data angajarii
     * @param hiredate data angajarii
     */
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * Seteaza email-ul
     * @param email email-ul
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Preia prenumele
     * @return prenumele
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Preia numele de familie
     * @return numele de familie
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Preia data nasterii
     * @return data nasterii
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * Preia data angajarii
     * @return data angajarii
     */
    public Date getHiredate() {
        return hiredate;
    }

    /**
     * Preia id-ul de utilizator
     * @return id-ul de utilizator
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Preia email-ul
     * @return email-ul
     */
    public String getEmail() {
        return email;
    }


    /**
     * Preia rolurile
     * @return rolurile
     */
    public List<UserRole> getRoles() {
        return roles;
    }

    /**
     * seteaza rolurile
     * @param roles rolurile
     */
    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    /**
     * Preia id-ul de angajat
     * @return id-ul de angajat
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Seteaza id-ul de angajat
     * @param employeeId id-ul de angajat
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Preia numele de utilizator
     * @return numele de utilizator
     */
    public String getUsername() {
        return username;
    }

    /**
     * seteaza numele de utilizator
     * @param username numele de utilizator
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Preia parola hashuita
     * @return parola hashuita
     */
    public String getHashedPassword() {
        return hashedPassword;
    }

    /**
     * seteaza parola hashuita
     * @param hashedPassword  parola hashuita
     */
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }


    /**
     * seteaza id-ul de utilizator
     * @param userId  id-ul de utilizator
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
