package comp3350.schrodingers.tests.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.UsersPersistence;

public class UsersPersistenceStub implements UsersPersistence {
    private List<User> users; // list of all users
    private User logged;

    public UsersPersistenceStub() //constructor
    {
        this.users = new ArrayList<>();
        users.add(new User("zunenebula@gmail.com", "Zune", "shield-hero"));
        logged = users.get(0);
    }

    public User findUser(String email) // returns the user which matches the email
    {
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User nextUser = userIterator.next();
            if (nextUser.getEmail().equals(email)) {
                return nextUser;
            }
        }
        return null;
    }

    public User getUserAndLogin(String email) {
        //find a user by email and store it apart to use it everywhere (logged in)
        logged = findUser(email);
        return logged;
    }

    public User insertUser(User newUser) // adds a new user to the list
    {
        users.add(newUser);
        logged = users.get(users.size() - 1);
        return newUser;
    }

    public User editUser(User newUser) {
        //User will only to be able to edit its information when logged in
        if (logged != null) {
            int index = users.indexOf(logged);
            logged = new User(newUser.getEmail(), newUser.getUserName(), newUser.getPassword(), newUser.getAddress(), newUser.getBilling());
            users.set(index, logged);
            return logged;
        }
        return null;
    }


    public void deleteUser(String email) //deletes the user which matches the email from the list
    {
        users.remove(findUser(email));
    }

    public User getUser() {
        //get logged user
        return logged;
    }

    public boolean logout() {
        logged = null;
        return true;
    }

}
