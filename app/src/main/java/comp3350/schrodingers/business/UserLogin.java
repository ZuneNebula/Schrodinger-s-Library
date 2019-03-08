package comp3350.schrodingers.business;

import java.util.Collections;
import java.util.List;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.UsersPersistence;

public class UserLogin {
    private AccessUserInfo accessUserInfo;

    public UserLogin() {
        //constructor
        accessUserInfo = new AccessUserInfo();

    }
    public UserLogin(final UsersPersistence u){
        accessUserInfo = new AccessUserInfo(u);
    }

    public User checkLogin(String email, String password) {
        User curr = accessUserInfo.login(email);
        if (curr != null && curr.getPassword().equals(password)) {
            return curr;
        } else {
            //System.out.println("failed login");
            return null;
        }

    }

}

