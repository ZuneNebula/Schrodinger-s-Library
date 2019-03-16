package comp3350.schrodingers.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import comp3350.schrodingers.business.AccessPurchasedBooks;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.persistence.PurchasedBooks;
import comp3350.schrodingers.persistence.UsersPersistence;
import comp3350.schrodingers.persistence.hsqldb.PurchasedBooksHSQLDB;
import comp3350.schrodingers.persistence.hsqldb.UsersPersistenceHSQLDB;
import comp3350.schrodingers.tests.utils.TestUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AccessPurchaseHistoryIT {
    private AccessPurchasedBooks accessPurchased;
    private File tempDB;

    @Before
    public void setup() throws IOException{
        this.tempDB = TestUtils.copyDB();
        final PurchasedBooks purchasedBooks = new PurchasedBooksHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        final UsersPersistence userPers = new UsersPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));

        this.accessPurchased = new AccessPurchasedBooks(purchasedBooks, userPers);
    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}

