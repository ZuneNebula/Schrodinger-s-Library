package comp3350.schrodingers.application;

import comp3350.schrodingers.persistence.BooksPersistence;
import comp3350.schrodingers.persistence.stubs.booksPersistenceStub;
import comp3350.schrodingers.persistence.UsersPersistence;
import comp3350.schrodingers.persistence.stubs.UsersPersistenceStub;

public class Services {
    private static BooksPersistence booksPersistence = null;
    private static UsersPersistence usersPersistence = null;

    public static synchronized BooksPersistence getBooksPersistence(){
        if (booksPersistence == null){
            booksPersistence= new booksPersistenceStub();
        }
        return booksPersistence;
    }

    public static synchronized UsersPersistence getUsersPersistence(){
        if (usersPersistence == null){
            usersPersistence= new UsersPersistenceStub();
        }
        return usersPersistence;
    }

}
