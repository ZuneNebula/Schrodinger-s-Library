package comp3350.schrodingers.presentation;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import comp3350.schrodingers.business.CardException;
import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessPaymentInfo;

public class PaymentActivity extends AppCompatActivity {

    private AccessPaymentInfo accessCards;
    private Billing card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //cardValidator

        accessCards = new AccessPaymentInfo();
        card = accessCards.getCard();

        if(!card.isEmpty()){
            Billing singleCard = card;
            EditText userBilling = findViewById(R.id.billing);
            EditText expDate = findViewById(R.id.expDate);
            EditText cvv = findViewById(R.id.cvv);
            EditText cardName = findViewById(R.id.cardName);
            userBilling.setText(""+singleCard.getCardNumber());
            expDate.setText(singleCard.getExpiry());
            cvv.setText(""+singleCard.getCvv());
            cardName.setText(singleCard.getFullName());
        }
    }
    public void buttonChangePayment(View v){
        EditText editCardNum = findViewById(R.id.billing);
        EditText editExpDate = findViewById(R.id.expDate);
        EditText editCvv = findViewById(R.id.cvv);
        EditText editCardName = findViewById(R.id.cardName);

        long cn = 0L;
        if(editCardNum.getText().toString().length() != 0)
            cn = Long.parseLong(editCardNum.getText().toString());
        String exp = editExpDate.getText().toString();
        String name = editCardName.getText().toString();
        int cv = 0;
        if(editCvv.getText().toString().length() !=0)
            cv = Integer.parseInt(editCvv.getText().toString());
        Billing newCard = new Billing(cn,name,exp,cv);

        try{
            accessCards.insertCard(newCard);
            Snackbar.make(findViewById(R.id.payment_info), R.string.changes_applied,
                    Snackbar.LENGTH_SHORT).show();
        }catch(CardException c){
            Messages.warning(this, c.toString());
        }
    }
}
