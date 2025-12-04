package BankException;

public class InvalidAmountException extends BankAppException {
    public InvalidAmountException() {
        super("Amount must be positive");
    }
}
