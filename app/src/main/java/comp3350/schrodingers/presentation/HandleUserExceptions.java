package comp3350.schrodingers.presentation;

import comp3350.schrodingers.business.userExceptions.EmailNotValidException;
import comp3350.schrodingers.business.userExceptions.EmailRequiredException;
import comp3350.schrodingers.business.userExceptions.NameRequiredException;
import comp3350.schrodingers.business.userExceptions.NotLoggedException;
import comp3350.schrodingers.business.userExceptions.UserException;

public class HandleUserExceptions {
    private UserException userExcep;
    public HandleUserExceptions(UserException u){
        userExcep = u;
    }
    private void decideOutput(){
        if(userExcep instanceof EmailNotValidException)
            userExcep.setMessage("Email not valid!");
        else if(userExcep instanceof EmailRequiredException)
            userExcep.setMessage("Email Required!");
        else if(userExcep instanceof NameRequiredException)
            userExcep.setMessage("Username required");
        else if(userExcep instanceof NotLoggedException)
            userExcep.setMessage("You are not logged in!");
    }
    public String toString(){return userExcep.toString();}
}
