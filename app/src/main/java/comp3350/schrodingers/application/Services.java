package comp3350.schrodingers.application;

import comp3350.schrodingers.persistence.BooksPersistence;
import comp3350.schrodingers.persistence.stubs.booksPersistenceStub;
public class Services {
    public static BooksPersistence booksPersistence= null;

    public static synchronized BooksPersistence getBooksPersistence(){
        if (booksPersistence == null){
            booksPersistence= new booksPersistenceStub();
        }
        return booksPersistence;
    }

}
