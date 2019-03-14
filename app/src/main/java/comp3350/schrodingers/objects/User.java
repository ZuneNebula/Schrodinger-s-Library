package comp3350.schrodingers.objects;

// Class - holds all info associated with a given user
public class User {

    // Stores user info
    private String email;  // distinct key
    private final String username;
    private String password;
    boolean isLoggedIn = false;
    private Address address;
    private Billing billing;

    // Constructor - creates basic user with only login credentials
    public User(String email, String username, String password) // constructor
    {
        assert (email != null);
        assert (username != null);
        assert (password != null);

        this.email = email;
        this.username = username;
        this.password = password;
        billing = new Billing();
        address = new Address();
    }

    // Constructor - creates detailed user with address and billing info
    public User(String email, String username, String password, Address address, Billing billing) // constructor
    {
        assert (email != null);
        assert (username != null);
        assert (password != null);

        this.email = email;
        this.username = username;
        this.password = password;
        this.billing = billing;
        this.address = address;
    }

    // Method - returns username of current user
    public String getUserName() {
        return username;
    }

    // Method - returns email of current user
    public String getEmail() {
        return email;
    }

    // Method - returns password of current user
    public String getPassword() {
        return password;
    }

    // Method - returns billing info (as billing class) of current user
    public Billing getBilling() {
        return billing;
    }

    // Method - returns address info (as address class) of current user
    public Address getAddress() {
        return address;
    }

    // Class - stores address information
    public static class Address {

        // Stores relevant address info
        private String streetAndNumber;
        private String postalCode;
        private String city;
        private String state;
        private String country;

        // Default Constructor - initializes empty address information
        public Address() {
            streetAndNumber = "NOADDRESS!";
            postalCode = "";
            state = "";
            country = "";
            city = "";
        }

        // Constructor - initializes user entered address information
        public Address(String streetName, String postalCode, String city, String state, String country) {
            this.streetAndNumber = streetName;
            this.postalCode = postalCode;
            this.state = state;
            this.country = country;
            this.city = city;
        }

        // Method - returns current address
        public String getAddress() {
            return streetAndNumber;
        }

        // Method - returns postal code
        public String getPostalCode() {
            return postalCode;
        }

        // Method - returns state
        public String getState() {
            return state;
        }

        // Method - returns province
        public String getCountry() {
            return country;
        }

        // Method - returns city
        public String getCity() {
            return city;
        }

        // Method - checks if the address entered is empty
        public boolean isEmpty() {
            return streetAndNumber.compareTo("NOADDRESS!") == 0;
        }

        // Method - returns appended address info as a string
        public String toString(){
            return streetAndNumber+", "+postalCode+", "+city+", "+state+", "+country;
        }
    }

    // Class - stores credit card information
    public static class Billing {

        // Stores relevant/current credit card information
        private long cardNumber;
        private String fullName;
        private String expiry;
        private int cvv;

        // Default Constructor - initializes empty credit card information
        public Billing() {
            cardNumber = 0L;
            fullName = "";
            cvv = 0;
        }

        // Constructor - initializes user entered address information
        public Billing(long cardNumber, String fullName, String expiry, int cvv) {
            this.cardNumber = cardNumber;
            this.fullName = fullName;
            this.expiry = expiry;
            this.cvv = cvv;
        }

        // Method - returns credit card number
        public long getCardNumber() {
            return cardNumber;
        }

        // Method - returns name on credit card
        public String getFullName() {
            return fullName;
        }

        // Method - returns credit card expiry date
        public String getExpiry() {
            return expiry;
        }

        // Method - returns credit card CVV
        public int getCvv() {
            return cvv;
        }

        // Method - checks whether credit card has been entered
        public boolean isEmpty() {
            return cardNumber == 0L;
        }

        // Method - returns last 4 digits of credit card number
        public String toString() {
            return "Visa ending in" + (cardNumber % 1000);
        }
    }
}
