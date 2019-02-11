package comp3350.schrodingers.tests.objects;
import org.junit.Test;
import static org.junit.Assert.*;
import comp3350.schrodingers.Objects.User.Billing;

public class BillingTest {
    @Test
    public void testBilling(){
        Billing bill;
        System.out.println("\nStarting testBilling");

        bill = new Billing(1234123412341234L,"JOHN SMITH","10/20",321);
        assertNotNull(bill);
        assertTrue(1234123412341234L == bill.getCardNumber());
        assertTrue("JOHN SMITH".equals(bill.getFullName()));
        assertTrue("10/20".equals(bill.getExpiry()));
        assertTrue(321 == bill.getCvv());

        System.out.println("Finished testBilling");

    }
}
