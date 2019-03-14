package comp3350.schrodingers.business;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.persistence.UsersPersistence;

// Class - facilitates accessing user info from DB
public class AccessUserInfo {

    // Store payment access to DB and relevant/current user
    private UsersPersistence userPersistence;
    private User logged;

    // Constructor - initialize DB access
    public AccessUserInfo() {
        userPersistence = Services.getUsersPersistence();
    }

    // Constructor - inject DB access
    public AccessUserInfo(final UsersPersistence userPers) {
        this.userPersistence = userPers;
    }

    /************ User Access ***************/

    // Method - return the user already logged (returns null if not logged in)
    public User getUser() {
        logged = userPersistence.getUser();
        return logged;
    }

    // Method - login using previously stored user email (and return it - null if not found)
    public User login(String email){
        logged = userPersistence.getUserAndLogin(email);
        return logged;
    }

    // Method - insert user into DB
    public User insertUser(User user) throws UserException {
        //add new user
        UserValidator u = new UserValidator();
        u.validateInfo(user);
        if (logged == null)
            return userPersistence.insertUser(user);
        return updateUser(user);
    }

    // Method - update user in DB
    public User updateUser(User user) {
        //edit user
        return userPersistence.editUser(user);
    }

    // Method - logout current user
    public boolean logout() {
        return userPersistence.logout();
    }
}
