package comp3350.schrodingers.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import comp3350.schrodingers.persistence.stubs.UsersPersistenceStub;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.business.UserLogin;

import comp3350.schrodingers.R;

public class LoginActivity extends AppCompatActivity {

    //private UsersPersistenceStub userList = new UsersPersistenceStub();
    private Button Login;
    private EditText Email;
    private EditText Password;
    private TextView Info;

    UserLogin currLogin = new UserLogin();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        Email = (EditText) findViewById(R.id.edtEmail);
        Password = (EditText) findViewById(R.id.edtPassword);
        Login = (Button) findViewById(R.id.login_button);
        Info = (TextView) findViewById(R.id.edtView);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString());

            }
        });

    }

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