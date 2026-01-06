package BankException;

public class InvalidSerialNumberException extends BankAppException {
    public InvalidSerialNumberException() {
        super("Invalid Serial Number");
    }
}
