package gestiune.farmacie.data.access;
import  com.microsoft.sqlserver.jdbc.*;
import gestiune.farmacie.vault.DatabaseCredentials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clasa utilizata pentru realizarea comunicarii cu baza de date
 */
public class DatabaseConnection {

    /**
     * Conexiunea sql ce se mentine vie pe parcursul aplicatiei
     */
    private static Connection con;

    /**
     *  daca conexiunea nu a fost inca initializata, atunci este initializata in acel moment si se va intoarce
     *  in orice caz o referinta la aceasta
     * @return conexiunea cu baza de date
     */
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

    /**
     * Se configureaza dataSource-ul pentru a putea initializa conexiunea sql.
     * @return un datasource ce reprezinta configuratia de conectare la sql
     */
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

    /**
     * Executa un querry (select) SQL
     * @param sql un string ce reprezinta un querry sql
     * @return Rezultat-ul query-ului
     * @throws SQLException
     */
    public static ResultSet executeQuerry(String sql) throws SQLException {
       return getConnection().prepareCall(sql).executeQuery();
    }

    /**
     * Executa un nonQuerry ( insert, delete, update)
     * @param sql un nonQuerry sub forma de string
     * @return "true if the first result is a ResultSet object; false if the first result
     * is an update count or there is no result"
     * @throws SQLException
     */
    public static boolean executeNonQuerry(String sql) throws SQLException {
        return getConnection().prepareCall(sql).execute();
    }

    /**
     * Executa un nonQuerry ( insert, delete, update), la care se va inlocui caracterul "?" in ordine cu cate un
     * element din params.
     * @param sql un string ce reprezinta un nonquerry in sql.
     * @param params un array de string-uri ce va fi folosit pentru a inlocui caracterul "?" in string-ul sql.
     * @return "true if the first result is a ResultSet object; false if the first result
     * is an update count or there is no result"
     * @throws SQLException
     */
    public static boolean executeNonQuerry(String sql, String[] params) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        for (int i=0;i<params.length;i++ ){
            stmt.setString(i+1,params[i]);
        }
        return stmt.execute();
    }

}
