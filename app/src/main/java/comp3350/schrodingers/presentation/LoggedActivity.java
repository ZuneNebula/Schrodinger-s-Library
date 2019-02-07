package comp3350.schrodingers.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import comp3350.schrodingers.Objects.User;
import comp3350.schrodingers.R;

public class LoggedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        final TextView userName = (TextView) findViewById(R.id.username);
        //userName.setText(User.getUserName());
        final TextView userEmail = (TextView) findViewById(R.id.email);
        //userEmail.setText(User.getEmail());
        final TextView userBilling = (TextView) findViewById(R.id.billing);
        //userBilling.setText(User.getBilling());
        final TextView userAddress = (TextView) findViewById(R.id.address);
        //userAddress.setText(User.getAddress());
        final TextView userPhone = (TextView) findViewById(R.id.phone);
        //userPhone.setText(User.getPhone());

    }
}
