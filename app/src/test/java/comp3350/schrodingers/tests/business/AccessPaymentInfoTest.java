package comp3350.schrodingers.tests.business;
import org.junit.Before;
import org.junit.Test;

import comp3350.schrodingers.business.AccessPaymentInfo;
import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.tests.persistence.PaymentPersistenceStub;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
public class AccessPaymentInfoTest {
    private AccessPaymentInfo accessPayInfo;

    @Before
    public void setUp(){
        accessPayInfo = new AccessPaymentInfo(new PaymentPersistenceStub());
    }

    @Test
    public void testGetUser(){
        final Billing card;
        System.out.println("\nStarting test AccessPaymentInfo");
        card = accessPayInfo.getCard();
        assertNull("\tno cards in DB, should be null", card);
        System.out.println("\nFinished test AccessPaymentInfo");
    }
}
