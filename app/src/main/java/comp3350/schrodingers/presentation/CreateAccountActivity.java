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
import comp3350.schrodingers.business.CreateAccount;

import comp3350.schrodingers.R;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Email;
    private EditText Password;
    private Button Account;

    CreateAccount newAcc = new CreateAccount();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        Username = (EditText) findViewById(R.id.edtName);
        Email = (EditText)findViewById(R.id.edtEmail);
        Password = (EditText)findViewById(R.id.edtPassword);
        Account = (Button) findViewById(R.id.btnAccount);


        Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Username!=null && Password!=null && Email!=null) // add more test cases later
                validate(Username.getText().toString(), Email.getText().toString(), Password.getText().toString());

            }
        });

    }

    private void validate(String Username, String Email, String Password){

        User newUser = newAcc.insertUser(Username,Email,Password);
        if (newUser!=null)
        {
            Intent intent = new Intent(CreateAccountActivity.this, LoggedActivity.class);
            startActivity(intent);
        }

    }

}