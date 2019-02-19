package comp3350.schrodingers.persistence.stubs;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.UsersPersistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class UsersPersistenceStub implements UsersPersistence
{
    private List<User> users; // list of all users

    public UsersPersistenceStub() //constructor
    {
        this.users = new ArrayList<>();
        users.add(new User("zunenebula@gmail.com","Zune", "shield-hero"));

    }

    public User findUser(String email) // returns the user which matches the email
    {
        Iterator<User> userIterator = users.iterator();
        while(userIterator.hasNext())
        {
            User nextUser = userIterator.next();
            if(nextUser.getEmail().equals(email))
            {
                return nextUser;
            }
        }
        return null;
    }

    public User insertUser(User newUser) // adds a new user to the list
    {
        users.add(newUser);
        return newUser;
    }
    public User editUser(User newUser){
        /*
        int index = users.indexOf(newUser);
        if(index >= 0)
            users.set(index,newUser);
            */
        users.set(0, newUser);
        return newUser;
    }


    public void deleteUser(String email) //deletes the user which matches the email from the list
    {
        users.remove(findUser(email));
    }

    public User getUser(){
        //created to be able to test the logged activity
        return users.get(0);
    }
}
