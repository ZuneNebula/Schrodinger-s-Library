package comp3350.schrodingers.business;

import java.util.Collections;
import java.util.List;

import comp3350.schrodingers.objects.User;

public class CreateAccount {
    private AccessUserInfo accessUserInfo;

    public CreateAccount() {
        //constructor
        accessUserInfo = new AccessUserInfo();

    }

    public User insertUser(String email, String userName, String password) throws Exception{
        User newUser = new User(email, userName, password);
        return accessUserInfo.insertUser(newUser);
    }
    /*
    public void deleteUser(String email) {
        usersPersistence.deleteUser(email);
    }
    */
}
