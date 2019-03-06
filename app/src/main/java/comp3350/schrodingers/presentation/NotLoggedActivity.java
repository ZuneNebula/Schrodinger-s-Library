package comp3350.schrodingers.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import comp3350.schrodingers.persistence.stubs.UsersPersistenceStub;
import comp3350.schrodingers.objects.User;

import comp3350.schrodingers.R;

public class NotLoggedActivity extends AppCompatActivity {

    private Button Login;
    private Button Account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_logged);

        Login = (Button) findViewById(R.id.login_button);
        Account = (Button) findViewById(R.id.account_button);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotLoggedActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotLoggedActivity.this, CreateAccountActivity.class);
                startActivity(intent);

            }
        });
    }

}