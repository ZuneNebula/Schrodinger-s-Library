package comp3350.schrodingers.business;

import java.util.Collections;
import java.util.List;

import comp3350.schrodingers.objects.User;


public class UserLogin {
    private AccessUserInfo accessUserInfo;

    public UserLogin() {
        //constructor
        accessUserInfo = new AccessUserInfo();

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

