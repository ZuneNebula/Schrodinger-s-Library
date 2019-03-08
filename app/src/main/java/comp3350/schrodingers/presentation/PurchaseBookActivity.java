package comp3350.schrodingers.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.objects.User;

public class PurchaseBookActivity extends AppCompatActivity {

    // Access user info
    AccessUserInfo userAccess = new AccessUserInfo();
    User currUser = userAccess.getUser();
    User.Address userAddress = currUser.getAddress();
    User.Billing userBilling = currUser.getBilling();

    // Get user info
    String userName = currUser.getUserName();
    String email = currUser.getEmail();

    // Get address info
    boolean isEmpty = userAddress.isEmpty();
    if (!isEmpty)
    {
        String address = userAddress.getAddress();
        String postalCode = userAddress.getPostalCode();
        String country = userAddress.getCountry();
        String state = userAddress.getState();
        String city = userAddress.getCity();
    }

    // Get bill info
    long creditCard = userBilling.getCardNumber();
    String cardName = userBilling.getFullName();

    // On activity create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout
        setContentView(R.layout.activity_purchase_books);

        // Set toolbar
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Schrodingers Library");
        myToolbar.setTitleTextColor(0XFFFFFFFF);

        // Display Review Purchase Details
        displayInfo();
    }

    private void displayInfo(){

        TextView review_heading = findViewById(R.id.review_heading);
        review_heading.setText("Review Your Order");

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




    }
}
