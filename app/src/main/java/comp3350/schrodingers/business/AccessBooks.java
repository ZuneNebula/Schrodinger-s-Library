package comp3350.schrodingers.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comp3350.schrodingers.persistence.BooksPersistence;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.application.Services;

public class AccessBooks {

    private BooksPersistence booksPersistence;

    // Constructor - initialize DB access
    public AccessBooks() {
        booksPersistence = Services.getBooksPersistence();
    }

    // Constructor - inject DB access
    public AccessBooks(BooksPersistence bookStorage) {
        booksPersistence = bookStorage;
    }

    // Method - get all books as list from DB
    public List<Book> getAllBooks() {
        List<Book> allBooks = booksPersistence.getAllBooks();
        return allBooks;
    }


    public Book searchBookById(int id) {
        List<Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the author
            if (nextBook.getBookID() == id) {
                return nextBook;
            }

        }//returns a books by the ID.
        return null;
    }

    public List<Book> searchBookByAuthor(String author) {
        List<Book> authorBook = new ArrayList<>();
        List<Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the author
            if ((nextBook.getAuthor().toLowerCase()).contains(author)) {
                authorBook.add(nextBook);
            }

        }
        return authorBook; //returns a list of books by the author.
    }

    public List<Book> searchBookByTitle(String title) {
        List<Book> titleBook = new ArrayList<>();
        List<Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the title
            if ((nextBook.getBookName().toLowerCase()).contains(title)) {
                titleBook.add(nextBook);
            }

        }
        return titleBook; //returns a list of books by the title.
    }

    public List<Book> searchBookByGenre(String genre, int count) {// only used for recommendations
        List<Book> titleBook = new ArrayList<>();
        List<Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        int k=count;
        while (bookIterator.hasNext() && k>0) {
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the title
            if (nextBook.getGenre().toLowerCase() == genre.toLowerCase()) {
                titleBook.add(nextBook);
                k--;
            }

        }
        return titleBook; //returns a list of books by the title, max of upto count no of books.
    }


}
