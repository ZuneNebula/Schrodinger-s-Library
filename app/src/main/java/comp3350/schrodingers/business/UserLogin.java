package comp3350.schrodingers.business;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.UsersPersistence;

//Class - handles user login
public class UserLogin {

    // Store access to DB
    private AccessUserInfo accessUserInfo;

    // Constructor - initialize DB access
    public UserLogin() {
        accessUserInfo = Services.getUserInfoAccess();
    }

    // Constructor - inject DB access
    public UserLogin(final UsersPersistence u){
        accessUserInfo = Services.getUserInfoAccess();
    }

    // Method - check email and password in order to login
    public User checkLogin(String email, String password) {
        User curr = accessUserInfo.login(email);
        if (curr != null && curr.getPassword().equals(password)) {
            return curr;
        } else {
            return null;
        }

    }

}

