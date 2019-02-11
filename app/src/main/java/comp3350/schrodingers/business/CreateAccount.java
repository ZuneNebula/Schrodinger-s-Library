package comp3350.schrodingers.business;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.persistence.UsersPersistence;

public class CreateAccount {
    private UsersPersistence usersPersistence;

    public CreateAccount() {

        //constructor
        usersPersistence = Services.getUsersPersistence();

    }

    public User insertUser(String email, String userName, String password) {
        User newUser = new User(email, userName, password);
        return usersPersistence.insertUser(newUser);

    }

    public void deleteUser(String email) {
        usersPersistence.deleteUser(email);
    }
}
