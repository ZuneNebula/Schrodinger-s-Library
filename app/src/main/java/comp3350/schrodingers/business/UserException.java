package comp3350.schrodingers.business;

public class UserException extends Exception{
    private String message;

    public UserException(String m) {
        message = m;
    }

    public String toString() {
        return message;
    }
}
