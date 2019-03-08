package comp3350.schrodingers.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import comp3350.schrodingers.objects.User;

public class UserValidator {
    public boolean validateInfo(User user) throws UserException {
        String name = user.getUserName();
        String email = user.getEmail();
        if (name.length() == 0)
            throw new UserException("Name required");

        if (email.length() == 0)
            throw new UserException("Email required");
        else {
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches())
                throw new UserException("Email not valid");
        }
        return true;
    }
}
