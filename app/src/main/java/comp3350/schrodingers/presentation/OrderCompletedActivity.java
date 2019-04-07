package comp3350.schrodingers.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

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

        // Acquire buttons
        Button returnHome = (Button) findViewById(R.id.returnHome);

        // Button listeners
        // Update return home
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderCompletedActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

}
