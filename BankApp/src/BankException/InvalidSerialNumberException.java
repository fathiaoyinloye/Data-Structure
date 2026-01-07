package BankException;

public class InvalidSerialNumberException extends BankAppException {
    public InvalidSerialNumberException() {
        super("Invalid Serial Number, Serial Number must be 9 digits");
    }
}
