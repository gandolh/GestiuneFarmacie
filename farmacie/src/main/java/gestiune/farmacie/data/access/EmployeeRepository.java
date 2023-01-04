package gestiune.farmacie.data.access;

import gestiune.farmacie.data.business.objects.Employee;
import gestiune.farmacie.data.objects.DatabaseResult;


/**
 * Gestioneaza datele corespunzatoare angajatilor
 * WIP
 */
public class EmployeeRepository {

    /**
     * Gestioneaza datele corespunzatoare angajatilor
     */
    public EmployeeRepository() {
    }

    /**
     * Metoda de  testare a clasei folosind metodele interne
     * @param args args
     */
    public static void main(String[] args) {
        EmployeeRepository repo = new EmployeeRepository();
        System.out.println(repo.getEmployee());
        System.out.println(repo.addEmployee());
        System.out.println(repo.UpdateEmployee());
        System.out.println(repo.DeleteEmployee());
    }
    /**
     * WIP
     * @return WIP
     */
    public Employee getEmployee(){
        return new Employee();
    }
    /**
     * WIP
     * @return WIP
     */
    public Employee addEmployee(){
        return new Employee();
    }
    /**
     * WIP
     * @return WIP
     */
    public DatabaseResult UpdateEmployee(){
        return new DatabaseResult();

    }
    /**
     * WIP
     * @return WIP
     */
    public DatabaseResult DeleteEmployee(){
        return new DatabaseResult();
    }

}
