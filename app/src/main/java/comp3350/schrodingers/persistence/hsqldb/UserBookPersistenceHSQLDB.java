package comp3350.schrodingers.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.objects.UserBook;
import comp3350.schrodingers.persistence.UserBookPersistence;

public class UserBookPersistenceHSQLDB implements UserBookPersistence {

    private final String dbPath;

    public UserBookPersistenceHSQLDB(String dbPath) {
        this.dbPath = dbPath;
    }
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private String fromResultSet(final ResultSet rs) throws SQLException {
        final String book = rs.getString("book");
        return book;
    }

    @Override
    public UserBook insertUser(UserBook newUser) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO userbook VALUES(?, ?)");
            st.setString(1, newUser.getName() );
            st.setString(2, newUser.getBook());

            st.executeUpdate();

            return newUser;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<String> addedBook(User newUser) {
        final List<String> books = new ArrayList<>();

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT book FROM userbook WHERE name=?");
            st.setString(1, newUser.getUserName());

            final ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                final String book = fromResultSet(rs);
                books.add(book);
            }
            rs.close();
            st.close();

            return books;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }
}
