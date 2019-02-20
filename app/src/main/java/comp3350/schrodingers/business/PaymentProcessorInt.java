package comp3350.schrodingers.business;

public interface PaymentProcessorInt {
    String validateCard(final String number, final String date, final String cvv, final String name);
}
