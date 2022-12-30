package gestiune.farmacie.auth;

import gestiune.farmacie.data.business.objects.User;

public class DatabaseUserAuthenticator implements UserAuthenticator {

    @Override
    public void logIn(String userId, String password) {
        System.out.println("DatabaseUserAuthenticator.logIn");
    }

    @Override
    public void signUp(User user) {
        System.out.println("DatabaseUserAuthenticator.signUp");

    }

    @Override
    public void getUserData(String userId) {
        System.out.println("DatabaseUserAuthenticator.getUserData");
    }

    @Override
    public void resetPassword(String userId, String newPassword) {
        System.out.println("DatabaseUserAuthenticator.resetPassword");
    }
}
