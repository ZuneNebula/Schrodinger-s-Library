package comp3350.schrodingers.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.business.AccessPurchasedBooks;
import comp3350.schrodingers.business.UserException;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.persistence.PurchasedBooks;
import comp3350.schrodingers.tests.persistence.UsersPersistenceStub;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class AccessPurchaseHistoryTest {
    private AccessPurchasedBooks accessPurchased;
    private PurchasedBooks booksPersistence;
    @Before
    public void setup(){
        booksPersistence = mock(PurchasedBooks.class);
        accessPurchased = new AccessPurchasedBooks(booksPersistence, new UsersPersistenceStub());
    }

    @Test
    public void testGet(){
        System.out.println("\nStarting test AccessPurchasedBooks");
        final Book book;
        final List<Book> books = new ArrayList<>();
        books.add(new Book(21, "Whirlwind", "Natalie Hamilton", "$400", "Non-Fiction", "30", "whirlwind"));
        when(booksPersistence.getBooks(1)).thenReturn(books);
        try {
            book = accessPurchased.getBooks().get(0);
            assertNotNull("\tbook for default user should not be null", book);
            assertEquals(book.getBookID(), 21);
            verify(booksPersistence).getBooks(1);
            System.out.println("\nFinished test AccessPurchasedBooks");
        }catch(UserException u){
            System.out.println("\t"+u.toString());
        }

    }

}
