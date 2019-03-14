package comp3350.schrodingers.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.persistence.BooksPersistence;

// Class - implements HSQLDB interactions related to books
public class BooksPersistenceHSQLDB implements BooksPersistence {

    // Holds the DB path name
    private final String dbPath;

    // Constructor - initializes access to the DB
    public BooksPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    // Method - creates connection to the DB
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    // Method - read results of a DB query
    private Book fromResultSet(final ResultSet rs) throws SQLException {
        final int bookID = rs.getInt("bookID");
        final String bookName = rs.getString("bookName");
        final String author = rs.getString("author");
        final String price = rs.getString("price");
        final String genre = rs.getString("genre");
        final String stock = rs.getString("stock");
        final String rating = rs.getString("rating");
        final String iconId = rs.getString("iconId");
        return new Book(bookID, bookName, author, price, genre, stock, rating, iconId);
    }

    // Method - acquires all currently stored books in the DB
    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                Book book = fromResultSet(rs);
                bookList.add(book);
            }
            rs.close();
            st.close();

            return bookList;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }
}
