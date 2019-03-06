package comp3350.schrodingers.business;


import java.util.Collections;
import java.util.List;

import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.business.PaymentProcessor;

public class AccessPaymentInfo {

    private PaymentPersistence payPersistence;
    private Billing card;

    public AccessPaymentInfo(){
        payPersistence = Services.getPaymentPersistence();
    }
    public AccessPaymentInfo(final PaymentPersistence payPers){
        this();
        this.payPersistence = payPers;
    }
    public Billing getCard(){
        card = payPersistence.getCard();
        return card;
    }
    public Billing insertCard(Billing card) throws CardException{
        PaymentProcessor p = new PaymentProcessor();
        p.validateCard(card);
        if(getCard().isEmpty())
            return payPersistence.addCreditCard(card);
        else return updateCard(card);
    }

    public Billing updateCard(Billing card){
        return payPersistence.updateCreditCard(card);
    }


}
