package comp3350.schrodingers.objects;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static class Address{  // class which stores the address
        private String streetAndNumber;
        private String postalCode;
        private String city;
        private String state;
        private String country;
        public Address(){
            streetAndNumber = "";
            postalCode = "";
            state = "";
            country = "";
            city = "";
        }
        public Address(String streetName, String postalCode, String city, String state, String country)
        {
            this.streetAndNumber = streetName;
            this.postalCode = postalCode;
            this.state = state;
            this.country = country;
            this.city = city;
        }
        public String getAddress(){
            return streetAndNumber;
        }
        public String getPostalCode(){
            return postalCode;
        }
        public String getState(){
            return state;
        }
        public String getCountry(){
            return country;
        }
        public String getCity(){
            return city;
        }

        public boolean isEmpty(){
            return streetAndNumber.equals("");
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
    boolean isLoggedIn = false;
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
        address = new Address();
    }
    public User(String email, String username, String password, Address address, List<Billing> billing) // constructor
    {//input field tests
        assert (email!=null);
        assert(username!=null);
        assert (password!=null);

        this.email = email;
        this.username = username;
        this.password = password;
        this.billing = billing;
        this.address = address;
    }

    public String getUserName() {return username;}

    public String getEmail() { return email;}

    public String getPassword() {return password;}

    public List<Billing> getBilling(){
        return billing;
    }

    public Address getAddress(){
        return address;
    }

}
