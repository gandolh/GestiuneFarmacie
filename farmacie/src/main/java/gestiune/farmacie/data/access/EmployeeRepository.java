package gestiune.farmacie.data.access;

import gestiune.farmacie.business.objects.Employee;
import gestiune.farmacie.classes.DatabaseResult;

public class EmployeeRepository {
    public Employee getEmployee(){
        return new Employee();
    }

    public Employee AddEmployee(){
        return new Employee();
    }
    public DatabaseResult UpdateEmployee(){
        return new DatabaseResult();

    }

    public DatabaseResult DeleteEmployee(){
        return new DatabaseResult();
    }

}
