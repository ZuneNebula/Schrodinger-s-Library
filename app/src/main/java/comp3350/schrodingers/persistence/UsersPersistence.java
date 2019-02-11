package comp3350.schrodingers.persistence;

import comp3350.schrodingers.objects.User;

public interface UsersPersistence {

    User insertUser (final User newUser);
    void  deleteUser (final String email);
}
