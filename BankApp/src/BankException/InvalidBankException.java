package BankException;

public class InvalidBankException  extends BankAppException{
    public InvalidBankException(){
        super("Invalid bank Inputed");
    }
}
