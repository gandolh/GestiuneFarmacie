package gestiune.farmacie.data.objects;

import gestiune.farmacie.data.business.objects.UserData;

public class PlatformInstance {
    private static UserData user;

    public static UserData getUser() {
        return user;
    }

    public static void setUser(UserData user) {
        PlatformInstance.user = user;
    }
}
