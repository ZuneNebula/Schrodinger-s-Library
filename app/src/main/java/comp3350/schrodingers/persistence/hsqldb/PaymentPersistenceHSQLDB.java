package comp3350.schrodingers.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.persistence.PaymentPersistence;

public class PaymentPersistenceHSQLDB implements PaymentPersistence {
    private final Connection c;
    public PaymentPersistenceHSQLDB(final String dbPath){
        try {
            this.c = DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath, "SA", "");
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
    private Billing fromResultSet(final ResultSet rs) throws SQLException {
        final long cardNum = rs.getLong("cardNum");
        final String cardName = rs.getString("cardName");
        final String expiryDate = rs.getString("expiryDate");
        final int cvv = rs.getInt("cvv");
        return new Billing(cardNum,cardName,expiryDate,cvv);
    }
    public Billing addCreditCard(Billing creditCard){
        try {
            final PreparedStatement st = c.prepareStatement("INSERT INTO creditCard VALUES(?, ?, ?, ?)");
            st.setLong(1, creditCard.getCardNumber());
            st.setString(2, creditCard.getFullName());
            st.setString(3, creditCard.getExpiry());
            st.setInt(4, creditCard.getCvv());

            st.executeUpdate();

            return creditCard;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
    public Billing updateCreditCard(Billing creditCard){
        try {
            final PreparedStatement st = c.prepareStatement("UPDATE creditCard SET name = ? WHERE cardNum = ?");
            st.setLong(1, creditCard.getCardNumber());
            st.setString(2, creditCard.getFullName());
            st.setString(3, creditCard.getExpiry());
            st.setInt(4, creditCard.getCvv());

            st.executeUpdate();

            return creditCard;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
    public void deleteCreditCard(Billing creditCard){

    }

    public List<Billing> getCards(){
        final List<Billing> cards = new ArrayList<>();

        try{
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM courses");
            while (rs.next()){
                final Billing card = fromResultSet(rs);
                cards.add(card);
            }
            rs.close();
            st.close();

            return cards;
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }
}
