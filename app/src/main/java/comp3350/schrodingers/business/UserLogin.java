package comp3350.schrodingers.business;

import java.util.Collections;
import java.util.List;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.persistence.UsersPersistence;

public class UserLogin {
    private UsersPersistence usersPersistence;

    public UserLogin() {
        //constructor
        usersPersistence = Services.getUsersPersistence();

    }

    public User checkLogin(String email, String password) {
        User curr = usersPersistence.getUserAndLogin(email);
        if (curr != null && curr.getPassword() == password) {
            return curr;
        } else {
            //System.out.println("failed login");
            return null;
        }

    }

}

