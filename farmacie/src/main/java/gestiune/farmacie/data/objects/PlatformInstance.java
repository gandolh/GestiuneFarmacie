package gestiune.farmacie.data.objects;

import gestiune.farmacie.data.business.objects.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PlatformInstance {
    private static User user;

    public static DateFormat getDateFormat() {
        return dateFormat;
    }

    public static void setDateFormat(DateFormat dateFormat) {
        PlatformInstance.dateFormat = dateFormat;
    }

    private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static User getUser() {
        if(user == null)return new User();
        return user;
    }

    public static void setUser(User user) {
        PlatformInstance.user = user;
    }
}
