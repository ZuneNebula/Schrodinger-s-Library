package comp3350.schrodingers.presentation;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import comp3350.schrodingers.R;

public class PaymentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        EditText userBilling = (EditText) findViewById(R.id.billing);
        //userBilling.setText(User.getBilling());
    }
    public void buttonChangePayment(View v){
        EditText editCardNum = (EditText)findViewById(R.id.billing);
        EditText editExpDate = (EditText)findViewById(R.id.expDate);
        EditText editCvv = (EditText)findViewById(R.id.cvv);
        EditText editCardName = (EditText)findViewById(R.id.cardName);
        String validate = validateInfo(editCardNum.getText().toString(),
                editExpDate.getText().toString(), editCvv.getText().toString(), editCardName.getText().toString());
        if (validate == null) {
            System.out.println();
            Snackbar.make(findViewById(R.id.payment_info), R.string.changes_applied,
                    Snackbar.LENGTH_SHORT).show();
        }else{
            Messages.warning(this, validate);
        }
    }

    private String validateInfo(String number, String date, String cvv, String name){
        if(number.length() == 0)
            return "Credit Card Number Required";
        else if(number.length() < 16)
            return "Credit Card Number needs 16 digits";

        if(date.length() == 0)
            return "Date required";
        else{
            String regex = "^(0[1-9]|1[0-2])\\/\\d{2}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(date);
            if(!matcher.matches())
                return "Please write Date in the correct format: \'01/99\'";
        }

        if(cvv.length() == 0)
            return "CVV required";
        else if(cvv.length() < 3)
            return "CVV needs 3 digits";

        if(name.length() == 0)
            return "Name in credit card required";
        return null;
    }
}
