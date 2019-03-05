package comp3350.schrodingers.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        logged = findUser("zunenebula@gmail.com");
        //TODO: infinite loop here
        payPersistence = Services.getPaymentPersistence();
    }
    private Connection connection() throws SQLException{

        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private User fromResultSet(final ResultSet rs) throws SQLException {
        final String email = rs.getString("email");
        final String username = rs.getString("name");
        final String password = rs.getString("password");
        final long cardNum = rs.getLong("cardNum");
        final String address = rs.getString("numAndStreet");

        if(cardNum == 0 && address.compareTo("") == 0)
            return new User(email,username,password);
        else{
            User.Billing card = payPersistence.getCard();
            return new User(email,username,password,new User.Address(),card);
        }
    }

    public User insertUser (final User newUser){
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO user VALUES(?, ?, ?, ?, ?)");
            st.setString(1, newUser.getEmail());
            st.setString(2, newUser.getUserName());
            st.setString(2, newUser.getPassword());
            st.setLong(2, newUser.getBilling().getCardNumber());
            st.setString(2, newUser.getAddress().getAddress());

            st.executeUpdate();
            logged = newUser;
            return logged;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
    public void  deleteUser (final String email){
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("DELETE FROM user WHERE email = ?");
            st.setString(1, email);
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
    public User getUser(){
        return logged;
    }
    public User editUser(User newUser){
        deleteUser(logged.getEmail());
        insertUser(newUser);
        return logged;
    }
    public User findUser(final String email){
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM user WHERE email = ?");
            st.setString(1, email);

            final ResultSet rs = st.executeQuery();

            final User user;
            if(rs.next())
                user = fromResultSet(rs);
            else
                user = null;

            rs.close();
            st.close();

            return user;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }
    private User findByAddress(final String house){
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM user WHERE numAndStreet = ?");
            st.setString(1, house);

            final ResultSet rs = st.executeQuery();

            final User user = fromResultSet(rs);

            rs.close();
            st.close();

            return user;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }
    public User getUserAndLogin(String email){
        logged = findUser(email);
        return logged;
    }
    public boolean logout(){return false;}

}
