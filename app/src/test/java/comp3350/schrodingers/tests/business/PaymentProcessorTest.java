package comp3350.schrodingers.tests.business;

import junit.framework.TestCase;

import org.junit.Test;
import static org.junit.Assert.*;
import comp3350.schrodingers.business.PaymentProcessor;

public class PaymentProcessorTest extends TestCase {
    private PaymentProcessor validator;
    private String messageValid;
    private String[] correctVal = {"1234123412341234","11/22","123","JOHN SMITH"};

    public PaymentProcessorTest(String arg0){
        super(arg0);
        validator = new PaymentProcessor();
    }

    @Test
    public void testEmptyCardNumber(){
        System.out.println("\nStarting testPaymentProcessor: empty Card Number");
        messageValid = validator.validateCard("",correctVal[1],correctVal[2],correctVal[3]);
        System.out.println("\n\t"+messageValid+"\n");
        System.out.println("\nFinished testPaymentProcessor: empty Card Number");
    }
    @Test
    public void testShortCardNumber(){
        System.out.println("\nStarting testPaymentProcessor: long Card Number");
        String longNumber = "999999999";
        System.out.println("\tLong card size "+longNumber.length()+":");
        messageValid = validator.validateCard(longNumber,correctVal[1],correctVal[2],correctVal[3]);
        System.out.println("\n\t"+messageValid);
        System.out.println("\nFinished testPaymentProcessor: long Card Number");
    }
    @Test
    public void testEmptyDate(){
        System.out.println("\nStarting testPaymentProcessor: empty Date");
        messageValid = validator.validateCard(correctVal[0],"",correctVal[2],correctVal[3]);
        System.out.println("\n\t"+messageValid+"\n");
        System.out.println("\nFinished testPaymentProcessor: empty Date");
    }
    @Test
    public void testIncorrectFormatDate(){
        System.out.println("\nStarting testPaymentProcessor: incorrect Date format");
        String incDate = "012019";
        System.out.println("\t"+incDate+":");
        messageValid = validator.validateCard(correctVal[0],incDate,correctVal[2],correctVal[3]);
        System.out.println("\n\t"+messageValid);
        incDate = "08/2019";
        System.out.println("\t"+incDate+":");
        messageValid = validator.validateCard(correctVal[0],incDate,correctVal[2],correctVal[3]);
        System.out.println("\n\t"+messageValid);
        incDate = "5/19";
        System.out.println("\t"+incDate+":");
        messageValid = validator.validateCard(correctVal[0],incDate,correctVal[2],correctVal[3]);
        System.out.println("\n\t"+messageValid);
        System.out.println("\nFinished testPaymentProcessor: incorrect Date format");
    }
    @Test
    public void testExpiredDate(){
        System.out.println("\nStarting testPaymentProcessor: expired Date");
        System.out.println("\tSame year, past month:");
        String incDate = "01/19";
        messageValid = validator.validateCard(correctVal[0],incDate,correctVal[2],correctVal[3]);
        System.out.println("\n\t"+messageValid);
        System.out.println("\tPast year:");
        incDate = "01/16";
        messageValid = validator.validateCard(correctVal[0],incDate,correctVal[2],correctVal[3]);
        System.out.println("\n\t"+messageValid);
        System.out.println("\nFinished testPaymentProcessor: expired Date");
    }
    @Test
    public void testSuspiciousDate(){
        System.out.println("\nStarting testPaymentProcessor: suspicious Date");
        String incDate = "01/68";
        messageValid = validator.validateCard(correctVal[0],incDate,correctVal[2],correctVal[3]);
        System.out.println("\n\t"+messageValid);
        System.out.println("\nFinished testPaymentProcessor: suspicious Date");
    }
    @Test
    public void testEmptyCvv(){
        System.out.println("\nStarting testPaymentProcessor: empty CVV");
        messageValid = validator.validateCard(correctVal[0],correctVal[1],"",correctVal[3]);
        System.out.println("\n\t"+messageValid);
        System.out.println("\nFinished testPaymentProcessor: empty CVV");
    }
    @Test
    public void testShortCvv(){
        System.out.println("\nStarting testPaymentProcessor: short CVV");
        String shortCvv = "1";
        messageValid = validator.validateCard(correctVal[0],correctVal[1],shortCvv,correctVal[3]);
        System.out.println("\n\t"+messageValid);
        System.out.println("\nFinished testPaymentProcessor: short CVV");
    }
    @Test
    public void testEmptyName(){
        System.out.println("\nStarting testPaymentProcessor: empty name");
        messageValid = validator.validateCard(correctVal[0],correctVal[1],correctVal[2],"");
        System.out.println("\n\t"+messageValid+"\n");
        System.out.println("\nFinished testPaymentProcessor: empty name");
    }
}
