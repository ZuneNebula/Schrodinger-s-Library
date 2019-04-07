package comp3350.schrodingers.presentation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.business.AccessBooks;
import comp3350.schrodingers.business.AccessShoppingCart;
import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.business.userExceptions.UserException;
import comp3350.schrodingers.objects.Book;
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

    // Shopping Cart
    AccessShoppingCart accessShoppingCart;

    // Boolean
    boolean missingUsername = false;
    boolean missingEmail = false;
    boolean missingAddress = false;
    boolean missingPostal = false;
    boolean missingCountry = false;
    boolean missingState = false;
    boolean missingCity = false;
    boolean missingCardNo = false;
    boolean missingCardName = false;
    boolean missingCvv = false;
    boolean missingExpiry = false;

    // Method - instantiates views when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout
        setContentView(R.layout.activity_review_purchase);

        // Set toolbar
        Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Set menu title color
        myToolbar.setTitleTextColor(0XFFFFFFFF);

        // Acquire information about user
        userAccess = Services.getUserInfoAccess();
        currUser = userAccess.getUser();

        userAddress = currUser.getAddress();
        userBilling = currUser.getBilling();

        // Display user name
        TextView review_userName = (TextView)findViewById(R.id.review_userName);
        if (currUser.noUserName()){
            review_userName.setText("***Please Enter Username.***");
            missingUsername = true;
        } else {
            userName = currUser.getUserName();
            review_userName.setText(userName);
        }
        review_userName.setTextColor(Color.parseColor("#000000"));

        // Display email
        TextView review_email = (TextView)findViewById(R.id.review_email);
        if (currUser.noEmail()){
            review_email.setText("***Please Enter Username.***");
            missingEmail = true;
        } else {
            email = currUser.getEmail();
            review_email.setText(email);
        }
        review_email.setTextColor(Color.parseColor("#000000"));

        // Display address
        TextView review_address = (TextView)findViewById(R.id.review_address);
        if (userAddress.noAddr()){
            review_address.setText("***Please Enter Address.***");
            missingAddress = true;
        } else {
            address = userAddress.getAddress();
            review_address.setText(address);
        }
        review_address.setTextColor(Color.parseColor("#000000"));

        // Display postal code
        TextView review_postalCode = (TextView)findViewById(R.id.review_postalCode);
        if (userAddress.noPostal()){
            review_postalCode.setText("***Please Enter Postal Code.***");
            missingPostal = true;
        } else {
            postalCode = userAddress.getPostalCode();
            review_postalCode.setText(postalCode);
        }
        review_postalCode.setTextColor(Color.parseColor("#000000"));

        // Display country
        TextView review_country = (TextView)findViewById(R.id.review_country);
        if (userAddress.noCountry()){
            review_country.setText("***Please Enter Country.***");
            missingCountry = true;
        } else {
            country = userAddress.getCountry();
            review_country.setText(country);
        }
        review_country.setTextColor(Color.parseColor("#000000"));

        // Display state
        TextView review_state = (TextView)findViewById(R.id.review_state);
        if (userAddress.noState()){
            review_state.setText("***Please Enter State.***");
            missingState = true;
        } else {
            state = userAddress.getState();
            review_state.setText(state);
        }
        review_state.setTextColor(Color.parseColor("#000000"));

        // Display city
        TextView review_city = (TextView)findViewById(R.id.review_city);
        if (userAddress.noCity()){
            review_city.setText("***Please Enter City.***");
            missingCity = true;
        } else {
            city = userAddress.getCity();
            review_city.setText(city);
        }
        review_city.setTextColor(Color.parseColor("#000000"));

        // Display credit card number
        TextView review_cardNo = (TextView)findViewById(R.id.review_creditCard);
        if (userBilling.noCardNo()){
            review_cardNo.setText("***Please Enter Credit Card.***");
            missingCardNo = true;
        } else {
            creditCard = userBilling.getCardNumber();
            review_cardNo.setText(Long.toString(creditCard));
        }
        review_cardNo.setTextColor(Color.parseColor("#000000"));

        // Display credit card name
        TextView review_cardName = (TextView)findViewById(R.id.review_cardName);
        if (userBilling.noCardName()){
            review_cardName.setText("***Please Enter Credit Card.***");
            missingCardName = true;
        } else {
            cardName = userBilling.getFullName();
            review_cardName.setText(cardName);
        }
        review_cardName.setTextColor(Color.parseColor("#000000"));

        // Display credit card cvv
        TextView review_cvv = (TextView)findViewById(R.id.review_cvv);
        if (userBilling.noCvv()){
            review_cvv.setText("***Please Enter CVV.***");
            missingCvv = true;
        } else {
            cvv = userBilling.getCvv();
            review_cvv.setText(Long.toString(cvv));
        }
        review_cvv.setTextColor(Color.parseColor("#000000"));


        // Display credit card expiry
        TextView review_expiry = (TextView)findViewById(R.id.review_expiry);
        if (userBilling.noExpiry()){
            review_expiry.setText("***Please Enter Expiry.***");
            missingExpiry = true;
        } else {
            expiry = userBilling.getExpiry();
            review_expiry.setText(expiry);
        }
        review_expiry.setTextColor(Color.parseColor("#000000"));

        // Acquire buttons
        Button enterAddress = (Button) findViewById(R.id.enterAddress);
        Button enterCredit = (Button) findViewById(R.id.enterCredit);
        Button checkout = (Button) findViewById(R.id.checkout);

        // AT FIRST - hide buttons
        enterAddress.setVisibility(View.INVISIBLE);
        enterCredit.setVisibility(View.INVISIBLE);

        // Display button if missing info
        if(missingUsername || missingEmail || missingAddress || missingPostal || missingCountry || missingState || missingCity) {
            enterAddress.setVisibility(View.VISIBLE);
        }

        // Display button if missing info
        if(missingCardNo || missingCardName || missingCvv || missingExpiry) {
            enterCredit.setVisibility(View.VISIBLE);
        }

        // Acquire parameters passed to program
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            // Display selected book
            int selectedBookID = Integer.parseInt(extras.getString("SELECTED_BOOK"));
            AccessBooks access = Services.getBookAccess();
            List<Book> selectedBook = new ArrayList<Book>();
            selectedBook.add(access.searchBookById(selectedBookID));

            BookAdapter adapter = new BookAdapter(this, R.layout.item, selectedBook);
            ListView bookListView = (ListView)findViewById(R.id.ShoppingCartReview);
            bookListView.setAdapter(adapter);

        } else {

            // Access shopping cart persistence
            accessShoppingCart = Services.getShoppingCartAccess();

            // Display shopping shopping cart
            try {
                List<Book> list = accessShoppingCart.getBooks();
                BookAdapter adapter = new BookAdapter(this, R.layout.item, list);
                ListView bookListView = (ListView)findViewById(R.id.ShoppingCartReview);
                bookListView.setAdapter(adapter);
            }catch(UserException e){
                Messages.warning(this, e.toString());
            }

        }

        // Button listeners
        // Update address info
        enterAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewPurchaseActivity.this, PersonInfo.class);
                startActivity(intent);
            }
        });

        // Update payment info
        enterCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewPurchaseActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });

        // Complete checkout
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewPurchaseActivity.this, OrderCompletedActivity.class);
                startActivity(intent);
            }
        });
    }
}
