package comp3350.schrodingers.business;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.persistence.UsersPersistence;

public class AccessUserInfo {
    private UsersPersistence userPersistence;
    private User logged;
    public AccessUserInfo(){
        userPersistence = Services.getUsersPersistence();
    }

    public User getUser(){
        logged = userPersistence.getUser();
        return logged;
    }
    public User insertUser(User user) throws Exception{
        UserValidator u = new UserValidator();
        u.validateInfo(user);
        return userPersistence.insertUser(user);
    }
    public User updateUser(User user){
        return userPersistence.editUser(user);
    }


}
