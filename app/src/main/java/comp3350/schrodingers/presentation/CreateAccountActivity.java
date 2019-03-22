package comp3350.schrodingers.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import comp3350.schrodingers.business.UserException;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.business.CreateAccount;

import comp3350.schrodingers.R;

// Class - presents the layout used for account creation
public class CreateAccountActivity extends AppCompatActivity {

    // Various views used in the layout
    private EditText Username;
    private EditText Email;
    private EditText Password;
    private Button Account;

    // Store reference to DB
    CreateAccount newAcc = new CreateAccount();

    // Method - instantiates views when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associate layout
        setContentView(R.layout.activity_create_account);

        // Instantiate views
        Username = findViewById(R.id.edtName);
        Email = findViewById(R.id.edtEmail);
        Password = findViewById(R.id.edtPassword);
        Account = findViewById(R.id.btnAccount);

        // Create on click listener for 'Create Account' button
        Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Username != null && Password != null && Email != null) // add more test cases later
                    validate(Email.getText().toString(), Username.getText().toString(), Password.getText().toString());

            }
        });

    }

    // Method - validate user and login
    private void validate(String Username, String Email, String Password) {
        try {
            User newUser = newAcc.insertUser(Username, Email, Password);
            Intent intent = new Intent(CreateAccountActivity.this, LoggedActivity.class);
            startActivity(intent);
        }catch(UserException e){
            Messages.warning(this, e.toString());
        }

    }

}