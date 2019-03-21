package comp3350.schrodingers.application;

import comp3350.schrodingers.persistence.BooksPersistence;
import comp3350.schrodingers.persistence.PurchasedBooks;
import comp3350.schrodingers.persistence.RatingPersistence;
import comp3350.schrodingers.persistence.hsqldb.BooksPersistenceHSQLDB;
import comp3350.schrodingers.persistence.UsersPersistence;
import comp3350.schrodingers.persistence.hsqldb.PurchasedBooksHSQLDB;
import comp3350.schrodingers.persistence.hsqldb.UsersPersistenceHSQLDB;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.persistence.hsqldb.PaymentPersistenceHSQLDB;
import comp3350.schrodingers.persistence.hsqldb.WishlistPersistenceHSQLDB;
import comp3350.schrodingers.persistence.WishlistPersistence;
import comp3350.schrodingers.persistence.hsqldb.RatingPersistenceHSQLDB;

public class Services {

    // Stores the various types of access to the DB
    private static BooksPersistence booksPersistence = null;
    private static UsersPersistence usersPersistence = null;
    private static PaymentPersistence paymentPersistence = null;
    private static RatingPersistence ratingPersistence = null;
    private static PurchasedBooks purchasedPersistence = null;
    private static WishlistPersistence wishlistPersistence = null;

    // Return reference to DB for storage and access of book information
    public static synchronized BooksPersistence getBooksPersistence() {
        if (booksPersistence == null) {
            booksPersistence = new BooksPersistenceHSQLDB(Main.getDBPathName());
        }
        return booksPersistence;
    }

    // Return reference to DB for storage and access of rating information
    public static synchronized RatingPersistence getRatePersistence() {
        if (ratingPersistence == null) {
            ratingPersistence = new RatingPersistenceHSQLDB(Main.getDBPathName());
        }
        return ratingPersistence;
    }

    // Return reference to DB for storage and access of rating information
    public static synchronized UsersPersistence getUsersPersistence() {
        if (usersPersistence == null) {
            usersPersistence = new UsersPersistenceHSQLDB(Main.getDBPathName());
        }
        return usersPersistence;
    }

    // Return reference to DB for storage and access of rating information
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

}
