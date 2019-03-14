package comp3350.schrodingers.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import comp3350.schrodingers.objects.User;

// Class - used to valid users personal information (excludes address and billing)
public class UserValidator {

    // Method - validate correct syntax when entering user info
    public boolean validateInfo(User user) throws UserException {

        // Holds username and email
        String name = user.getUserName();
        String email = user.getEmail();

        // Check that username is entered
        if (name.length() == 0)
            throw new UserException("Name required");

        // Check that email is entered and correctly formatted
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
