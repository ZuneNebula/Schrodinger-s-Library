package comp3350.schrodingers.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.business.userExceptions.NotLoggedException;
import comp3350.schrodingers.business.userExceptions.UserException;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.PurchasedBooks;
import comp3350.schrodingers.persistence.UsersPersistence;

public class AccessPurchasedBooks {

    private PurchasedBooks purchasedBooks;
    private AccessUserInfo accessUserInfo;

    public AccessPurchasedBooks(){
        purchasedBooks = Services.getPurchasedPersistence();
        accessUserInfo = Services.getUserInfoAccess();
    }

    public AccessPurchasedBooks(final PurchasedBooks purBooks, UsersPersistence u){
        this.purchasedBooks = purBooks;
        accessUserInfo = Services.getUserInfoAccess();
    }

    public List<Book> getBooks() throws UserException {
        List<Book> books = new ArrayList<>();
        User user = accessUserInfo.getUser();
        if(user != null)
            books = purchasedBooks.getBooks(user.getUserId());
        else
            throw new NotLoggedException();
        return books;
    }

    public boolean insertBook(Book book) throws UserException{
        User user = accessUserInfo.getUser();
        if(user != null) {
            purchasedBooks.insertBook(book, user.getUserId());
            return true;
        }
        throw new NotLoggedException();
    }
}
