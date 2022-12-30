package gestiune.farmacie.data.objects;

import gestiune.farmacie.data.business.objects.User;

public class PlatformInstance {
    private static User user;

    public static User getUser() {
        if(user == null)return new User();
        return user;
    }

    public static void setUser(User user) {
        PlatformInstance.user = user;
    }
}
