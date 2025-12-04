package BankException;

public class InsufficientFundException extends BankAppException {
    public InsufficientFundException() {
        super("InsufficientFund");
    }
}
