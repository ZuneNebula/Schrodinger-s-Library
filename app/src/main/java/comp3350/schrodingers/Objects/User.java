package comp3350.schrodingers.Objects;

import java.util.Date;
public class User {

    public class Address{  // class which stores the address
        int houseNumber;
        String streetName;
        String postalCode;
        String state;
        String country;
        public Address(int houseNumber, String streetName, String postalCode,String state, String country)
        {
            this.houseNumber = houseNumber;
            this.streetName = streetName;
            this.postalCode = postalCode;
            this.state = state;
            this.country = country;
        }
    }

    public class Billing{ // class which stores billing information
        double cardNumber;
        String fullName;
        Date expiry;
        int CV;
        public Billing(int cardNumber, String fullName, Date expiry, int CV)
        {
            this.cardNumber = cardNumber;
            this.fullName = fullName;
            this.expiry = expiry;
            this.CV = CV;
        }
    }

    private String email;  // distinct key
    private final String username;
    private String password;
    boolean isAddress = false; // to keep track if the user has added address/billing info or not
    boolean isBilling = false;
    private Address address;
    private Billing billing;

    public User(String email, String username, String password) // constructor
    {//input field tests
        assert (email!=null);
        assert(username!=null);
        assert (password!=null);

        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getUserName() {return username;}

    public String getEmail() { return email;}

}
