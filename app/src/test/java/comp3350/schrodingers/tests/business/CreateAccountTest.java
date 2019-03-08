package comp3350.schrodingers.tests.business;

import junit.framework.TestCase;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import comp3350.schrodingers.business.CreateAccount;
import comp3350.schrodingers.business.UserException;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.tests.persistence.UsersPersistenceStub;


public class CreateAccountTest {

    private UsersPersistenceStub stub = new UsersPersistenceStub();

    private CreateAccount testAccount = new CreateAccount(stub);
    String email = "test123@gmail.com";
    String password = "pokemon";
    String username = "maya";




    @Test
    public void CreateAccountCheck1() {
        System.out.println("\nStarting create account test\n");
        try
        {
            User testUser = testAccount.insertUser(email, username, password);
        }

        catch(UserException e)
        {
            System.out.println(e.getMessage());

        }

        System.out.println("\nCompleted create account test\n");
    }

}
