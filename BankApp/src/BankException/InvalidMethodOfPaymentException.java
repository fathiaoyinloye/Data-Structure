package BankException;

public class InvalidMethodOfPaymentException extends BankAppException {
    public InvalidMethodOfPaymentException() {
        super("You do not have a card");
    }
}
