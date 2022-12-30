package gestiune.farmacie.data.access;

import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.data.objects.DatabaseResult;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    public User getUser() {
        return new User();
    }

    public User CreateUser() {
        return new User();
    }

    public Boolean getIsUser(String email, String password) {
        String sql = String.format("select * from FarmacieUser where username=%s and hashedPassword=%s", email, password);
        ResultSet set = null;
        try {
            set = DatabaseConnection.executeQuerry(sql);
            return set.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
