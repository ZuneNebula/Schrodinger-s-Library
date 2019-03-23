package comp3350.schrodingers.tests.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.PurchasedBooks;

public class PurchasedBooksStub implements PurchasedBooks {
    private List<Book> books;
    private User user;
    public PurchasedBooksStub(){
        books = new ArrayList<>();
        books.add(new Book(21, "Whirlwind", "Natalie Hamilton", "$400", "Non-Fiction", "30", "whirlwind"));
        user = new User("zunenebula@gmail.com", "Zune", "shield-hero");
    }

    @Override
    public List<Book> getBooks(String email){
        return books;
    }

    @Override
    public void insertBook(Book book, String email){
        if(user.getEmail().equals(email))
            books.add(book);
    }
}
