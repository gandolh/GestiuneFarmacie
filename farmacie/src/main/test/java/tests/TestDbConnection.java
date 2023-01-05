package tests;

import gestiune.farmacie.data.access.DatabaseConnection;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;
public class TestDbConnection {
    @Test
    public void testConnection(){
        assertTrue(DatabaseConnection.getConnection() !=null);
    }

    /**
     * Daca nu se poate executa un querry din cauza permisiunilor nu
     * este trecut testul
     * @throws SQLException
     */
    @Test
    public void testExecuteQuerry() throws SQLException {
       String sql ="SELECT TOP (1000) [id]\n" +
               "      ,[employeeId]\n" +
               "      ,[username]\n" +
               "      ,[email]\n" +
               "      ,[hashedPassword]\n" +
               "  FROM [piiiproject].[dbo].[FarmacieUser]";
       DatabaseConnection.executeQuerry(sql);

    }

}
