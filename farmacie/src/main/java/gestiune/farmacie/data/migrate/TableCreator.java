package gestiune.farmacie.data.migrate;

import gestiune.farmacie.data.access.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableCreator {
    public boolean createUsers(Connection con){
        String sql = "SELECT count(*)\n" +
                "FROM [jdbcconnection].[dbo].[recipes]";
        try {
            ResultSet rs = DatabaseConnection.executeQuerry(con,sql);
            rs.next();
            System.out.println(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
//            return false;
        }
        return true;
    }

}
