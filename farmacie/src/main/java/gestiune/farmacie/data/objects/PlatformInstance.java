package gestiune.farmacie.data.objects;

import gestiune.farmacie.data.business.objects.User;
import javafx.application.HostServices;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PlatformInstance {
    private static User user;
    private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private static DateFormat sqlDateFormat = new SimpleDateFormat("dd-MM-yy");

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

    public static String getProcsPath(){
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "farmacie","src","main","java","gestiune","farmacie","data","procs");
//        System.out.println(filePath.toString());
        return filePath.toString();
    }

}
