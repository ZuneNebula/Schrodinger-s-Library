package comp3350.schrodingers.application;

import comp3350.schrodingers.persistence.BooksPersistence;
import comp3350.schrodingers.persistence.RatingPersistence;
import comp3350.schrodingers.persistence.hsqldb.BooksPersistenceHSQLDB;
import comp3350.schrodingers.persistence.UsersPersistence;
import comp3350.schrodingers.persistence.hsqldb.UsersPersistenceHSQLDB;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.persistence.hsqldb.PaymentPersistenceHSQLDB;
import comp3350.schrodingers.persistence.stubs.PaymentPersistenceStub;
import comp3350.schrodingers.persistence.stubs.UsersPersistenceStub;
import comp3350.schrodingers.persistence.stubs.BooksPersistenceStub;
import comp3350.schrodingers.persistence.hsqldb.RatingPersistenceHSQLDB;
public class Services {

    private static BooksPersistence booksPersistence = null;
    private static UsersPersistence usersPersistence = null;
    private static PaymentPersistence paymentPersistence = null;
    private static RatingPersistence ratingPersistence = null;

    public static synchronized BooksPersistence getBooksPersistence() {
        if (booksPersistence == null) {
            //booksPersistence= new BooksPersistenceStub();
            booksPersistence = new BooksPersistenceHSQLDB(Main.getDBPathName());
        }
        return booksPersistence;
    }

    public static synchronized RatingPersistence getRatePersistence() {
        if (ratingPersistence == null) {
            ratingPersistence = new RatingPersistenceHSQLDB(Main.getDBPathName());
        }
        return ratingPersistence;
    }

    public static synchronized UsersPersistence getUsersPersistence() {
        if (usersPersistence == null) {
            //usersPersistence= new UsersPersistenceStub();
            usersPersistence = new UsersPersistenceHSQLDB(Main.getDBPathName());
        }
        return usersPersistence;
    }

    public static synchronized PaymentPersistence getPaymentPersistence() {
        if (paymentPersistence == null) {
            //paymentPersistence = new PaymentPersistenceStub();
            paymentPersistence = new PaymentPersistenceHSQLDB(Main.getDBPathName());
        }
        return paymentPersistence;
    }

}
