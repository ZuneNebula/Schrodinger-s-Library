package comp3350.schrodingers.tests.business;

import org.junit.Test;

import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.business.userExceptions.UserException;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.tests.persistence.UsersPersistenceStub;


public class CreateAccountTest {

    private UsersPersistenceStub stub = new UsersPersistenceStub();

    private AccessUserInfo testUserAccess = new AccessUserInfo(stub);
    String email = "test123@gmail.com";
    String password = "pokemon";
    String username = "maya";

    @Test
    public void CreateAccountCheck1() {
        System.out.println("\nStarting create account test\n");
        try
        {
            User testUser = testUserAccess.insertUser(email, username, password);
        }

        catch(UserException e)
        {
            System.out.println(e.getMessage());

        }

        System.out.println("\nCompleted create account test\n");
    }

}
