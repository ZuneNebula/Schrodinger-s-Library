package comp3350.schrodingers.presentation;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessPaymentInfo;
import comp3350.schrodingers.business.PaymentProcessor;

public class PaymentActivity extends AppCompatActivity {

    private AccessPaymentInfo accessCards;
    private List<Billing> cards;
    private PaymentProcessor cardValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        accessCards = new AccessPaymentInfo();
        cards = accessCards.getCards();
        cardValidator = new PaymentProcessor();

        if(cards.size() != 0){
            Billing singleCard = cards.get(0);
            EditText userBilling = (EditText) findViewById(R.id.billing);
            EditText expDate = (EditText) findViewById(R.id.expDate);
            EditText cvv = (EditText) findViewById(R.id.cvv);
            EditText cardName = (EditText) findViewById(R.id.cardName);
            userBilling.setText(""+singleCard.getCardNumber());
            expDate.setText(singleCard.getExpiry());
            cvv.setText(""+singleCard.getCvv());
            cardName.setText(singleCard.getFullName());
        }
    }
    public void buttonChangePayment(View v){
        EditText editCardNum = (EditText)findViewById(R.id.billing);
        EditText editExpDate = (EditText)findViewById(R.id.expDate);
        EditText editCvv = (EditText)findViewById(R.id.cvv);
        EditText editCardName = (EditText)findViewById(R.id.cardName);
        String validate = cardValidator.validateCard(editCardNum.getText().toString(),
                editExpDate.getText().toString(), editCvv.getText().toString(), editCardName.getText().toString());

        if (validate == null) {
            long cn = Long.parseLong(editCardNum.getText().toString());
            String exp = editExpDate.getText().toString();
            String name = editCardName.getText().toString();
            int cv = Integer.parseInt(editCvv.getText().toString());
            Billing newCard = new Billing(cn,name,exp,cv);
            if(cards.size() != 0)
                accessCards.updateCard(newCard);
            else
                accessCards.insertCard(newCard);

            Snackbar.make(findViewById(R.id.payment_info), R.string.changes_applied,
                    Snackbar.LENGTH_SHORT).show();
        }else{
            Messages.warning(this, validate);
        }
    }
}
