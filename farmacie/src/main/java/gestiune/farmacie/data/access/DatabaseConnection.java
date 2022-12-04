package gestiune.farmacie.data.access;
import  com.microsoft.sqlserver.jdbc.*;
import gestiune.farmacie.vault.DatabaseCredentials;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(DatabaseCredentials.getUser());
        ds.setPassword(DatabaseCredentials.getPassword());
        ds.setServerName(DatabaseCredentials.getServer());
        ds.setPortNumber(Integer.parseInt(DatabaseCredentials.getPort()));
        ds.setDatabaseName(DatabaseCredentials.getDatabaseName());
        ds.setTrustServerCertificate(true);
        ds.setEncrypt("true");
        try (Connection con = ds.getConnection()) {

            ResultSet rs = con.prepareCall("SELECT TOP (1000) [id]\n" +
                    "      ,[title]\n" +
                    "      ,[content]\n" +
                    "  FROM [piiiproject].[dbo].[notes]").executeQuery();
            while(rs.next()) {
                System.out.println( rs.getString(2));
            }
            // Execute a stored procedure that returns some data.
//            cstmt.setInt(1, 50);
//            ResultSet rs = cstmt.executeQuery();
//
//            // Iterate through the data in the result set and display it.
//            while (rs.next()) {
//                System.out.println("EMPLOYEE: " + rs.getString("LastName") + ", " + rs.getString("FirstName"));
//                System.out.println("MANAGER: " + rs.getString("ManagerLastName") + ", " + rs.getString("ManagerFirstName"));
//                System.out.println();
//            }
        }
        // Handle any errors that may have occurred.
        catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
