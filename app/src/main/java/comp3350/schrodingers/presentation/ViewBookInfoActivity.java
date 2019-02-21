package comp3350.schrodingers.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessBooks;

public class ViewBookInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        AccessBooks bookList = new AccessBooks();
        List <String> list = bookList.getBookDetails(id);
        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        ListView viewbookList = findViewById(R.id.bookDetail);
        ImageView bookImage = findViewById(R.id.bookImage);
        String imageName = bookList.searchBookById(id).getBookName().toLowerCase();

        bookImage.setImageResource(R.drawable.theartofjumping);

        viewbookList.setAdapter(arrayAdapter);
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

}
