package comp3350.schrodingers.business;

import comp3350.schrodingers.business.userExceptions.UserException;
import comp3350.schrodingers.persistence.UsersPersistence;
import comp3350.schrodingers.objects.User;

// Class - dedicated class built for account creation (only basic user details required)
public class CreateAccount {

    // Stores DB access
    private AccessUserInfo accessUserInfo;

    // Constructor - initialize DB access
    public CreateAccount() {
        accessUserInfo = new AccessUserInfo();
    }

    // Constructor - inject DB access
    public CreateAccount(UsersPersistence u){
        accessUserInfo = new AccessUserInfo(u);
    }

    // Method - insert user using only basic/necessary info
    public User insertUser(String email, String userName, String password) throws UserException {
        User newUser = new User(0, email, userName, password);
        return accessUserInfo.insertUser(newUser);
    }

}
