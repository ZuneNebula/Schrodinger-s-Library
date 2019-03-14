package comp3350.schrodingers.business;

// Class - dedicated exception for errors involving credit cards
public class CardException extends Exception {

    // Stores the message returned by the exception
    private String message;

    // Constructor - initializes exception message
    public CardException(String m) {
        message = m;
    }

    // Method - return the message as a string
    public String toString() {
        return message;
    }

}
