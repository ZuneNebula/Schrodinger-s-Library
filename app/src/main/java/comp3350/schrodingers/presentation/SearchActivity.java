package comp3350.schrodingers.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessBooks;
import comp3350.schrodingers.objects.Book;

// Class - manages presenting the search page
public class SearchActivity extends AppCompatActivity {

    // Method - instantiates views when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associate layout
        setContentView(R.layout.activity_search);
        SearchView searchView = findViewById(R.id.action_search);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize access to book DB
        AccessBooks bookList = new AccessBooks();

        if (searchView != null) {

            List<Book> list = bookList.searchBookByAuthor(searchView.getQuery().toString());
            ArrayAdapter<Book> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

            ListView bookListView = findViewById(R.id.searchList);
            bookListView.setAdapter(arrayAdapter);
        }

    }

}
