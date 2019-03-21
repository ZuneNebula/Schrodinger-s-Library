package comp3350.schrodingers.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessBooks;
import comp3350.schrodingers.business.AccessWishlist;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.objects.Ratings;
import comp3350.schrodingers.objects.User;

public class ViewBookInfoActivity extends AppCompatActivity {
    private Button addWishlist;
    private Button viewWishlist;
    private TextView textView;
    private Button rateButton;
    private RatingBar ratingBar;
    private ListView viewRateList;
    private ArrayAdapter<Ratings> rateAdapter;
    private List<Ratings> ratings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Schrodingers Library");

        Intent intent = getIntent();
        String str_id = intent.getStringExtra("id");
        final int int_id = Integer.parseInt(str_id);
        addWishlist = (Button) findViewById(R.id.addButton);
        viewWishlist = (Button) findViewById(R.id.viewButton);

        final AccessBooks bookList = new AccessBooks();
        List<String> list = getBookDetails(bookList, int_id);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        ListView viewbookList = findViewById(R.id.bookDetail);
        ImageView bookImage = findViewById(R.id.bookImage);
        String imageName = bookList.searchBookById(int_id).getIconId();

        // Acquire icon/picture and set as relevant picture
        int iconID = -1;
        try {
            iconID = R.drawable.class.getField(imageName).getInt(null);
        } catch (Exception e) {
            System.out.println("Cannot find drawable");
        }

        bookImage.setImageResource(iconID);

        viewbookList.setAdapter(arrayAdapter);

        ratingBar = findViewById(R.id.bookRatingBar);
        rateButton = (Button)findViewById(R.id.submitRate);
        viewRateList = findViewById(R.id.ratings);
        ratings = bookList.findRatingsByBook(int_id);
        rateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ratings);
        viewRateList.setAdapter(rateAdapter);

        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookList.addRating(int_id, (int)ratingBar.getRating());
                ratings = bookList.findRatingsByBook(int_id);
                rateAdapter.add(ratings.get(ratings.size()-1));
            }
        });


        viewWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewWishlist();

            }
        });

        addWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(insertWishlist(bookList.searchBookById(int_id))) {
                   textView = (TextView) findViewById(R.id.wishAdded);
                   textView.setText("Added to Wishlist");
               }
               else{
                   textView = (TextView) findViewById(R.id.wishAdded);
                   textView.setText("Book Has Already Been Added");
               }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
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



    public List<String> getBookDetails(AccessBooks accessBooks, int id) {

        Book book = accessBooks.searchBookById(id);
        List<String> bookInfo = new ArrayList<>();
        bookInfo.add("Book ID : " + book.getBookID());
        bookInfo.add("Book Title : " + book.getBookName());
        bookInfo.add("Book Author : " + book.getAuthor());
        bookInfo.add("Book Price : " + book.getPrice());
        bookInfo.add("Book Genre : " + book.getGenre());
        bookInfo.add("Book Left In Stock : " + book.getBookStock());
        return bookInfo;
    }

    private void viewWishlist() {

            Intent intent = new Intent(ViewBookInfoActivity.this, WishlistActivity.class);
            startActivity(intent);

    }

    private boolean insertWishlist(Book book){
        AccessWishlist wishlist = new AccessWishlist();
        return wishlist.insertBook(book);
    }


}
