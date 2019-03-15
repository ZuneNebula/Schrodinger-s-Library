package comp3350.schrodingers.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.business.UserLogin;
import comp3350.schrodingers.R;

// Class - handles the login page
public class LoginActivity extends AppCompatActivity {

    // Various views used by the page
    private Button Login;
    private EditText Email;
    private EditText Password;
    private TextView Info;

    // Store user DB access
    UserLogin currLogin = new UserLogin();

    // Method - instantiates views when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associate layout
        setContentView(R.layout.activity_user_login);

        // Instantiate views
        Email = findViewById(R.id.edtEmail);
        Password = findViewById(R.id.edtPassword);
        Login = findViewById(R.id.btnLogin);
        Info = findViewById(R.id.edtView);

        // Set onclick listener to the login button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString());

            }
        });

    }

    // Method - validate user info and change to preferences page
    private void validate(String Email, String Password) {

        User logUser = currLogin.checkLogin(Email, Password);
        if (logUser != null) {
            Intent intent = new Intent(LoginActivity.this, LoggedActivity.class);
            startActivity(intent);
        } else {
            Info.setText("Incorrect email or password, try again");
        }

    }

}