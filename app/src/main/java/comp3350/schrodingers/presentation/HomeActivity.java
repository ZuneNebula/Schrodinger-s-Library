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
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.ListView;
import android.widget.ImageButton;
import android.widget.ScrollView;

import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.FindBook;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    FindBook bookList;
    ListView searchLayout;
    ScrollView browseLayout;
    BookAdapter arrayAdapter;
    List<String> name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Create book list and adapter
        bookList = new FindBook();
        arrayAdapter = new BookAdapter(this, bookList);

        // Image Button (book catalog) Listeners
        createBookCatalogListeners();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);

        // Show search list (and hide browse list) when the search icon is selected
        MenuItem searchIcon = menu.findItem(R.id.action_search);
        browseLayout = findViewById(R.id.ScrollView1);
        searchIcon.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                searchLayout = findViewById(R.id.booklist);
                searchLayout.setAdapter(arrayAdapter);
                browseLayout.setVisibility(ScrollView.INVISIBLE);
                return true;
            }
        });

        // Perform search and update search list
        SearchView searchView = (SearchView)searchIcon.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s)){
                    arrayAdapter.filter("");

                    searchLayout.clearTextFilter();

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
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Book Catalog button listeners
    public void createBookCatalogListeners(){

        // Create image button listeners
        ImageButton mClickButton1 = findViewById(R.id.imageButton1);
        mClickButton1.setOnClickListener(this);
        ImageButton mClickButton2 = findViewById(R.id.imageButton2);
        mClickButton2.setOnClickListener(this);
        ImageButton mClickButton3 = findViewById(R.id.imageButton3);
        mClickButton3.setOnClickListener(this);
        ImageButton mClickButton4 = findViewById(R.id.imageButton4);
        mClickButton4.setOnClickListener(this);
        ImageButton mClickButton5 = findViewById(R.id.imageButton5);
        mClickButton5.setOnClickListener(this);
        ImageButton mClickButton6 = findViewById(R.id.imageButton6);
        mClickButton6.setOnClickListener(this);
        ImageButton mClickButton7 = findViewById(R.id.imageButton7);
        mClickButton7.setOnClickListener(this);
        ImageButton mClickButton8 = findViewById(R.id.imageButton8);
        mClickButton8.setOnClickListener(this);
        ImageButton mClickButton9 = findViewById(R.id.imageButton9);
        mClickButton9.setOnClickListener(this);
        ImageButton mClickButton10 = findViewById(R.id.imageButton10);
        mClickButton10.setOnClickListener(this);
        ImageButton mClickButton11 = findViewById(R.id.imageButton11);
        mClickButton11.setOnClickListener(this);
        ImageButton mClickButton12 = findViewById(R.id.imageButton12);
        mClickButton12.setOnClickListener(this);
        ImageButton mClickButton13 = findViewById(R.id.imageButton13);
        mClickButton13.setOnClickListener(this);
        ImageButton mClickButton14 = findViewById(R.id.imageButton14);
        mClickButton14.setOnClickListener(this);
        ImageButton mClickButton15 = findViewById(R.id.imageButton15);
        mClickButton15.setOnClickListener(this);
        ImageButton mClickButton16 = findViewById(R.id.imageButton16);
        mClickButton16.setOnClickListener(this);
        ImageButton mClickButton17 = findViewById(R.id.imageButton17);
        mClickButton17.setOnClickListener(this);
        ImageButton mClickButton18 = findViewById(R.id.imageButton18);
        mClickButton18.setOnClickListener(this);
        ImageButton mClickButton19 = findViewById(R.id.imageButton19);
        mClickButton19.setOnClickListener(this);
        ImageButton mClickButton20 = findViewById(R.id.imageButton20);
        mClickButton20.setOnClickListener(this);
        ImageButton mClickButton21 = findViewById(R.id.imageButton21);
        mClickButton21.setOnClickListener(this);
    }


    // Book Catalog button handler
    public void onClick(View v) {

        int buttonID = v.getId();
        int bookID = -1;

        // Determine which button was pressed
        switch (v.getId()) {
            case R.id.imageButton1:
                bookID = 1;
                break;
            case R.id.imageButton2:
                bookID = 2;
                break;
            case R.id.imageButton3:
                bookID = 3;
                break;
            case R.id.imageButton4:
                bookID = 4;
                break;
            case R.id.imageButton5:
                bookID = 5;
                break;
            case R.id.imageButton6:
                bookID = 6;
                break;
            case R.id.imageButton7:
                bookID = 1;
                break;
            case R.id.imageButton8:
                bookID = 2;
                break;
            case R.id.imageButton9:
                bookID = 3;
                break;
            case R.id.imageButton10:
                bookID = 4;
                break;
            case R.id.imageButton11:
                bookID = 5;
                break;
            case R.id.imageButton12:
                bookID = 6;
                break;
            case R.id.imageButton13:
                bookID = 1;
                break;
            case R.id.imageButton14:
                bookID = 2;
                break;
            case R.id.imageButton15:
                bookID = 3;
                break;
            case R.id.imageButton16:
                bookID = 4;
                break;
            case R.id.imageButton17:
                bookID = 5;
                break;
            case R.id.imageButton18:
                bookID = 6;
                break;
            case R.id.imageButton19:
                bookID = 1;
                break;
            case R.id.imageButton20:
                bookID = 2;
                break;
            case R.id.imageButton21:
                bookID = 3;
                break;
        }
        
        // Change to appropriate 'View Book Info' activity
        Context homeContext = HomeActivity.this;
        Class viewBookClass = ViewBookInfoActivity.class;

        Intent intent = new Intent(homeContext, viewBookClass);
        intent.putExtra("id", Integer.toString(bookID));
        HomeActivity.this.startActivity(intent);
        
    }
}
