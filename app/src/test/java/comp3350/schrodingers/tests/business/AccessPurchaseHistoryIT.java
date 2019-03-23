package comp3350.schrodingers.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testGet(){
        System.out.println("\nStarting test AccessPurchasedBooks: getBooks");
        List<Book> books = accessPurchased.getBooks();
        assertNotNull("\tfirst book of default user should not be null", books.get(0));
        System.out.println("\nFinished test AccessPurchasedBooks: getBooks");
    }

    @Test
    public void testInsert(){
        System.out.println("\nStarting AccessPurchasedBooks: insertBook");
        Book book = new Book(1, "Annabelle Fights Life", "Jenny Springs", "$200", "Drama", "10", "annabellefightslife");
        accessPurchased.insertBook(book);
        Book getBook = accessPurchased.getBooks().get(0);
        assertNotNull("\tbook must not be null", getBook);
        assertEquals(getBook.getBookID(), book.getBookID());
        System.out.println("Finished AccessPurchasedBooks: insertBook");
    }
    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}

