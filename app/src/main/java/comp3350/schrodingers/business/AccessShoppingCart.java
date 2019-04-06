package comp3350.schrodingers.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.business.userExceptions.UserException;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.ShoppingCartPersistence;
import comp3350.schrodingers.persistence.UsersPersistence;

// Class - dedicated to managing access to the shopping
// cart table in the DB
public class AccessShoppingCart{

    private AccessUserInfo accessUserInfo;
    private ShoppingCartPersistence ShoppingCartPersistence;

    // Constructor - inject shopping cart DB access and acquire user access
    public AccessShoppingCart(final ShoppingCartPersistence cartPersistence) {
        accessUserInfo = Services.getUserInfoAccess();
        ShoppingCartPersistence = cartPersistence;
    }

    // Constructor - inject both shopping cart and DB access (testing purposes)
    public AccessShoppingCart(UsersPersistence usersPersistence, final ShoppingCartPersistence cartPersistence) {
        ShoppingCartPersistence = cartPersistence;
        accessUserInfo = new AccessUserInfo(usersPersistence);
    }

    public List<Book> getBooks() throws UserException {
        List<Book> books = new ArrayList<>();
        User user = accessUserInfo.getUser();
        if(user != null)
            books = ShoppingCartPersistence.getBooks(user.getUserId());
        return books;
    }

    public boolean insertBook(Book book) throws UserException{
        List <Book> books = this.getBooks();
        boolean flag = false;
        for(Book booker :books){
            if(booker.getBookID()==book.getBookID()){
                flag= true;
            }
        }

        User user = accessUserInfo.getUser();
        if((user != null) && (!flag) ) {
            ShoppingCartPersistence.insertBook(book, user.getUserId());
            return true;
        }
        return false;
    }
}
