package BankException;

public class IncorrectPassword extends BankAppException {
    public IncorrectPassword(String message) {
        super(message);
    }
}
