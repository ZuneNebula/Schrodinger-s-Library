package comp3350.schrodingers.business;
import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.PurchasedBooks;
import comp3350.schrodingers.persistence.UsersPersistence;

public class AccessPurchasedBooks {
    private PurchasedBooks purchasedBooks;
    private AccessUserInfo accessUserInfo;

    public AccessPurchasedBooks(){
        purchasedBooks = Services.getPurchasedPersistence();
        accessUserInfo = new AccessUserInfo();
    }

    public AccessPurchasedBooks(final PurchasedBooks purBooks, UsersPersistence u){
        this.purchasedBooks = purBooks;
        accessUserInfo = new AccessUserInfo(u);
    }

    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        User user = accessUserInfo.getUser();
        if(user != null)
            books = purchasedBooks.getBooks(user.getEmail());
        return books;
    }

    public boolean insertBook(Book book){
        User user = accessUserInfo.getUser();
        if(user != null) {
            purchasedBooks.insertBook(book, user.getEmail());
            return true;
        }
        return false;
    }
}
