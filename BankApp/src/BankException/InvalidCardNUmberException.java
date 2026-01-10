package BankException;

public class InvalidCardNUmberException extends BankAppException {
    public InvalidCardNUmberException() {
        super("Card Number Does Not exit");
    }
}
