package comp3350.schrodingers.business;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.persistence.UsersPersistence;

public class AccessUserInfo {
    private UsersPersistence userPersistence;
    private User logged;

    public AccessUserInfo() {
        userPersistence = Services.getUsersPersistence();
    }

    public AccessUserInfo(final UsersPersistence userPers) {
        this();
        this.userPersistence = userPers;
    }

    public User getUser() {
        // Get the user already logged (returns null if not logged in)
        logged = userPersistence.getUser();
        return logged;
    }

    public User insertUser(User user) throws Exception {
        //add new user
        UserValidator u = new UserValidator();
        u.validateInfo(user);
        if (logged == null)
            return userPersistence.insertUser(user);
        return updateUser(user);
    }

    public User updateUser(User user) {
        //edit user
        return userPersistence.editUser(user);
    }

    public boolean logout() {
        return userPersistence.logout();
    }
}
