package comp3350.schrodingers.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.persistence.UsersPersistence;

public class UsersPersistenceHSQLDB implements UsersPersistence {

    private final String dbPath;

    private User logged;
    private PaymentPersistence payPersistence;

    public UsersPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
        logged = findLoggedUser();
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private User fromResultSet(final ResultSet rs) throws SQLException {
        final String email = rs.getString("email");
        final String username = rs.getString("name");
        final String password = rs.getString("password");
        final long cardNum = rs.getLong("cardNum");
        final String address = rs.getString("numAndStreet");

        if (cardNum == 0 && address.compareTo("") == 0)
            return new User(email, username, password);
        else {
            payPersistence = Services.getPaymentPersistence();
            User.Billing card = payPersistence.findCard(cardNum);
            return new User(email, username, password, new User.Address(), card);
        }
    }

    public User insertUser(final User newUser) {
        try (final Connection c = connection()) {
            final Statement up = c.createStatement();
            up.executeQuery("UPDATE user SET LOGGED = FALSE");

            final PreparedStatement st = c.prepareStatement("INSERT INTO user VALUES(?, ?, ?, ?, ?, ?)");
            st.setString(1, newUser.getEmail());
            st.setString(2, newUser.getUserName());
            st.setString(3, newUser.getPassword());
            st.setBoolean(4, true);
            st.setLong(5, newUser.getBilling().getCardNumber());
            if (newUser.getAddress().getAddress().compareTo("") != 0)
                st.setString(6, newUser.getAddress().getAddress());
            else
                st.setString(6, "NOADDRESS!");

            st.executeUpdate();
            logged = newUser;
            return logged;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    public void deleteUser(final String email) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM user WHERE email = ?");
            st.setString(1, email);
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    public User getUser() {
        return logged;
    }

    public User editUser(User newUser) {
        if (newUser.getEmail().compareTo(logged.getEmail()) == 0) {
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("UPDATE user SET name = ?, password = ?, logged = TRUE, cardNum = ?, numAndStreet = ? WHERE email = ?");
                st.setString(1, newUser.getUserName());
                st.setString(2, newUser.getPassword());
                st.setLong(3, newUser.getBilling().getCardNumber());
                if (newUser.getAddress().getAddress().compareTo("") != 0)
                    st.setString(4, newUser.getAddress().getAddress());
                else
                    st.setString(4, "NOADDRESS!");
                st.setString(5, logged.getEmail());

                st.executeUpdate();

                logged = newUser;
                return logged;
            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
        } else {
            deleteUser(logged.getEmail());
            insertUser(newUser);
        }
        return logged;
    }

    public User findLoggedUser() {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM user WHERE logged = TRUE");

            final ResultSet rs = st.executeQuery();

            final User user;
            if (rs.next())
                user = fromResultSet(rs);
            else
                user = null;

            rs.close();
            st.close();

            return user;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    public User findUser(final String email) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM user WHERE email = ?");
            st.setString(1, email);

            final ResultSet rs = st.executeQuery();

            final User user;
            if (rs.next())
                user = fromResultSet(rs);
            else
                user = null;

            rs.close();
            st.close();

            return user;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private User findByAddress(final String house) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM user WHERE numAndStreet = ?");
            st.setString(1, house);

            final ResultSet rs = st.executeQuery();

            final User user = fromResultSet(rs);

            rs.close();
            st.close();

            return user;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    public User getUserAndLogin(String email) {
        logged = findUser(email);
        return logged;
    }

    public boolean logout() {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE user SET LOGGED = FALSE WHERE email=?");
            st.setString(1, logged.getEmail());
            st.executeUpdate();
            logged = null;
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

}
