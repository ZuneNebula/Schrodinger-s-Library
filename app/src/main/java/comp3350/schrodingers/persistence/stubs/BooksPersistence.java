package comp3350.schrodingers.persistence.stubs;

import java.util.List;
import comp3350.schrodingers.Objects.Book;

public interface BooksPersistence {
    List<Book> getBookByAuthor(String author);
    List<Book> getBookByTitle(String title);
    Book insertBook (Book newBook);
    Book deleteBook (Book newBook);
    Book searchByTitle (String Title);
    Book searchByAuthor (String Author);
}
