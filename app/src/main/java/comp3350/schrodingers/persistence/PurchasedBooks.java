package comp3350.schrodingers.persistence;

import java.util.List;

import comp3350.schrodingers.objects.Book;

public interface PurchasedBooks {
    List<Book> getBooks(String email);
    void insertBook(Book book, String userEmail);
}
