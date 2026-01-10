package bankAccount;

import BankException.BankAppException;

public class InvalidCardTypeException extends BankAppException {
    public InvalidCardTypeException() {
        super("Only Master and Visa Card can be issued");
    }
}
