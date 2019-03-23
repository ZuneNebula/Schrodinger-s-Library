package comp3350.schrodingers.business;

import java.util.Collections;
import java.util.List;
import comp3350.schrodingers.persistence.UsersPersistence;

import comp3350.schrodingers.objects.User;

public class CreateAccount {
    private AccessUserInfo accessUserInfo;

    public CreateAccount() {
        //constructor
        accessUserInfo = new AccessUserInfo();

    }
    public CreateAccount(UsersPersistence u){
        accessUserInfo = new AccessUserInfo(u);
    }

    public User insertUser(String email, String userName, String password) throws UserException{
        User newUser = new User(0, email, userName, password);
        return accessUserInfo.insertUser(newUser);
    }
    /*
    public void deleteUser(String email) {
        usersPersistence.deleteUser(email);
    }
    */
}
