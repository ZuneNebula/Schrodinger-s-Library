package comp3350.schrodingers.business;

import java.util.ArrayList;
import java.util.List;
import comp3350.schrodingers.persistence.BooksPersistence;
import comp3350.schrodingers.Objects.Book;
import comp3350.schrodingers.application.Services;

public class FindBook {
    private List <Book> bookList;
    private BooksPersistence booksPersistence;
    private Book book;

    public FindBook() {
   //constructor
        booksPersistence = Services.getBooksPersistence();
        book = null;
        bookList = null;
    }

    public List<Book> searchBookByAuthor(String author){
        
        List <Book> foundBook;
        foundBook= booksPersistence.getBookByAuthor(author);
        return foundBook;
    }

    public List <Book> searchBookByTitle(String title){
        List<Book> foundBook;
        foundBook= booksPersistence.getBookByTitle(title);
        return foundBook;
    }

    public Book insertBook(Book newBook){
        return booksPersistence.insertBook(newBook);
    }

    public void deleteBook(Book book){
        booksPersistence.deleteBook(book);
    }
}
