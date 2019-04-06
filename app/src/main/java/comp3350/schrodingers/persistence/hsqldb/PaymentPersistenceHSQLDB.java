package comp3350.schrodingers.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.persistence.PaymentPersistence;

public class PaymentPersistenceHSQLDB implements PaymentPersistence {
    private final String dbPath;
    private Billing card;

    public PaymentPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
        card = new Billing();
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Billing fromResultSet(final ResultSet rs) throws SQLException {
        final long cardNum = rs.getLong("cardNum");
        final String cardName = rs.getString("cardName");
        final String expiryDate = rs.getString("expiryDate");
        final int cvv = rs.getInt("cvv");
        return new Billing(cardNum, cardName, expiryDate, cvv);
    }

    @Override
    public void addCreditCard(Billing creditCard) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO creditCard VALUES(?, ?, ?, ?)");
            st.setLong(1, creditCard.getCardNumber());
            st.setString(2, creditCard.getFullName());
            st.setString(3, creditCard.getExpiry());
            st.setInt(4, creditCard.getCvv());

            st.executeUpdate();
            card = creditCard;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private void deleteCard(final long number) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM creditCard WHERE cardNum = ?");
            st.setLong(1, number);
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void updateCreditCard(Billing creditCard) {
        try (final Connection c = connection()) {
            if (card.getCardNumber() == creditCard.getCardNumber()) {
                final PreparedStatement st = c.prepareStatement("UPDATE creditCard SET cardName = ?, expiryDate = ?, cvv = ? WHERE cardNum = ?");
                st.setString(1, creditCard.getFullName());
                st.setString(2, creditCard.getExpiry());
                st.setInt(3, creditCard.getCvv());
                st.setLong(4, creditCard.getCardNumber());

                st.executeUpdate();
            } else {
                deleteCard(card.getCardNumber());
                addCreditCard(creditCard);
            }

            card = creditCard;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Billing getCard() {
        return card;
    }

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
