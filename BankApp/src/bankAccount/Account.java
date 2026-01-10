package bankAccount;

import BankException.IncorrectPassword;
import BankException.InsufficientFundException;
import BankException.InvalidAmountException;
import BankException.InvalidMethodOfPaymentException;

public class Account {

    private int accountBalance;
    private String password;
    private String accountNumber;
    private String name;
    private String bvn;
    private boolean gotACard;
    private String cardNumber;

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(String firstName, String password) {
        this.name = firstName;
        this.password = password;


    }

    public int getBalance(String password) {
        validate(password);
        return  accountBalance;
    }
    public int deposit(int amount) {
        validate(amount);
        accountBalance += amount;
        return accountBalance;
    }


    private void validate(int amount) {
        if (amount < 0) {throw new InvalidAmountException();}
    }
    public void withdraw(int amount, String password) {
        withdrawalValidation(amount);
        accountBalance -= amount;
    }
    private void withdrawalValidation(int amount) {
        if(amount > accountBalance) throw new InsufficientFundException();
    }
    private void validate(String password) {
        if(!this.password.equals(password)) {throw new IncorrectPassword("Incorrect password");}

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isGotACard() {
        return gotACard;
    }

    public void setGotACard(boolean gotACard) {
        this.gotACard = gotACard;
    }
}
