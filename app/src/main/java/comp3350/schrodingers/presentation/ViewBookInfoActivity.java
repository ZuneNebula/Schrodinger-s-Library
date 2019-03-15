package comp3350.schrodingers.presentation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
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

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessBooks;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.objects.Ratings;

// Class - handles the page which displays book information upon a user selection
public class ViewBookInfoActivity extends AppCompatActivity implements View.OnClickListener {

    // Method - instantiates views when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associate layout
        setContentView(R.layout.activity_view_book_info);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up menu title
        getSupportActionBar().setTitle("Schrodingers Library");

        // Retrieve id argument passed by calling activity
        Intent intent = getIntent();
        String str_id = intent.getStringExtra("id");
        int int_id = Integer.parseInt(str_id);

        // Access books from DB
        AccessBooks bookList = new AccessBooks();

        // Adapt book info to layout
        List<String> list = getBookDetails(bookList, int_id);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        ListView viewbookList = findViewById(R.id.bookDetail);
        ImageView bookImage = findViewById(R.id.bookImage);
        String imageName = bookList.searchBookById(int_id).getIconId();

        int iconID = -1;
        try {
            iconID = R.drawable.class.getField(imageName).getInt(null);
        } catch (Exception e) {
            System.out.println("Cannot find drawable");
        }

        bookImage.setImageResource(iconID);

        viewbookList.setAdapter(arrayAdapter);

        // Purchase Button Listeners
        createButtonListeners();

        final RatingBar ratingBar = findViewById(R.id.bookRatingBar);
        Button rateButton = findViewById(R.id.submitRate);
        ListView viewRateList = findViewById(R.id.ratings);
        List<Ratings> ratings = bookList.findRatingsByBook(int_id);
        ArrayAdapter<Ratings> rateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ratings);
        viewRateList.setAdapter(rateAdapter);

        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bookList.addRating(ratingBar.getNumStars(), "zune");
            }
        });
    }

    // Method - inflate menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // Method - action bar options
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    // Method - acquire information about selected book
    public List<String> getBookDetails(AccessBooks accessBooks, int id) {

        Book book = accessBooks.searchBookById(id);
        List<String> bookInfo = new ArrayList<>();
        bookInfo.add("Book ID : " + book.getBookID());
        bookInfo.add("Book Title : " + book.getBookName());
        bookInfo.add("Book Author : " + book.getAuthor());
        bookInfo.add("Book Price : " + book.getPrice());
        bookInfo.add("Book Genre : " + book.getGenre());
        bookInfo.add("Book Left In Stock : " + book.getBookStock());
        bookInfo.add("Book Rating : " + book.getRating());
        return bookInfo;
    }

    // Method - create button listeners for purchase and add to shopping cart buttons
    public void createButtonListeners() {

         // Create button listeners
        Button button1 = findViewById(R.id.purchase_book_button);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.shopping_cart_button);
        button2.setOnClickListener(this);

    }

    // Method - on click actions for purchase and add to shopping cart buttons
    public void onClick(View v) {

        // Determine which button was pressed and change to appropriate activity
        switch (v.getId()) {

            // Purchase book
            case R.id.purchase_book_button:

                Context homeContext = ViewBookInfoActivity.this;
                Class purchaseBookClass = ReviewPurchaseActivity.class;

                Intent intent = new Intent(homeContext, purchaseBookClass);
                startActivity(intent);

                break;

            // Add to shopping cart
            case R.id.shopping_cart_button:

                // Show snackbar/tool tip confirming selection has been added
                Snackbar addedToCart = Snackbar.make(findViewById(R.id.viewBookLayout), R.string.added_to_cart, Snackbar.LENGTH_LONG);
                addedToCart.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                addedToCart.show();

                break;
        }

    }
}
