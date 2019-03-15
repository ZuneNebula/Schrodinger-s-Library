package comp3350.schrodingers.presentation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.objects.User;

// Class - handles page for reviewing purchase
public class ReviewPurchaseActivity extends AppCompatActivity {

    // Access user info
    AccessUserInfo userAccess;
    User currUser;
    User.Address userAddress;
    User.Billing userBilling;

    // Personal info
    String userName;
    String email;

    // Address info
    String address;
    String postalCode;
    String country;
    String state;
    String city;

    // Billing info
    long creditCard;
    String cardName;
    int cvv;
    String expiry;

    // Method - instantiates views when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout
        setContentView(R.layout.activity_review_purchase);

        // Set toolbar
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Set menu title color
        myToolbar.setTitleTextColor(0XFFFFFFFF);

        // Acquire information about user
        userAccess = new AccessUserInfo();

        currUser = userAccess.getUser();
        userAddress = currUser.getAddress();
        userBilling = currUser.getBilling();

        userName = currUser.getUserName();
        email = currUser.getEmail();

        address = userAddress.getAddress();
        postalCode = userAddress.getPostalCode();
        country = userAddress.getCountry();
        state = userAddress.getState();
        city = userAddress.getCity();

        creditCard = userBilling.getCardNumber();
        cardName = userBilling.getFullName();
        cvv = userBilling.getCvv();
        expiry = userBilling.getExpiry();

        // Display Review Purchase Details
        displayInfo();
    }

    // Method - display selected books info
    private void displayInfo(){

        TextView review_heading = findViewById(R.id.review_heading);
        review_heading.setText("Review Your Order");
        review_heading.setTextColor(Color.parseColor("#000000"));

        TextView review_userName = findViewById(R.id.review_userName);
        review_userName.setText(userName);

        TextView review_email = findViewById(R.id.review_email);
        review_email.setText(email);

        TextView review_address = findViewById(R.id.review_address);
        review_address.setText(address);

        TextView review_postalCode = findViewById(R.id.review_postalCode);
        review_postalCode.setText(postalCode);

        TextView review_country = findViewById(R.id.review_country);
        review_country.setText(country);

        TextView review_state = findViewById(R.id.review_state);
        review_state.setText(state);

        TextView review_city = findViewById(R.id.review_city);
        review_city.setText(city);

        TextView review_cardNo = findViewById(R.id.review_creditCard);
        review_cardNo.setText(Long.toString(creditCard));

        TextView review_cardName = findViewById(R.id.review_cardName);
        review_cardName.setText(cardName);

        TextView review_cvv = findViewById(R.id.review_cvv);
        review_cvv.setText(Long.toString(creditCard));

        TextView review_expiry = findViewById(R.id.review_expiry);
        review_expiry.setText(cardName);

    }
}
