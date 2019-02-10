package comp3350.schrodingers.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import comp3350.schrodingers.persistence.stubs.UsersPersistenceStub;
import comp3350.schrodingers.Objects.User;

import comp3350.schrodingers.R;

public class PersonInfo extends AppCompatActivity {
    private UsersPersistenceStub userList = new UsersPersistenceStub();
    private User user = userList.getUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        EditText userName = (EditText) findViewById(R.id.username);
        userName.setText(user.getUserName());
        EditText userEmail = (EditText) findViewById(R.id.email);
        userEmail.setText(user.getEmail());
        EditText userAddress = (EditText) findViewById(R.id.address);
        //userAddress.setText(User.getAddress());
        EditText userPhone = (EditText) findViewById(R.id.phone);
        //userPhone.setText(User.getPhone());
    }
}
