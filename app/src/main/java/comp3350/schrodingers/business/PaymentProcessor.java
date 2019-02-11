package comp3350.schrodingers.business;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import comp3350.schrodingers.persistence.PaymentProcessorInt;

public class PaymentProcessor implements PaymentProcessorInt {

    public String validateCard(final String number, final String date, final String cvv, final String name){
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
            else{
                String[] checkDate = date.split("/");
                int month = Integer.parseInt(checkDate[0]);
                int year = Integer.parseInt(checkDate[1]) + 2000;
                Calendar cal = Calendar.getInstance();
                if(year < cal.get(Calendar.YEAR) || (year == cal.get(Calendar.YEAR) && month <= cal.get(Calendar.MONTH)) )
                    return "Card expired";
                else if(year > cal.get(Calendar.YEAR) + 20)
                    return "Are you from a far future or past?";
            }
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
