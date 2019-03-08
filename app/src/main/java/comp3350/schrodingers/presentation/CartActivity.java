package comp3350.schrodingers.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.objects.User;

public class CartActivity extends AppCompatActivity {
    private User user;
    private AccessUserInfo userList;
    private List<String> userbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        userList = new AccessUserInfo();
        user = userList.getUser();


    }
}
