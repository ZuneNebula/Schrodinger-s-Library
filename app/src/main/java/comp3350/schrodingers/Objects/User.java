package comp3350.schrodingers.Objects;

import java.util.Date;
public class User {

    public class Address{  // class which stores the address
        private int houseNumber;
        private String streetName;
        private String postalCode;
        private String state;
        private String country;
        public Address(int houseNumber, String streetName, String postalCode,String state, String country)
        {
            this.houseNumber = houseNumber;
            this.streetName = streetName;
            this.postalCode = postalCode;
            this.state = state;
            this.country = country;
        }
    }

    public static class Billing{ // class which stores billing information
        private int cardNumber;
        private String fullName;
        private Date expiry;
        int cvv;
        public Billing(int cardNumber, String fullName, Date expiry, int cvv)
        {
            this.cardNumber = cardNumber;
            this.fullName = fullName;
            this.expiry = expiry;
            this.cvv = cvv;
        }


        public String toString(){
            return "Visa ending in"+ (cardNumber%1000);
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
