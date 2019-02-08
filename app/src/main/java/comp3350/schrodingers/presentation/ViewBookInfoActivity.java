package comp3350.schrodingers.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.FindBook;
import comp3350.schrodingers.Objects.Book;

public class ViewBookInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FindBook bookList = new FindBook();
        List <String> list = bookList.getBookDetails("3");
        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        ListView viewbookList = (ListView) findViewById(R.id.bookDetail);
        ImageView bookImage = (ImageView) findViewById(R.id.bookImage);
        String imageName = bookList.searchBookById("3").getBookName().toLowerCase();

        bookImage.setImageResource(R.drawable.theartofjumping);

        viewbookList.setAdapter(arrayAdapter);
    }

}
