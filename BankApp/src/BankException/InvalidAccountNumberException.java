package BankException;

public class InvalidAccountNumberException extends BankAppException {
    public InvalidAccountNumberException() {
        super("Account number is not correct");
    }
}
