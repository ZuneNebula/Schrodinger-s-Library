package comp3350.schrodingers.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessPurchasedBooks;
import comp3350.schrodingers.objects.Book;

public class PurchaseHistoryActivity extends AppCompatActivity {
    private AccessPurchasedBooks accessPurchased;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Schrodingers Library");
        myToolbar.setTitleTextColor(0XFFFFFFFF);

        accessPurchased = new AccessPurchasedBooks();
        List<Book> list = accessPurchased.getBooks();
        BookAdapter adapter = new BookAdapter(this, list);
        ListView bookListView = findViewById(R.id.list_purchased);
        bookListView.setAdapter(adapter);
    }
}
