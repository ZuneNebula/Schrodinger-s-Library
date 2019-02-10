package comp3350.schrodingers.persistence;

import java.util.List;
import comp3350.schrodingers.Objects.Book;

public interface BooksPersistence {
    List<Book> getBooks();
    List<Book> getBookByAuthor(final String author);
    List<Book> getBookByTitle(final String title);
    Book getBookById(final String id);
    Book insertBook (final Book newBook);
    void  deleteBook (final Book newBook);
}
