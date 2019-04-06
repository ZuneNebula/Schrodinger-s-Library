package comp3350.schrodingers.application;

import comp3350.schrodingers.business.AccessBooks;
import comp3350.schrodingers.business.AccessPaymentInfo;
import comp3350.schrodingers.business.AccessPurchasedBooks;
import comp3350.schrodingers.business.AccessRatings;
import comp3350.schrodingers.business.AccessShoppingCart;
import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.business.AccessWishlist;
import comp3350.schrodingers.persistence.BooksPersistence;
import comp3350.schrodingers.persistence.hsqldb.BooksPersistenceHSQLDB;
import comp3350.schrodingers.persistence.PurchasedBooks;
import comp3350.schrodingers.persistence.hsqldb.PurchasedBooksHSQLDB;
import comp3350.schrodingers.persistence.RatingPersistence;
import comp3350.schrodingers.persistence.hsqldb.RatingPersistenceHSQLDB;
import comp3350.schrodingers.persistence.ShoppingCartPersistence;
import comp3350.schrodingers.persistence.hsqldb.ShoppingCartPersistenceHSQLDB;
import comp3350.schrodingers.persistence.UsersPersistence;
import comp3350.schrodingers.persistence.hsqldb.UsersPersistenceHSQLDB;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.persistence.hsqldb.PaymentPersistenceHSQLDB;
import comp3350.schrodingers.persistence.WishlistPersistence;
import comp3350.schrodingers.persistence.hsqldb.WishlistPersistenceHSQLDB;

public class Services {

    // Store access to logic layer classes
    private static AccessBooks bookAccess = null;
    private static AccessPaymentInfo paymentInfoAccess = null;
    private static AccessUserInfo userInfoAccess = null;
    private static AccessPurchasedBooks purchasedBooksAccess = null;

    // Stores the various types of access to the DB.
    private static BooksPersistence booksPersistence = null;
    private static PaymentPersistence paymentPersistence = null;
    private static UsersPersistence usersPersistence = null;
    private static PurchasedBooks purchasedPersistence = null;
    private static RatingPersistence ratingPersistence = null;
    private static WishlistPersistence wishlistPersistence = null;
    private static ShoppingCartPersistence shoppingCartPersistence = null;

    // Singleton logic classes (inject DB access).

    public static synchronized AccessBooks getBookAccess(){
        booksPersistence = getBooksPersistence();
        if(bookAccess == null){
            bookAccess = new AccessBooks(booksPersistence);
        }
        return bookAccess;
    }

    public static synchronized AccessPaymentInfo getPaymentInfoAccess(){
        paymentPersistence = getPaymentPersistence();
        if(paymentInfoAccess == null){
            paymentInfoAccess = new AccessPaymentInfo(paymentPersistence);
        }
        return paymentInfoAccess;
    }

    public static synchronized AccessUserInfo getUserInfoAccess(){
        usersPersistence = getUsersPersistence();
        if(userInfoAccess == null){
            userInfoAccess = new AccessUserInfo(usersPersistence);
        }
        return userInfoAccess;
    }

//    public static synchronized AccessPurchasedBooks getPurchasedBooksAccess(){
//        purchasedPersistence = getPurchasedPersistence();
//        if(purchasedBooksAccess == null){
//            purchasedBooksAccess = new AccessPurchasedBooks(purchasedPersistence);
//        }
//        return purchasedBooksAccess;
//    }

    public static synchronized AccessRatings getRatingsAccess(){
        return null;
    }

    public static synchronized AccessShoppingCart getShoppingCartAccess(){
        return null;
    }

    public static synchronized AccessWishlist getWishlistAccess(){
        return null;
    }

    // Singleton persistence layer (initialize db access).

    // Return reference to DB for storage and access of book information.
    private static synchronized BooksPersistence getBooksPersistence() {
        if (booksPersistence == null) {
            booksPersistence = new BooksPersistenceHSQLDB(Main.getDBPathName());
        }
        return booksPersistence;
    }

    // Return reference to DB for storage and access of rating information.
    public static synchronized RatingPersistence getRatePersistence() {
        if (ratingPersistence == null) {
            ratingPersistence = new RatingPersistenceHSQLDB(Main.getDBPathName());
        }
        return ratingPersistence;
    }

    // Return reference to DB for storage and access of rating information.
    public static synchronized UsersPersistence getUsersPersistence() {
        if (usersPersistence == null) {
            usersPersistence = new UsersPersistenceHSQLDB(Main.getDBPathName());
        }
        return usersPersistence;
    }

    // Return reference to DB for storage and access of rating information.
    public static synchronized PaymentPersistence getPaymentPersistence() {
        if (paymentPersistence == null) {
            paymentPersistence = new PaymentPersistenceHSQLDB(Main.getDBPathName());
        }
        return paymentPersistence;
    }

    public static synchronized PurchasedBooks getPurchasedPersistence() {
        if (purchasedPersistence == null) {
            purchasedPersistence = new PurchasedBooksHSQLDB(Main.getDBPathName());
        }
        return purchasedPersistence;
    }


    public static synchronized WishlistPersistence getWishlistPersistence() {
        if (wishlistPersistence == null) {
            wishlistPersistence = new WishlistPersistenceHSQLDB(Main.getDBPathName());
        }
        return wishlistPersistence;
    }

    public static synchronized ShoppingCartPersistence getShoppingCartPersistence() {
        if (wishlistPersistence == null) {
            shoppingCartPersistence = new ShoppingCartPersistenceHSQLDB(Main.getDBPathName());
        }
        return shoppingCartPersistence;
    }

}
