package gestiune.farmacie.data.objects;

import gestiune.farmacie.data.business.objects.User;
import javafx.application.HostServices;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * O instanta singletone ce mentine date statice necesare functionarii optime intregii aplicatii
 */
public class PlatformInstance {
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
    public static HostServices getHostedServices() {
        return hostedServices;
    }
    public static void setHostedServices(HostServices hostedServices) {
        PlatformInstance.hostedServices = hostedServices;
    }
    public static DateFormat getDateFormat() {
        return dateFormat;
    }
    public static void setDateFormat(DateFormat dateFormat) {
        PlatformInstance.dateFormat = dateFormat;
    }
    public static DateFormat getSqlDateFormat() {
        return sqlDateFormat;
    }
    public static void setSqlDateFormat(DateFormat sqlDateFormat) {
        PlatformInstance.sqlDateFormat = sqlDateFormat;
    }
    public static User getUser() {
        if(user == null)return new User();
        return user;
    }

    public static void setUser(User user) {
        PlatformInstance.user = user;
    }

    /**
     * Preluarea locatiei Procedurilor sql.
     * @return
     */
    public static String getProcsPath(){
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "farmacie","src","main","java","gestiune","farmacie","data","procs");
//        System.out.println(filePath.toString());
        return filePath.toString();
    }

}
