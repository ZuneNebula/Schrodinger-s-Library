package comp3350.schrodingers.application;

import comp3350.schrodingers.persistence.BooksPersistence;
import comp3350.schrodingers.persistence.hsqldb.BooksPersistenceHSQLDB;
import comp3350.schrodingers.persistence.UsersPersistence;
import comp3350.schrodingers.persistence.hsqldb.UsersPersistenceHSQLDB;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.persistence.hsqldb.PaymentPersistenceHSQLDB;

import comp3350.schrodingers.persistence.stubs.BooksPersistenceStub;
import comp3350.schrodingers.persistence.stubs.PaymentPersistenceStub;
import comp3350.schrodingers.persistence.stubs.UsersPersistenceStub;

public class Services {

    private static BooksPersistence booksPersistence = null;
    private static UsersPersistence usersPersistence = null;
    private static PaymentPersistence paymentPersistence = null;

    public static synchronized BooksPersistence getBooksPersistence(){
        if (booksPersistence == null){
            //booksPersistence= new BooksPersistenceHSQLDB();
            booksPersistence= new BooksPersistenceStub();
        }
        return booksPersistence;
    }

    public static synchronized UsersPersistence getUsersPersistence(){
        if (usersPersistence == null){
            //usersPersistence= new UsersPersistenceHSQLDB(Main.getDBPathName());
            usersPersistence= new UsersPersistenceStub();
        }
        return usersPersistence;
    }

    public static synchronized PaymentPersistence getPaymentPersistence(){
        if (paymentPersistence == null){
            //paymentPersistence = new PaymentPersistenceHSQLDB(Main.getDBPathName());
            paymentPersistence = new PaymentPersistenceStub();
        }
        return paymentPersistence;
    }

}
