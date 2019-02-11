package comp3350.schrodingers.presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.ListView;
import android.widget.ImageButton;
import android.media.AudioManager;

import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.application.BookAdapter;
import comp3350.schrodingers.business.FindBook;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    FindBook bookList ;
    ListView viewbookList;
    BookAdapter arrayAdapter;
    List<String> name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bookList = new FindBook();


        arrayAdapter = new BookAdapter(this, bookList);
        viewbookList = (ListView) findViewById(R.id.booklist);
        //ImageView bookImage = (ImageView) findViewById(R.id.bookImage);
        //String imageName = bookList.searchBookById("3").getBookName().toLowerCase();
        //bookImage.setImageResource(R.drawable.theartofjumping);

        viewbookList.setAdapter(arrayAdapter);

        // Image Button (book catalog) Listeners
        //createImageButtonListeners();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //SEARCH:
        //set action_search
        //see https://www.youtube.com/watch?v=9OWmnYPX1uc&t=147s or https://www.youtube.com/watch?v=sJ-Z9G0SDhc&t=299s

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s)){
                    arrayAdapter.filter("");

                    viewbookList.clearTextFilter();

                }
                else{

                    arrayAdapter.filter(s);

                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_account) {
            Intent loggedIntent = new Intent(HomeActivity.this, LoggedActivity.class);
            HomeActivity.this.startActivity(loggedIntent);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    // Book catalog button listeners
//    public void createImageButtonListeners(){
//
//        // ImageButton Handlers
//        ImageButton mClickButton1 = findViewById(R.id.imageButton1);
//        mClickButton1.setOnClickListener(this);
//        ImageButton mClickButton2 = findViewById(R.id.imageButton2);
//        mClickButton2.setOnClickListener(this);
//        ImageButton mClickButton3 = findViewById(R.id.imageButton3);
//        mClickButton3.setOnClickListener(this);
//        ImageButton mClickButton4 = findViewById(R.id.imageButton4);
//        mClickButton4.setOnClickListener(this);
//        ImageButton mClickButton5 = findViewById(R.id.imageButton5);
//        mClickButton5.setOnClickListener(this);
//        ImageButton mClickButton6 = findViewById(R.id.imageButton6);
//        mClickButton6.setOnClickListener(this);
//        ImageButton mClickButton7 = findViewById(R.id.imageButton7);
//        mClickButton7.setOnClickListener(this);
//        ImageButton mClickButton8 = findViewById(R.id.imageButton8);
//        mClickButton8.setOnClickListener(this);
//        ImageButton mClickButton9 = findViewById(R.id.imageButton9);
//        mClickButton9.setOnClickListener(this);
//        ImageButton mClickButton10 = findViewById(R.id.imageButton10);
//        mClickButton10.setOnClickListener(this);
//        ImageButton mClickButton11 = findViewById(R.id.imageButton11);
//        mClickButton11.setOnClickListener(this);
//        ImageButton mClickButton12 = findViewById(R.id.imageButton12);
//        mClickButton12.setOnClickListener(this);
//        ImageButton mClickButton13 = findViewById(R.id.imageButton13);
//        mClickButton13.setOnClickListener(this);
//        ImageButton mClickButton14 = findViewById(R.id.imageButton14);
//        mClickButton14.setOnClickListener(this);
//        ImageButton mClickButton15 = findViewById(R.id.imageButton15);
//        mClickButton15.setOnClickListener(this);
//        ImageButton mClickButton16 = findViewById(R.id.imageButton16);
//        mClickButton16.setOnClickListener(this);
//        ImageButton mClickButton17 = findViewById(R.id.imageButton17);
//        mClickButton17.setOnClickListener(this);
//        ImageButton mClickButton18 = findViewById(R.id.imageButton18);
//        mClickButton18.setOnClickListener(this);
//        ImageButton mClickButton19 = findViewById(R.id.imageButton19);
//        mClickButton19.setOnClickListener(this);
//        ImageButton mClickButton20 = findViewById(R.id.imageButton20);
//        mClickButton20.setOnClickListener(this);
//        ImageButton mClickButton21 = findViewById(R.id.imageButton21);
//        mClickButton21.setOnClickListener(this);
//    }

    static AudioManager audioManager; // Used for 'tap'/'click' sound

    public void onClick(View v) {
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }
}
