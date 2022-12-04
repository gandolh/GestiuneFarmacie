package gestiune.farmacie.auth;

import gestiune.farmacie.business.objects.Employee;
import gestiune.farmacie.business.objects.User;

public interface UserAuthenticator {
    public void logIn(String userId, String password);
    public void signUp(User user);
    public void getUserData(String userId);
    public void resetPassword(String userId, String newPassword);
}
