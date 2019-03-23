package comp3350.schrodingers.tests.objects;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

import comp3350.schrodingers.objects.User;

// tests the user class's constructor and main fields
//to do later - add address tests
public class UserTest {

    private List<User> testUsers;
    User testUser = new User(1,"axa@gmail.com","michael","voo");

    @Test
    public void constructorIsCorrect()
    {
        System.out.println("\nStarting user test\n");
        assertEquals(testUser.getEmail(), "axa@gmail.com");
        assertEquals(testUser.getUserName(), "michael");
        assertEquals(testUser.getPassword(), "voo");
        System.out.println("\nFinished user test\n");

    }

}
