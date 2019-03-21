package comp3350.schrodingers.persistence;

import java.util.List;

import comp3350.schrodingers.objects.Ratings;

public interface RatingPersistence {
    List<Ratings> getBookRatings();
    void addBookRatings(int bookid, int rate, String user, String review);
}
