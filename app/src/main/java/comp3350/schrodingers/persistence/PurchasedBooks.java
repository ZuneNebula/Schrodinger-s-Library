package comp3350.schrodingers.persistence;

import java.util.List;

import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.objects.User;

public interface PurchasedBooks {
    List<Book> getBooks(int userId);
    void insertBook(Book book, int userId);
}
