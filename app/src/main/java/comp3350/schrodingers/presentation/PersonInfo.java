package comp3350.schrodingers.presentation;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.objects.User.Address;

import comp3350.schrodingers.R;

public class PersonInfo extends AppCompatActivity {
    private AccessUserInfo userList;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        userList = new AccessUserInfo();
        user = userList.getUser();

        if(user != null) {
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
            EditText userPhone = findViewById(R.id.phone);
            //userPhone.setText(User.getPhone());
        }
    }

    public void buttonInfoUpdate(View v){
        EditText editName = findViewById(R.id.username);
        EditText editEmail = findViewById(R.id.email);
        EditText editAddress = findViewById(R.id.address);
        EditText editCity = findViewById(R.id.city);
        EditText editState = findViewById(R.id.province);
        EditText editZip = findViewById(R.id.zip);
        EditText editCountry = findViewById(R.id.country);
        EditText editPhone = findViewById(R.id.phone);


        Address address = new Address(editAddress.getText().toString(),
                editZip.getText().toString(), editCity.getText().toString(),
                editState.getText().toString(), editCountry.getText().toString());

        User newUser = new User(editEmail.getText().toString(),
                editName.getText().toString(), user.getPassword(), address, user.getBilling());

        try {
            user = userList.insertUser(newUser);
            Snackbar.make(findViewById(R.id.person_info), R.string.changes_applied,
                    Snackbar.LENGTH_SHORT).show();
        }catch(Exception e){
            Messages.warning(this, e.toString());
        }
    }

}
