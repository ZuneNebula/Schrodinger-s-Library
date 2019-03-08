package comp3350.schrodingers.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.objects.Ratings;
import comp3350.schrodingers.persistence.RatingPersistence;

public class RatingPersistenceHSQLDB implements RatingPersistence {

    private final String dbPath;


    public RatingPersistenceHSQLDB(String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Ratings fromResultSet(final ResultSet rs) throws SQLException {
        final int rateID = rs.getInt("rateID");
        final int bookID = rs.getInt("bookID");
        final String email = rs.getString("email");
        final int rate = rs.getInt("rate");

        return new Ratings(rateID,bookID,email,rate);
    }


    @Override
    public List<Ratings> getBookRatings(){
        List<Ratings> rateList = new ArrayList<>();
        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM ratings");
            while (rs.next()) {
                Ratings rates = fromResultSet(rs);
                rateList.add(rates);
            }
            rs.close();
            st.close();

            return rateList;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void addBookRatings(int rate, String user){
        List<Ratings> rateList = new ArrayList<>();
        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            //update book set rate = ? where bookId = ?
            //insert into ratings ...
            int lastID = st.executeQuery("SELECT MAX(RATEID) FROM ratings").getInt(1);
            int newID = lastID + 1;
            final ResultSet rs = st.executeQuery("INSERT INTO ratings VALUES(" + newID + "," + user +"," + rate + ")"  );

            rs.close();
            st.close();


        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }


}
