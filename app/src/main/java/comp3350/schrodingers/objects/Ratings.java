package comp3350.schrodingers.objects;

public class Ratings {

    private int rateID;
    private int bookID;
    private String email;
    private int rate;

    public Ratings( int bookID, String email, int rate) {

        this.bookID = bookID;
        this.email = email;
        this.rate = rate;
    }



    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return " Rated " + this.rate + " By " + this.email;
    }
}
