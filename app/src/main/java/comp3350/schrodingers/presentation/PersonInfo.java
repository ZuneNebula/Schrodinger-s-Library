package comp3350.schrodingers.presentation;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.business.UserBuilder;
import comp3350.schrodingers.business.UserException;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.objects.User.Address;

import comp3350.schrodingers.R;

// Class - page which handles the editing of personal info
public class PersonInfo extends AppCompatActivity {

    // Store user DB access and current user
    private AccessUserInfo userList;
    private User user;
    private UserBuilder userBuilder;

    // Method - instantiates views when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associate layout
        setContentView(R.layout.activity_person_info);

        // Setup toolbar
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Set up toolbar title color
        myToolbar.setTitleTextColor(0XFFFFFFFF);

        // Instantiate access to DB and acquire currently logged user
        userList = new AccessUserInfo();
        user = userList.getUser();

        // Set presented information as stored user info (if user has already entered it)
        if (user != null) {
            EditText userName = findViewById(R.id.username);
            userName.setText(user.getUserName());
            EditText userEmail = findViewById(R.id.email);
            userEmail.setText(user.getEmail());

            if (!user.getAddress().isEmpty()) {
                EditText userAddress = findViewById(R.id.address);
                userAddress.setText(user.getAddress().getAddress());
                EditText userCity = findViewById(R.id.city);
                userCity.setText(user.getAddress().getCity());
                EditText userState = findViewById(R.id.province);
                userState.setText(user.getAddress().getState());
                EditText userZip = findViewById(R.id.zip);
                userZip.setText(user.getAddress().getPostalCode());
                EditText userCountry = findViewById(R.id.country);
                userCountry.setText(user.getAddress().getCountry());
            }
        }
    }

    // Method - insert personal into DB upon button press
    public void buttonInfoUpdate(View v) {
        EditText editName = findViewById(R.id.username);
        EditText editEmail = findViewById(R.id.email);
        EditText editAddress = findViewById(R.id.address);
        EditText editCity = findViewById(R.id.city);
        EditText editState = findViewById(R.id.province);
        EditText editZip = findViewById(R.id.zip);
        EditText editCountry = findViewById(R.id.country);


        Address address = new Address(editAddress.getText().toString(),
                editZip.getText().toString(), editCity.getText().toString(),
                editState.getText().toString(), editCountry.getText().toString());

        userBuilder = new UserBuilder(user);
        User newUser = userBuilder.setEmailAndName(editEmail.getText().toString(), editName.getText().toString());
        newUser = userBuilder.setAddress(address);

        try {
            user = userList.insertUser(newUser);
            Snackbar.make(findViewById(R.id.person_info), R.string.changes_applied,
                    Snackbar.LENGTH_SHORT).show();
            finish();
        } catch (UserException e) {
            Messages.warning(this, e.toString());
        }
    }

}
