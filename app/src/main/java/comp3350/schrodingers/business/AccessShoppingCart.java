package comp3350.schrodingers.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.ShoppingCartPersistence;
import comp3350.schrodingers.persistence.UsersPersistence;

// Class - dedicated to managing access to the shopping
// cart table in the DB
public class AccessShoppingCart{

    private AccessUserInfo accessUserInfo;
    private ShoppingCartPersistence ShoppingCartPersistence;

    // Constructor - initialize DB access
    public AccessShoppingCart() {
        accessUserInfo = new AccessUserInfo();
        ShoppingCartPersistence = Services.getShoppingCartPersistence();
    }

    // Constructor - inject DB access
    public AccessShoppingCart(UsersPersistence usersPersistence, final ShoppingCartPersistence cartPersistence) {
        accessUserInfo = new AccessUserInfo(usersPersistence);
        this.ShoppingCartPersistence = cartPersistence;
    }

    public List<Book> getBooks() throws UserException{
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
