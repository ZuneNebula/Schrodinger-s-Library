package comp3350.schrodingers.persistence.hsqldb;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.persistence.PurchasedBooks;

public class PurchasedBooksHSQLDB implements PurchasedBooks {
    private final String dbPath;

    public PurchasedBooksHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

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


    private List<Integer> getBookIDs(String email){
        List<Integer> bookList = new ArrayList<>();
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT bookId FROM purchased WHERE email = ?");
            st.setString(1, email);

            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int book = rs.getInt("bookId");
                bookList.add(book);
            }
            rs.close();
            st.close();

            return bookList;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<Book> getBooks(String email){
        List<Integer> bookIds = getBookIDs(email);
        List<Book> bookList = new ArrayList<>();
        try (final Connection c = connection()) {
            for(int i =0; i<bookIds.size(); i++) {
                final Statement st = c.createStatement();
                final ResultSet rs = st.executeQuery("SELECT * FROM books where bookId = "+bookIds.get(i));
                while (rs.next()) {
                    Book book = fromResultSet(rs);
                    bookList.add(book);
                }
                rs.close();
                st.close();
            }

            return bookList;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void insertBook(Book book, String userEmail){
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO purchased VALUES(?, ?)");
            st.setString(1, userEmail);
            st.setInt(2, book.getBookID());

            st.executeUpdate();

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
