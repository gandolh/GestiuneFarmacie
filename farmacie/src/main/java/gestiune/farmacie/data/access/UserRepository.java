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
    public User getUser(String username, String passwd) {
        if (username == null || username == null)
            return null;
        if(getIsUser(username,passwd) == false )
            return null;
        User user = new User();
        String sql = String.format(
                "select f.id, employeeId, username, email, firstname, lastname, birthdate, hiredate " +
                        "from FarmacieUser f inner join employee e on employeeId=e.id where username='%s'", username);
        ResultSet set = null;
        try {
            set = DatabaseConnection.executeQuerry(sql);
            if(set.next()){
                user.setUserId(set.getString("id"));
                user.setEmployeeId(set.getString("employeeId"));
                user.setUsername(set.getString("username"));
                user.setEmail(set.getString("email"));
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

    public boolean createUser(String username,String email, String password, String firstname, String lastname, Date birthdate, Date hiredate) {
        String hashedPassword = Password.hashPassword(password);
        User user = new User(username,hashedPassword,firstname,lastname,birthdate,hiredate);
        try {
            String employeeId =java.util.UUID.randomUUID().toString();
            String userId = java.util.UUID.randomUUID().toString();
            String formatedBirthDate = PlatformInstance.getSqlDateFormat().format(birthdate);
            String formatedHiredate = PlatformInstance.getSqlDateFormat().format(hiredate);
            String sqlscript = new String(Files.readAllBytes(Paths.get(getProcsPath(),"templates","insertUser.sql")));
            DatabaseConnection.executeNonQuerry(sqlscript, new String[]{employeeId,firstname,lastname,formatedBirthDate,
                    formatedHiredate, userId, employeeId, username, email, hashedPassword});
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Boolean getIsUser(String username, String password) {
        if (username == null || username == null)
            return false;
        if (password == null || password == null)
            return false;
        String sql = String.format("select hashedPassword from FarmacieUser where username='%s'", username);
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
        List<User> users = new ArrayList<User>();
        String sql = String.format("select f.id, employeeId, username, email, firstname, lastname, birthdate, hiredate " +
                        "from FarmacieUser f inner join employee e on employeeId=e.id");
        ResultSet set = null;
        try {
            set = DatabaseConnection.executeQuerry(sql);
            while(set.next()){
                User user = new User();
                user.setUserId(set.getString("id"));
                user.setEmployeeId(set.getString("employeeId"));
                user.setUsername(set.getString("username"));
                user.setEmail(set.getString("email"));
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

    public boolean updateUser(String username, String email, String userId, String firstname, String lastname, Date birthdate, Date hiredate, String employeeId) {
        try {
            String formatedBirthDate = PlatformInstance.getSqlDateFormat().format(birthdate);
            String formatedHiredate = PlatformInstance.getSqlDateFormat().format(hiredate);
            String sql = new String(Files.readAllBytes(Paths.get(getProcsPath(),"templates","updateUser.sql")));
            DatabaseConnection.executeNonQuerry(sql, new String[]{username, email, userId,firstname,lastname,formatedBirthDate,formatedHiredate,employeeId});
        }catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  true;
    }
    public static boolean changePassword(String userId, String newPassword) {
        System.out.println(newPassword);
        String sql = "UPDATE [dbo].[FarmacieUser]\n" +
                "   SET [hashedPassword] = '%s'\n" +
                " WHERE  id= '%s'";
        sql = String.format(sql,Password.hashPassword(newPassword),userId);
        try {
            DatabaseConnection.executeNonQuerry(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
