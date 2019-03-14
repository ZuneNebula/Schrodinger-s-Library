package comp3350.schrodingers.objects;

// Class - used to store ratings of books
public class Ratings {

    // Stores relevant rating information associated with a given book
    private int rateID;
    private int bookID;
    private String email;
    private int rate;

    // Constructor - initializes the ratings
    public Ratings(int rateID, int bookID, String email, int rate) {
        this.rateID = rateID;
        this.bookID = bookID;
        this.email = email;
        this.rate = rate;
    }

    // Method - get rating ID
    public int getRateID() {
        return rateID;
    }

    // Method - set rating ID
    public void setRateID(int rateID) {
        this.rateID = rateID;
    }

    // Method - get book ID associated with rating
    public int getBookID() {
        return bookID;
    }

    // Method - set book ID associated with rating
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    // Method - get email associated with rating
    public String getEmail() {
        return email;
    }

    // Method - set book ID associated with rating
    public void setEmail(String email) {
        this.email = email;
    }

    // Method - get actual rating
    public int getRate() {
        return rate;
    }

    // Method - set actual rating
    public void setRate(int rate) {
        this.rate = rate;
    }

    // Method - return ratings as string
    @Override
    public String toString() {
        return " Rated " + this.rate + " By " + this.email;
    }
}
