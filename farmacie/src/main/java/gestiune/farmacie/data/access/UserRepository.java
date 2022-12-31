package gestiune.farmacie.data.access;

import gestiune.farmacie.data.business.objects.User;
import gestiune.farmacie.data.objects.PlatformInstance;
import gestiune.farmacie.utils.Password;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.Date;
import java.util.List;

import static gestiune.farmacie.data.objects.PlatformInstance.getProcsPath;

public class UserRepository {
    public User getUser(String email, String passwd) {
        if (email == null || email == null)
            return null;
        if(getIsUser(email,passwd) == false )
            return null;
        User user = new User();
        String sql = String.format(
                "select f.id, employeeId, username, firstname, lastname, birthdate, hiredate " +
                        "from FarmacieUser f inner join employee e on employeeId=e.id where username='%s'", email);
        ResultSet set = null;
        try {
            set = DatabaseConnection.executeQuerry(sql);
            if(set.next()){
                user.setUserId(set.getString("id"));
                user.setEmployeeId(set.getString("employeeId"));
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

    public boolean createUser(String username, String password, String firstname, String lastname, Date birthdate, Date hiredate) {
        String hashedPassword = Password.hashPassword(password);
        User user = new User(username,hashedPassword,firstname,lastname,birthdate,hiredate);
        try {
            String employeeId =java.util.UUID.randomUUID().toString();
            String userId = java.util.UUID.randomUUID().toString();
            String formatedBirthDate = PlatformInstance.getSqlDateFormat().format(birthdate);;
            String formatedHiredate = PlatformInstance.getSqlDateFormat().format(hiredate);;
            String sqlscript = new String(Files.readAllBytes(Paths.get(getProcsPath(),"templates","users.sql")));
            DatabaseConnection.executeNonQuerry(sqlscript, new String[]{employeeId,firstname,lastname,formatedBirthDate,
                    formatedHiredate, userId, employeeId, username, hashedPassword});
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        String sql = "";
        return true;
    }

    public Boolean getIsUser(String email, String password) {
        if (email == null || email == null)
            return false;
        if (password == null || password == null)
            return false;
        String sql = String.format("select hashedPassword from FarmacieUser where username='%s'", email);
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

    public List<User> getAllUsers() {
        //TODO: implement fetching from db
        List<User> users = new ArrayList<User>();
        String sql = String.format("select f.id, employeeId, username, firstname, lastname, birthdate, hiredate " +
                        "from FarmacieUser f inner join employee e on employeeId=e.id");
        ResultSet set = null;
        try {
            set = DatabaseConnection.executeQuerry(sql);
            while(set.next()){
                User user = new User();
                user.setUserId(set.getString("id"));
                user.setEmployeeId(set.getString("employeeId"));
                user.setUsername(set.getString("username"));
                user.setFirstname(set.getString("firstname"));
                user.setLastname(set.getString("lastname"));
                user.setBirthdate(set.getDate("birthdate"));
                user.setHiredate(set.getDate("hiredate"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static boolean deleteUser(String userId, String employeeId) {
        String sql = "DELETE FROM [dbo].[FarmacieUser]\n" +
                "      WHERE id= '%s';\n" +
                "DELETE FROM [dbo].[Employee]\n" +
                "      WHERE id= '%s';";
        sql = String.format(sql,userId,employeeId);
        try {
            DatabaseConnection.executeNonQuerry(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
