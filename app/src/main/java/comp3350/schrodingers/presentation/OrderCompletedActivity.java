package comp3350.schrodingers.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import comp3350.schrodingers.R;

public class OrderCompletedActivity extends AppCompatActivity {

    // Method - instantiates views when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout
        setContentView(R.layout.activity_order_completed);

        // Set toolbar
        Toolbar myToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        // Set menu title color
        myToolbar.setTitleTextColor(0XFFFFFFFF);

    }

}
