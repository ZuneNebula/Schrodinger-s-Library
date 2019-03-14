package comp3350.schrodingers.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.schrodingers.tests.business.AccessPaymentInfoIT;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessPaymentInfoIT.class
})
public class IntegrationTests {
}
