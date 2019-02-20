package comp3350.schrodingers.business;


import java.util.Collections;
import java.util.List;

import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.business.PaymentProcessor;

public class AccessPaymentInfo {
    private PaymentPersistence payPersistence;
    private List<Billing> cards;
    public AccessPaymentInfo(){
        payPersistence = Services.getPaymentPersistence();
    }

    public List<Billing> getCards(){
        cards = payPersistence.getCards();
        return Collections.unmodifiableList(cards);
    }
    public Billing insertCard(Billing card) throws CardException{
        PaymentProcessor p = new PaymentProcessor();
        p.validateCard(card);
        if(cards.size() == 0)
            return payPersistence.addCreditCard(card);
        else return updateCard(card);
    }
    public void deleteCard(Billing card){
        payPersistence.deleteCreditCard(card);
    }
    public Billing updateCard(Billing card){
        return payPersistence.updateCreditCard(card);
    }


}
