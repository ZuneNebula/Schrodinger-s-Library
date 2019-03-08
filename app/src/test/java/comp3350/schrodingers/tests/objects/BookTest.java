package comp3350.schrodingers.tests.objects;

import org.junit.Test;
import comp3350.schrodingers.objects.Book;
import static org.junit.Assert.*;
public class BookTest {
    @Test
    public void testBook1(){
        Book book;
        System.out.println("\nStarting testBook1");
        book = new Book(1,"book1","author1","$100","random","10","4","icon");
        assertNotNull("it is not null", book);
        assertTrue(1 == book.getBookID());
        assertTrue("book1".equals(book.getBookName()));
        assertTrue("author1".equals(book.getAuthor()));
        assertTrue("$100".equals(book.getPrice()));
        assertTrue("random".equals(book.getGenre()));
        assertTrue("10".equals(book.getBookStock()));
        assertTrue("4".equals(book.getRating()));
        assertTrue("icon".equals(book.getIconId()));

        System.out.println("Finished testBook1");
    }
}
