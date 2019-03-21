package comp3350.schrodingers.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessWishlist;
import comp3350.schrodingers.objects.Book;


public class WishlistActivity extends AppCompatActivity {
    private AccessWishlist accessWishlist;

    @Override
    protected void onCreate(Bundle savedInstanceState){
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_wishlist);
          Toolbar myToolbar = findViewById(R.id.my_toolbar);
          setSupportActionBar(myToolbar);
          getSupportActionBar().setTitle("Schrodingers Library");
          myToolbar.setTitleTextColor(0XFFFFFFFF);

          accessWishlist = new AccessWishlist();
          List <Book> list = accessWishlist.getBooks();
          BookAdapter adapter = new BookAdapter(this, list);
          ListView bookListView = findViewById(R.id.wishList);
          bookListView.setAdapter(adapter);
    }

}
