package gestiune.farmacie.data.access;

import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.utils.Password;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    public User getUser() {
        return new User();
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
