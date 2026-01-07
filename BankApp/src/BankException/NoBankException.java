package BankException;

public class NoBankException extends BankAppException {
    public NoBankException() {
        super("No Bank have been created");
    }
}
