package comp3350.schrodingers.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.persistence.UsersPersistence;


// Class - implements HSQLDB interactions related to payment information
public class PaymentPersistenceHSQLDB implements PaymentPersistence {

    // Stores DB path name
    private final String dbPath;

    // Store a reference user persistence
    private UsersPersistence userPersistence;
    private User user;
    private Billing card;

    // Boolean used for testing purposes
    private boolean forTest = false;

    // Constructor - initialize DB access and current credit card
    public PaymentPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
        card = new Billing();
    }

    // Constructor - inject DB access
    public PaymentPersistenceHSQLDB(final String dbPath, UsersPersistence u) {
        this.dbPath = dbPath;
        card = new Billing();
        userPersistence = u;
        forTest = true;
    }

    // Method - creates connection to the DB
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    // Method - read results of a DB query
    private Billing fromResultSet(final ResultSet rs) throws SQLException {
        final long cardNum = rs.getLong("cardNum");
        final String cardName = rs.getString("cardName");
        final String expiryDate = rs.getString("expiryDate");
        final int cvv = rs.getInt("cvv");
        return new Billing(cardNum, cardName, expiryDate, cvv);
    }

    // Method - add credit card to DB
    @Override
    public Billing addCreditCard(Billing creditCard) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO creditCard VALUES(?, ?, ?, ?)");
            st.setLong(1, creditCard.getCardNumber());
            st.setString(2, creditCard.getFullName());
            st.setString(3, creditCard.getExpiry());
            st.setInt(4, creditCard.getCvv());

            st.executeUpdate();

            if(!forTest)
                userPersistence = Services.getUsersPersistence();
                user = userPersistence.getUser();
                userPersistence.editUser(new User(user.getEmail(), user.getUserName(), user.getPassword(), user.getAddress(), creditCard));
                card = creditCard;

                return creditCard;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    // Method - delete credit card from DB
    private void deleteCard(final long number) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM creditCard WHERE cardNum = ?");
            st.setLong(1, number);
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    // Method - update credit card stored in DB
    @Override
    public Billing updateCreditCard(Billing creditCard) {
        try (final Connection c = connection()) {
            if (card.getCardNumber() == creditCard.getCardNumber()) {
                final PreparedStatement st = c.prepareStatement("UPDATE creditCard SET cardName = ?, expiryDate = ?, cvv = ? WHERE cardNum = ?");
                st.setString(1, creditCard.getFullName());
                st.setString(2, creditCard.getExpiry());
                st.setInt(3, creditCard.getCvv());
                st.setLong(4, creditCard.getCardNumber());

                st.executeUpdate();
                card = creditCard;
            } else {
                if(!forTest)
                    userPersistence = Services.getUsersPersistence();
                user = userPersistence.getUser();
                userPersistence.editUser(new User(user.getEmail(), user.getUserName(), user.getPassword(), user.getAddress(), new User.Billing()));
                deleteCard(card.getCardNumber());
                card = addCreditCard(creditCard);
            }

            return creditCard;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    // Method - return all billing information associated with current user
    @Override
    public Billing getCard() {
        return card;
    }

    // Method - return all billing information from DB with associated with credit card number
    @Override
    public Billing findCard(final long number) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM creditCard WHERE cardNum = ?");
            st.setLong(1, number);

            final ResultSet rs = st.executeQuery();
            final Billing b;
            if (rs.next())
                b = fromResultSet(rs);
            else
                b = new Billing();

            rs.close();
            st.close();

            card = b;

            return b;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
