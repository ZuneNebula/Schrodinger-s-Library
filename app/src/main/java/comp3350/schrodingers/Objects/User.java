package comp3350.schrodingers.Objects;

import java.util.Date;
public class User {
    public class Address{
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

    public class Billing{
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

    private String name;
    private final String userName;
    private String password;
    boolean isAddress = false;
    boolean isBilling = false;
    private Address address;
    private Billing billing;

    public User(String name, String userName, String password)
    {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {return userName;}

}
