package comp3350.schrodingers.tests.persistence;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.persistence.PaymentPersistence;

import java.util.Collections;
import java.util.List;

public class PaymentPersistenceStub implements PaymentPersistence {

    private UsersPersistenceStub userStub;
    private User user;
    private List<Billing> cards;

    public PaymentPersistenceStub(){
        userStub = new UsersPersistenceStub();
        user = userStub.getUser();
        cards = user.getBilling();
    }

    @Override
    public Billing addCreditCard(Billing creditCard){
        cards.add(creditCard);
        return creditCard;
    }

    public List<Billing> getCards(){
        return Collections.unmodifiableList(cards);
    }

    @Override
    public Billing updateCreditCard(Billing creditCard){
        int index = cards.indexOf(creditCard);
        if(index >= 0)
            cards.set(index,creditCard);
        return creditCard;
    }

    @Override
    public void deleteCreditCard(Billing creditCard){
        int index = cards.indexOf(creditCard);
        if(index >= 0)
            cards.remove(index);
    }

}
