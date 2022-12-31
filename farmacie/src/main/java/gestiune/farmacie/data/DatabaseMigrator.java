package gestiune.farmacie.data;

import gestiune.farmacie.data.access.DatabaseConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ServiceConfigurationError;

import static gestiune.farmacie.data.objects.PlatformInstance.getProcsPath;
import static gestiune.farmacie.utils.FileOperations.showFilesAtPath;

public class DatabaseMigrator {



    public static void main(String[] args) {
        dropTables();
         createTables();
        seedTables();

        //user.dir property for current directory and user.home for home directory
//        showFilesAtPath(getProcsPath());
    }

    public static void dropTables() {
        try {
            FileInputStream fis = new FileInputStream(Paths.get(getProcsPath(),"databasedrops.sql").toFile());
            Scanner sc = new Scanner(fis);
            String dropSeq;
            while (sc.hasNextLine()) {
//                System.out.println(sc.nextLine());
                dropSeq = sc.nextLine();
                try{
                    DatabaseConnection.executeNonQuerry(dropSeq);
                }catch (Exception e){
//                   e.printStackTrace();
                    System.err.println("Nu s-a putut executa comanda drop: a" + dropSeq);

                }
            }
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void createTables() {
        try {
            String sqlscript = new String(Files.readAllBytes(Paths.get(getProcsPath(),"migrate.sql")));
            DatabaseConnection.executeNonQuerry(sqlscript);

        }catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void seedTables() {
        try {
            String sqlscript = new String(Files.readAllBytes(Paths.get(getProcsPath(),"seedusers.sql")));
            DatabaseConnection.executeNonQuerry(sqlscript);

        }catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
