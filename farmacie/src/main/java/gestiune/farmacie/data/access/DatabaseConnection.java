package gestiune.farmacie.data.access;
import  com.microsoft.sqlserver.jdbc.*;
import gestiune.farmacie.vault.DatabaseCredentials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection con;
    public static Connection getConnection(){
        if(con == null){
            try {
                 con = getSQLDataSource().getConnection();
            } catch (SQLServerException ex) {
                throw new RuntimeException(ex);
            }
        }
        return con;
    }

    private static SQLServerDataSource getSQLDataSource(){
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(DatabaseCredentials.getUser());
        ds.setPassword(DatabaseCredentials.getPassword());
        ds.setServerName(DatabaseCredentials.getServer());
        ds.setPortNumber(Integer.parseInt(DatabaseCredentials.getPort()));
        ds.setDatabaseName(DatabaseCredentials.getDatabaseName());
        ds.setTrustServerCertificate(true);
        ds.setEncrypt("true");
        return ds;
    }

    public static ResultSet executeQuerry(String sql) throws SQLException {
       return getConnection().prepareCall(sql).executeQuery();
    }
    public static boolean executeNonQuerry(String sql) throws SQLException {
        return getConnection().prepareCall(sql).execute();
    }

    public static boolean executeNonQuerry(String sql, String[] params) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        for (int i=0;i<params.length;i++ ){
            stmt.setString(i+1,params[i]);
        }
        return stmt.execute();
    }

}
