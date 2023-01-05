package tests;

import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestUserReporitory {


    @Test
    public void testGetUser(){
        UserRepository repo = new UserRepository();
        User user = repo.getUser("admin","admin");
        assertTrue(user.getUserId().equals("1"));
        assertTrue(user.getEmployeeId().equals("1"));
        assertTrue(user.getEmail().equals("itmanager@admin.ro"));

    }

    @Test
    public void testIsUser(){
        UserRepository repo = new UserRepository();
        assertTrue(repo.getIsUser("admin","admin"));
    }

    @Test
    public void testGetAllUsers(){
        UserRepository repo = new UserRepository();
        List<User> users = repo.getAllUsers();
        assertTrue(users.get(0).getUsername().equals("admin"));
        assertTrue(users.size()>0);
        assertTrue(users.get(0).getUserId().equals("1"));

    }

}
