package gestiune.farmacie.classes;

public class PlatformInstance {
    private static UserData user;

    public static UserData getUser() {
        return user;
    }

    public static void setUser(UserData user) {
        PlatformInstance.user = user;
    }
}
