package comp3350.schrodingers.presentation;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessBooks;
import comp3350.schrodingers.objects.Book;

public class ViewBookInfoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Schrodingers Library");

        Intent intent = getIntent();
        String str_id = intent.getStringExtra("id");
        int int_id = Integer.parseInt(str_id);

        AccessBooks bookList = new AccessBooks();
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

        // Purchase Button Listeners
        createButtonListeners();
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
        bookInfo.add("Book Rating : " + book.getRating());
        return bookInfo;
    }

    // Create Button Listeners
    public void createButtonListeners() {

         // Create button listeners
        Button button1 = findViewById(R.id.purchaseButton);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.cartButton);
        button2.setOnClickListener(this);

    }

    public void onClick(View v) {

        // Determine which button was pressed and change to appropriate activity
        switch (v.getId()) {
            case R.id.purchaseButton:

                Context homeContext = ViewBookInfoActivity.this;
                Class purchaseBookClass = PurchaseBookActivity.class;

                Intent intent = new Intent(homeContext, purchaseBookClass);
                //intent.putExtra("id", Integer.toString(bookID));
                startActivity(intent);

                break;

            case R.id.cartButton:
                break;
        }

    }
}
