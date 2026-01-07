package BankException;

public class InvalidAccountNumberException extends BankAppException {
    public InvalidAccountNumberException() {
        super("Account number must be ten digit");
    }
}
