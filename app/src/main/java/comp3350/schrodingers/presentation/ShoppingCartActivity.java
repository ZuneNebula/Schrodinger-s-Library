package comp3350.schrodingers.presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.List;

import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessShoppingCart;
import comp3350.schrodingers.objects.Book;

// Class - handles presenting shopping cart
public class ShoppingCartActivity extends AppCompatActivity {

    // Store access to persistence
    private AccessShoppingCart accessShoppingCart;

    // Checkout button
    private Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        // Set up tool bar
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(0XFFFFFFFF);

        // Access shoppingcart persistence
        accessShoppingCart = new AccessShoppingCart();

        // Display shopping cart
        List <Book> list = accessShoppingCart.getBooks();
        BookAdapter adapter = new BookAdapter(this, list);
        ListView bookListView = findViewById(R.id.shoppingCart);
        bookListView.setAdapter(adapter);

        // Checkout
        checkout = (Button) findViewById(R.id.ProceedCheckout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context homeContext = ShoppingCartActivity.this;
                Class purchaseBookClass = ReviewPurchaseActivity.class;

                Intent intent = new Intent(homeContext, purchaseBookClass);
                startActivity(intent);

            }

        });

    }

}
