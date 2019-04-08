package comp3350.schrodingers.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.ListView;
import java.util.List;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.business.AccessBooks;

import comp3350.schrodingers.R;

public class RecommendationsActivity extends AppCompatActivity {

    private Spinner Choice;
    private Button select;
    private AccessBooks browser = Services.getBookAccess();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        Choice = (Spinner) findViewById(R.id.spinner_genre);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genres, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Choice.setAdapter(adapter);

        select = (Button)findViewById(R.id.confirmGenre);


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Choice.toString());

            }
        });

       /* Choice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                validate(parent.toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

    }

    private void validate(String Choice) {
        List<Book> recs = browser.searchBookByGenre(Choice,3);

        ArrayAdapter<Book> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recs);

        ListView bookListView = (ListView)findViewById(R.id.recView);
        bookListView.setAdapter(arrayAdapter);

    }

}