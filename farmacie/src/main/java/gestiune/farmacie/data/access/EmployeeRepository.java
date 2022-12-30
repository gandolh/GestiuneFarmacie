package gestiune.farmacie.data.access;

import gestiune.farmacie.data.business.objects.Employee;
import gestiune.farmacie.data.objects.DatabaseResult;

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
