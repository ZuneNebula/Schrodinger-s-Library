package comp3350.schrodingers.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.schrodingers.tests.objects.BillingTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BillingTest.class
})
public class AllTests
{

}
