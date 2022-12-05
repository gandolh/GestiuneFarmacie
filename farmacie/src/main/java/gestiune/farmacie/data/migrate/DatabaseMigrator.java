package gestiune.farmacie.data.migrate;

import gestiune.farmacie.data.access.DatabaseConnection;

import java.sql.Connection;

public class DatabaseMigrator {
    public static void main(String[] args) {
        Connection con = DatabaseConnection.getConnection();

    }
}
