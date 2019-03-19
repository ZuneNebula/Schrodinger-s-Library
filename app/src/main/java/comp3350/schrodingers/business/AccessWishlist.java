package comp3350.schrodingers.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.WishlistPersistence;
import comp3350.schrodingers.persistence.UsersPersistence;

public class AccessWishlist {
    private AccessUserInfo accessUserInfo;
    private WishlistPersistence wishlistPersistence;

    public AccessWishlist() {
      accessUserInfo = new AccessUserInfo();
      wishlistPersistence = Services.getWishlistPersistence();
    }

    public AccessWishlist(UsersPersistence usersPersistence, final WishlistPersistence wishlist) {
        accessUserInfo = new AccessUserInfo(usersPersistence);
        this.wishlistPersistence = wishlist;
    }

    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        User user = accessUserInfo.getUser();
        if(user != null)
            books = wishlistPersistence.getBooks(user.getEmail());
        return books;
    }

    public boolean insertBook(Book book){
        List <Book> books = this.getBooks();
        boolean flag = false;
        for(Book booker :books){
            if(booker.getBookID()==book.getBookID()){
                flag= true;
            }
        }

        User user = accessUserInfo.getUser();
        if((user != null) && (!flag) ) {
           wishlistPersistence.insertBook(book, user.getEmail());
            return true;
        }
        return false;
    }
}
