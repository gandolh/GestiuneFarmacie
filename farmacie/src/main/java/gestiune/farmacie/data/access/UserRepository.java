package gestiune.farmacie.data.access;

import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.data.objects.DatabaseResult;

public class UserRepository {
    public User getUser(){
        return new User();
    }

    public User AddUser(){
        return new User();
    }
    public DatabaseResult UpdateUser(){
        return new DatabaseResult();

    }

    public DatabaseResult DeleteUser(){
        return new DatabaseResult();
    }
    
}
