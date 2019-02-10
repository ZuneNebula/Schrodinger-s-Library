package comp3350.schrodingers.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.FindBook;
import comp3350.schrodingers.Objects.Book;
public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SearchView searchView = (SearchView) findViewById(R.id.action_search);
        FindBook bookList = new FindBook();
        if(searchView != null) {

            List<Book> list = bookList.searchBookByAuthor(searchView.getQuery().toString());

            ArrayAdapter<Book> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            ListView viewbookList = (ListView) findViewById(R.id.searchList);
            //ImageView bookImage = (ImageView) findViewById(R.id.bookImage);
            //String imageName = bookList.searchBookById("3").getBookName().toLowerCase();

            //bookImage.setImageResource(R.drawable.theartofjumping);

            viewbookList.setAdapter(arrayAdapter);
        }
        

    }

}
