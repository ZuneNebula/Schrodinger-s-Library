package comp3350.schrodingers.persistence.stubs;

import comp3350.schrodingers.Objects.User;
import java.util.List;

public interface UsersPersistence{
    List<User> getUserbyName(String userName);
    User addUser(User newUser);
    User removeUser(User deleteUser);
}
