package comp3350.schrodingers.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import comp3350.schrodingers.persistence.UsersPersistence;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.application.Services;

import comp3350.schrodingers.R;

public class LoggedActivity extends AppCompatActivity {
    private UsersPersistence userList = Services.getUsersPersistence();
    private User user = userList.getUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        updateGreeting();

    }
    private void updateGreeting(){
        TextView userName = (TextView) findViewById(R.id.greeting);
        userName.setText(user.getUserName());
    }


    public void buttonInformationOnClick(View v){
        Intent personIntent = new Intent(LoggedActivity.this, PersonInfo.class);
        LoggedActivity.this.startActivity(personIntent);
    }
    public void buttonPaymentOnClick(View v){
        Intent payIntent = new Intent(LoggedActivity.this, PaymentActivity.class);
        LoggedActivity.this.startActivity(payIntent);
    }

    @Override
    public void onResume(){
        super.onResume();
        userList = Services.getUsersPersistence();
        user = userList.getUser();
        updateGreeting();
    }

}
