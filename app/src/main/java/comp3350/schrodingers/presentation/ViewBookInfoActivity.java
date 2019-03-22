package comp3350.schrodingers.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessBooks;
import comp3350.schrodingers.business.AccessWishlist;
import comp3350.schrodingers.business.UserException;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.objects.Ratings;

// Class - shows all book information and facilitates options like
// rating, purchasing, or reviewing
public class ViewBookInfoActivity extends AppCompatActivity {

    // Various info displayed when viewing book
    private Button addWishlist;
    private Button viewWishlist;
    private Button rateButton;
    private Button purchaseButton;
    private Button cartButton;
    private RatingBar ratingBar;
    private ListView viewRateList;
    private ArrayAdapter<Ratings> rateAdapter;
    private List<Ratings> ratings;
    private EditText review;

    // Method - instantiates views when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associate layout
        setContentView(R.layout.activity_view_book_info);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Schrodingers Library");

        // Acquire passed parameter (id bookID)
        Intent intent = getIntent();
        String str_id = intent.getStringExtra("id");
        final int int_id = Integer.parseInt(str_id);

        // Instantiate buttons
        addWishlist = (Button) findViewById(R.id.addButton);
        viewWishlist = (Button) findViewById(R.id.viewButton);
        rateButton = (Button)findViewById(R.id.submitRate);
        purchaseButton = (Button) findViewById(R.id.purchaseButton);
        cartButton = (Button) findViewById(R.id.cartButton);


        // Instantiate access to book persistence
        final AccessBooks bookList = new AccessBooks();
        List<String> list = getBookDetails(bookList, int_id);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        // Set book information an dimage
        ListView viewbookList = findViewById(R.id.bookDetail);
        viewbookList.setAdapter(arrayAdapter);

        ImageView bookImage = findViewById(R.id.bookImage);
        String imageName = bookList.searchBookById(int_id).getIconId();

        int iconID = -1;
        try {
            iconID = R.drawable.class.getField(imageName).getInt(null);
        } catch (Exception e) {
            System.out.println("Cannot find drawable");
        }

        bookImage.setImageResource(iconID);

        // Method - on click actions for purchase and add to shopping cart buttons
        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {

                Context homeContext = ViewBookInfoActivity.this;
                Class purchaseBookClass = ReviewPurchaseActivity.class;

                Intent intent = new Intent(homeContext, purchaseBookClass);
                startActivity(intent);

            }

        });


        // Method - on click actions for purchase and add to shopping cart buttons
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Show snackbar/tool tip confirming selection has been added
                Snackbar addedToCart = Snackbar.make(findViewById(R.id.viewBookLayout), R.string.addedToCart, Snackbar.LENGTH_LONG);
                addedToCart.getView().setBackgroundColor(ContextCompat.getColor(ViewBookInfoActivity.this, R.color.colorPrimary));
                addedToCart.show();

            }

        });


        // Ratings Bar
        ratingBar = findViewById(R.id.bookRatingBar);
        viewRateList = findViewById(R.id.ratings);
        ratings = bookList.findRatingsByBook(int_id);
        rateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ratings);
        viewRateList.setAdapter(rateAdapter);

        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    bookList.addRating(int_id, (int) ratingBar.getRating(), review.getText().toString());
                    ratings = bookList.findRatingsByBook(int_id);
                    rateAdapter.add(ratings.get(ratings.size()-1));
                }catch(UserException e){
                    showMessage(e.toString());
                }
            }
        });

        // Review
        review = findViewById(R.id.review);

        // Wishlist
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

               }
            }
        });
    }

    private void showMessage(String e){
        Messages.warning(this, e);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    // Method - acquire details of selected book
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
