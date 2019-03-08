package comp3350.schrodingers.tests.business;

import org.junit.Before;
import org.junit.Test;

import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.tests.persistence.UsersPersistenceStub;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
public class AccessUserInfoTest {
    private AccessUserInfo accessUserInfo;

    @Before
    public void setUp(){
        accessUserInfo = new AccessUserInfo(new UsersPersistenceStub());
    }

    @Test
    public void testGetUser(){
        final User user;
        System.out.println("\nStarting test AccessUserInfo");
        user = accessUserInfo.getUser();
        assertNotNull("\tfirst logged user should not be null", user);
        assertTrue("Zune".equals(user.getUserName()));
        System.out.println("\nFinished test AccessUserInfo");
    }
    @Test
    public void testLogout(){
        final User user;
        System.out.println("\nStarting test Logout");
        accessUserInfo.logout();
        user = accessUserInfo.getUser();
        assertNull("\tuser should be null", user);
        System.out.println("\nFinished test Logout");
    }

    @Test
    public void testLogin(){
        final User user;
        System.out.println("\nStarting test Login");
        user = accessUserInfo.login("zunenebula@gmail.com");
        assertNotNull("\tuser should not be null", user);
        assertTrue("Zune".equals(user.getUserName()));
        System.out.println("\nFinished test Login");
    }

}
