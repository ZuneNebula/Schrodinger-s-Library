package comp3350.schrodingers.business;

public class CardException extends Exception {
    private String message;
    public CardException(String m){
        message = m;
    }

    public String toString(){
        return message;
    }

}
