package comp3350.schrodingers.presentation;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.support.v7.widget.SearchView;
import android.app.SearchManager;
import android.widget.SearchView.OnQueryTextListener;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.Objects.Book;
import comp3350.schrodingers.R;
import comp3350.schrodingers.application.BookAdapter;
import comp3350.schrodingers.business.FindBook;
import comp3350.schrodingers.persistence.BooksPersistence;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
   // SearchView searchView = (SearchView) findViewById(R.id.action_search);
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
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
