package comp3350.schrodingers.business;

import java.util.Collections;
import java.util.List;

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
        UserValidator u = new UserValidator();
        try {
            u.validateInfo(newUser);
            return usersPersistence.insertUser(newUser);
        }catch(Exception e){
            System.out.println(e.toString()); //TODO: change to throw a message
            return null;
        }


    }

    public void deleteUser(String email) {
        usersPersistence.deleteUser(email);
    }
}
