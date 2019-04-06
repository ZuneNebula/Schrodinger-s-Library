package comp3350.schrodingers.tests.business;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.tests.persistence.UsersPersistenceStub;


public class UserLoginTest {

    private UsersPersistenceStub stub = new UsersPersistenceStub();
    private AccessUserInfo testUserAccess = new AccessUserInfo(stub);
    String email = "zunenebula@gmail.com";
    String password = "shield-hero";

    User testUser = testUserAccess.checkLogin(email,password);

    @Test
    public void LoginCheck1() {
        System.out.println("\nStarting login test\n");
        assert(testUser !=null);
        assertEquals(testUser.getEmail(), "zunenebula@gmail.com");
        assertEquals(testUser.getUserName(), "Zune");
        assertEquals(testUser.getPassword(), "shield-hero");

    }

    User testUser2 = testUserAccess.checkLogin(email,"wrong");

    @Test
    public void LoginCheck2() {
        assert(testUser2 ==null);
        System.out.println("\n Completed Login tests\n");

    }

}

