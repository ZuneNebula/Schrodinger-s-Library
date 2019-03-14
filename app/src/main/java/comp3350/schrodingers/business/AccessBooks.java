package comp3350.schrodingers.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comp3350.schrodingers.objects.Ratings;
import comp3350.schrodingers.persistence.BooksPersistence;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.persistence.RatingPersistence;

// Class - facilitates accessing books and their relevant details from DB
public class AccessBooks {

    // Store reference to book and ratings DB access
    private BooksPersistence booksPersistence;
    private RatingPersistence ratingPersistence;

    // Constructor - initialize DB access
    public AccessBooks() {
        booksPersistence = Services.getBooksPersistence();
        ratingPersistence = Services.getRatePersistence();
    }

    /************ Book Access ***************/

    // Method - get all books from DB
    public List<Book> getAllBooks() {
        List<Book> allBooks = booksPersistence.getAllBooks();
        return allBooks;
    }

    // Method - search for book by bookID
    public Book searchBookById(int id) {
        List<Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();
            if (nextBook.getBookID() == id)
                return nextBook; // Returns a books with given ID
        }
        return null;
    }

    // Method - search for books by author
    public List<Book> searchBookByAuthor(String author) {
        List<Book> authorBook = new ArrayList<>();
        List<Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();
            if ((nextBook.getAuthor().toLowerCase()).contains(author))
                authorBook.add(nextBook);

        }
        return authorBook; // Returns a list of books by the author
    }

    // Method - search for books by title
    public List<Book> searchBookByTitle(String title) {
        List<Book> titleBook = new ArrayList<>();
        List<Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();
            if ((nextBook.getBookName().toLowerCase()).contains(title))
                titleBook.add(nextBook);
        }
        return titleBook; // Returns a list of books by the title
    }

    /************ Ratings Access ***************/

    // Method - find other user ratings associated with a given book
    public List <Ratings> findRatingsByBook(int bookID){
        List<Ratings> ratings = ratingPersistence.getBookRatings();
        List<Ratings> bookRatings = new ArrayList<>();
        Iterator<Ratings> rateIterator = ratings.iterator();
        while (rateIterator.hasNext()) {
            Ratings nextRate = rateIterator.next();
            if (nextRate.getBookID() == bookID )
                bookRatings.add(nextRate);
        }
        return bookRatings;
    }

}
