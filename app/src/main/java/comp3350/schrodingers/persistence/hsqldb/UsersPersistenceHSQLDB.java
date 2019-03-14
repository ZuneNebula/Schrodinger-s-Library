package comp3350.schrodingers.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.persistence.UsersPersistence;

// Class - implements HSQLDB interactions related to users
public class UsersPersistenceHSQLDB implements UsersPersistence {

    // Holds the DB path name
    private final String dbPath;

    // Store a reference to user persistence and the current logged user
    private PaymentPersistence payPersistence;
    private User logged;

    // Constructor - initialize DB access and current user
    public UsersPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
        logged = findLoggedUser();
    }

    // Method - creates connection to the DB
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    // Method - read results of a DB query
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
            User.Address add = findAddress(address);
            return new User(email, username, password, add, card);
        }
    }

    // Method - insert user into DB
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

    // Method - delete user from DB
    public void deleteUser(final String email) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM user WHERE email = ?");
            st.setString(1, email);
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    // Method - return the currently logged in user
    public User getUser() {
        return logged;
    }

    // Method - updates currently logged user information
    public User editUser(User newUser) {
        if (newUser.getEmail().compareTo(logged.getEmail()) == 0) {
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("UPDATE user SET name = ?, password = ?, logged = TRUE, cardNum = ?, numAndStreet = ? WHERE email = ?");
                st.setString(1, newUser.getUserName());
                st.setString(2, newUser.getPassword());
                st.setLong(3, newUser.getBilling().getCardNumber());
                String address = newUser.getAddress().getAddress();

                if(address.compareTo("") == 0 || address.compareTo("NOADDRESS!") == 0)
                    st.setString(4, "NOADDRESS!");
                else if(logged.getAddress().getAddress().compareTo(address) == 0 && !findAddress(address).isEmpty())
                    st.setString(4, address);
                else{
                    insertAddress(newUser.getAddress());
                    st.setString(4, address);
                }

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

    // Method - finds and returns the currently logged user
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

    // Method - find user by email
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

    // Method - insert address information into user profile
    private User.Address insertAddress(final User.Address address) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO address VALUES(?, ?, ?, ?, ?)");
            st.setString(1, address.getAddress());
            st.setString(2, address.getPostalCode());
            st.setString(3, address.getCity());
            st.setString(4, address.getState());
            st.setString(5, address.getCountry());

            st.executeUpdate();

            return address;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    // Method - insert address information into user profile
    private User.Address findAddress(final String house) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM address WHERE numAndStreet = ?");
            st.setString(1, house);

            final ResultSet rs = st.executeQuery();

            final User.Address address;
            if (rs.next())
                address = fromResultAddress(rs);
            else
                address = new User.Address();

            rs.close();
            st.close();

            return address;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    // Method - read address results of a DB query
    private User.Address fromResultAddress(final ResultSet rs) throws SQLException {
        final String house = rs.getString("numAndStreet");
        final String zip = rs.getString("PC");
        final String city = rs.getString("city");
        final String state = rs.getString("state");
        final String country = rs.getString("country");

        return new User.Address(house, zip, city, state, country);
    }

    // Method - login user based on the email provided
    public User getUserAndLogin(String email) {
        logged = findUser(email);
        return logged;
    }

    // Method - logout current user
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
