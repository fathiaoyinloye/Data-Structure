package BankException;

public class InvalidBankException  extends BankAppException{
    public InvalidBankException(){
        super("Bank Name is not registered and does not exist");
    }
}
