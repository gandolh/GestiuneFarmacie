package gestiune.farmacie.data.access;

import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.data.objects.PlatformInstance;
import gestiune.farmacie.utils.Password;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    public User getUser(String email, String passwd) {
        if (email == null || email == null)
            return null;
        if(getIsUser(email,passwd) == false )
            return null;
        User user = new User();
        String sql = String.format(
                "select * from FarmacieUser f inner join employee e on employeeId=e.id where username='%s'", email);
        ResultSet set = null;
        try {
            set = DatabaseConnection.executeQuerry(sql);
            if(set.next()){
                user.setUsername(set.getString("username"));
                user.setFirstname(set.getString("firstname"));
                user.setLastname(set.getString("lastname"));
                user.setBirthdate(set.getDate("birthdate"));
                user.setHiredate(set.getDate("hiredate"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User createUser() {
        return new User();
    }

    public Boolean getIsUser(String email, String password) {
        if (email == null || email == null)
            return false;
        if (password == null || password == null)
            return false;
        String sql = String.format("select * from FarmacieUser where username='%s'", email);
        ResultSet set = null;
        try {
            set = DatabaseConnection.executeQuerry(sql);
            set.next();
            String hashedPassword = set.getString("hashedPassword");
            return  Password.checkPassword(password,hashedPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
