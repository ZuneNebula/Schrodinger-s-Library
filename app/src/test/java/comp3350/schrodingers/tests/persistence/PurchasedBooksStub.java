package comp3350.schrodingers.tests.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.business.BookBuilder;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.PurchasedBooks;

public class PurchasedBooksStub implements PurchasedBooks {

    private List<Book> books;
    private User user;

    public PurchasedBooksStub(){
        books = new ArrayList<>();
        BookBuilder builder = new BookBuilder();
        builder.id(21).name("Whirlwind").author("Natalie Hamilton").price("$400").genre("Non-Fiction").stock("30").icon("whirlwind");
        books.add(builder.buildBook());
        user = new User(1, "zunenebula@gmail.com", "Zune", "shield-hero");
    }

    @Override
    public List<Book> getBooks(int id){
        return books;
    }

    @Override
    public void insertBook(Book book, int id){
        if(user.getUserId() == id)
            books.add(book);
    }
}
