package comp3350.schrodingers.Objects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
        private long cardNumber;
        private String fullName;
        private String expiry;
        private int cvv;
        public Billing(long cardNumber, String fullName, String expiry, int cvv)
        {
            this.cardNumber = cardNumber;
            this.fullName = fullName;
            this.expiry = expiry;
            this.cvv = cvv;
        }
        public long getCardNumber(){
            return cardNumber;
        }
        public String getFullName(){
            return fullName;
        }
        public String getExpiry(){
            return expiry;
        }
        public int getCvv(){
            return cvv;
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
    private List<Billing> billing;

    public User(String email, String username, String password) // constructor
    {//input field tests
        assert (email!=null);
        assert(username!=null);
        assert (password!=null);

        this.email = email;
        this.username = username;
        this.password = password;
        billing = new ArrayList<>();
    }

    public String getUserName() {return username;}

    public String getEmail() { return email;}

    public List<Billing> getBilling(){
        return billing;
    }


}
