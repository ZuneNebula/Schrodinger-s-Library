package comp3350.schrodingers.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import comp3350.schrodingers.objects.User;

public class UserValidator {
    public boolean validateInfo(User user) throws Exception{
        String name = user.getUserName();
        String email = user.getEmail();
        if(name.length() == 0)
            throw new Exception("Name required");

        if(email.length() == 0)
            throw new Exception("Email required");
        else{
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if(!matcher.matches())
                throw new Exception("Email not valid");
        }
        return true;
    }
}
