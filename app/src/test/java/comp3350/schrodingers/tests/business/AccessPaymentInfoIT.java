package comp3350.schrodingers.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.business.AccessPaymentInfo;
import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.business.UserBuilder;
import comp3350.schrodingers.business.cardExceptions.CardException;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.persistence.UsersPersistence;
import comp3350.schrodingers.persistence.hsqldb.PaymentPersistenceHSQLDB;
import comp3350.schrodingers.persistence.hsqldb.UsersPersistenceHSQLDB;
import comp3350.schrodingers.tests.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AccessPaymentInfoIT {

    private AccessPaymentInfo accessPay;
    private AccessUserInfo accessUser;
    private Billing card;
    private File tempDB;
    private User user;

    @Before
    public void setup() throws IOException{
        this.tempDB = TestUtils.copyDB();

        final UsersPersistence userPers = new UsersPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        final PaymentPersistence persistence = new PaymentPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessPay =  new AccessPaymentInfo(persistence);
        this.accessUser = new AccessUserInfo(userPers);

        user = accessUser.getUser();
        UserBuilder userBuilder = new UserBuilder(user);
        user = userBuilder.setBilling(card);
        accessUser.updateUser(user);
        card = new Billing(1234123412341234L,"chris","01/25",123);

    }

    @Test
    public void testGetCard(){
        System.out.println("\nStarting AccessPaymentInfoIT: getCard");
        Billing card = accessPay.getCard();
        assertTrue("\tno cards in DB, should be empty", card.isEmpty());
        System.out.println("Finished AccessPaymentInfoIT: getCard");
    }

    @Test
    public void testInsertCard(){
        System.out.println("\nStarting AccessPaymentInfoIT: insertCard");
        try {
            accessPay.insertCard(card, user.getEmail());
            assertEquals("\tcard must be equal", accessPay.getCard(), card);
            System.out.println("Finished AccessPaymentInfoIT: insertCard");
        }catch(CardException c) {
            System.out.println("\t" + c);
        }

    }

    @Test
    public void testUpdateCard(){
        System.out.println("\nStarting AccessPaymentInfoIT: updateCard");
        try {
            accessPay.insertCard(card, user.getEmail());
            Billing editedCard = new Billing(card.getCardNumber(),"zune",card.getExpiry(),card.getCvv());
            accessPay.insertCard(editedCard, user.getEmail());
            assertEquals("\tcard must be equal", accessPay.getCard(), editedCard);
            assertNotEquals("\tcard name must not be equal", accessPay.getCard().getFullName(), card.getFullName());
            System.out.println("Finished AccessPaymentInfoIT: updateCard");
        }catch(CardException c) {
            System.out.println("\t" + c);
        }

    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }


}
