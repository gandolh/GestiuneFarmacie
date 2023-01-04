package gestiune.farmacie.data.business.objects;

import java.util.Date;
import java.util.UUID;

/**
 * Clasa de baza pentru structura datelor unui angajat
 */
public class Employee {
    /**
     * Constructorul cu parametrii
     * @param id id de angajat
     * @param firstname prenume
     * @param lastname nume de familie
     * @param birthdate data nasterii
     */
    public Employee(UUID id, String firstname, String lastname, Date birthdate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    /**
     * Constructorul gol
     */
    public Employee() {
    }

    /**
     * Id-ul de angajat
     */
    private UUID id;
    /**
     * prenume
     */
    private String firstname;
    /**
     * nume de familie
     */
    private String lastname;
    /**
     * Ziua nasterii
     */
    private Date birthdate;

    /**
     * Intoarce id-ul de angajat
     * @return id-ul de angajat
     */
    public UUID getId() {
        return id;
    }

    /**
     * Seteaza id-ul de angajat
     * @param id id de angajat
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Intoarce prenumele
     * @return prenumele
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Seteaza prenumele
     * @param firstname prenumele
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Preia numele de familie
     * @return  numele de familie
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Seteaza numele de familie
     * @param lastname numele de familie
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * preia data nasterii
     * @return data nasterii
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * seteaza data nasterii
     * @param birthdate data nasterii
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
