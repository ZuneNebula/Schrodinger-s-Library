package comp3350.schrodingers.business;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.objects.User.Address;
import comp3350.schrodingers.objects.User.Billing;

public class UserBuilder {

    private User user;

    public UserBuilder(String email, String username, String password){
        user = new User(0, email, username, password);
    }
    public UserBuilder(int id, String email, String username, String password){
        user = new User(id, email, username, password);
    }
    public UserBuilder(User newUser){
        user = newUser;
    }

    public User setAddress(Address address){
        user = new User(user.getUserId(), user.getEmail(), user.getUserName(), user.getPassword(), address, user.getBilling());
        return user;
    }

    public User setEmailAndName(String email, String name){
        user = new User(user.getUserId(), email, name, user.getPassword(), user.getAddress(), user.getBilling());
        return user;
    }

    public User setBilling(Billing billing){
        user = new User(user.getUserId(), user.getEmail(), user.getUserName(), user.getPassword(), user.getAddress(), billing);
        return user;
    }

    public User setAddressAndBilling(Address address, Billing billing){
        user = new User(user.getUserId(), user.getEmail(), user.getUserName(), user.getPassword(), address, billing);
        return user;
    }

    public User getUser(){
        return user;
    }

}
