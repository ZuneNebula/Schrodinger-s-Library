package comp3350.schrodingers.persistence;

import java.util.List;

import comp3350.schrodingers.objects.Book;

public interface BooksPersistence {
    List<Book> getAllBooks();
}
