package gestiune.farmacie.data.objects;

import gestiune.farmacie.data.business.objects.User;
import javafx.application.HostServices;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * O instanta singletone ce mentine date statice necesare functionarii optime intregii aplicatii
 */
public class PlatformInstance {
    /**
     * Clasa nu ar trebui initializata
     */
    private PlatformInstance() {
    }

    /**
     * utilizatorul de sistem curent
     */
    private static User user;
    /**
     * format-ul de data afisat in aplicatie
     */
    private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    /**
     * Formatul de date necesar server-ului de SQL pentru conversia la DateTime a unui string
     */
    private static DateFormat sqlDateFormat = new SimpleDateFormat("dd-MM-yy");

    /**
     * Referinta asupra procesului curent de javafx
     */
    private static HostServices hostedServices;

    /**
     * intoarce referinta asupra procesului curent de javafx
     * @return referinta asupra procesului curent de javafx
     */
    public static HostServices getHostedServices() {
        return hostedServices;
    }

    /**
     * seteaza referinta asupra procesului curent de javafx in Main.java
     * @param hostedServices referinta asupra procesului curent de javafx
     */
    public static void setHostedServices(HostServices hostedServices) {
        PlatformInstance.hostedServices = hostedServices;
    }

    /**
     * intoarce format-ul de data afisat in aplicatie
     * @return format-ul de data afisat in aplicatie
     */
    public static DateFormat getDateFormat() {
        return dateFormat;
    }

    /**
     * setaza format-ul de data afisat in aplicatie
     * @param dateFormat format-ul de data afisat in aplicatie
     */
    public static void setDateFormat(DateFormat dateFormat) {
        PlatformInstance.dateFormat = dateFormat;
    }

    /**
     * intoarce formatul de date necesar server-ului de SQL pentru conversia la DateTime a unui string
     * @return formatul de date necesar server-ului de SQL pentru conversia la DateTime a unui string
     */
    public static DateFormat getSqlDateFormat() {
        return sqlDateFormat;
    }

    /**
     * seteaza formatul de date necesar server-ului de SQL pentru conversia la DateTime a unui string
     * @param sqlDateFormat formatul de date necesar server-ului de SQL pentru conversia la DateTime a unui string
     */
    public static void setSqlDateFormat(DateFormat sqlDateFormat) {
        PlatformInstance.sqlDateFormat = sqlDateFormat;
    }

    /**
     * intoarce utilizatorul de aplicatie curent curent, sau un utilizator gol daca nu este setat
     * @return utilizatorul de aplicatie curent curent
     */
    public static User getUser() {
        if(user == null)return new User();
        return user;
    }

    /**
     * seteaza utilizatorul de aplicatie curent curent
     * @param user utilizatorul de aplicatie curent curent
     */
    public static void setUser(User user) {
        PlatformInstance.user = user;
    }

    /**
     * Preluarea locatiei Procedurilor sql.
     * @return locatia Procedurilor sql.
     */
    public static String getProcsPath(){
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "src","main","java","gestiune","farmacie","data","procs");
//        System.out.println(filePath.toString());
        return filePath.toString();
    }

}
