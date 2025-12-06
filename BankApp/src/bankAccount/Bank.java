package bankAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int accountNumber = 1;
    private List<Account> accounts = new ArrayList<>();


    public int getSize() {
        return accounts.size();
    }
    public Account createAccount(String firstName, String password) {
        Account account = new Account(firstName, password);
        account.setAccountNumber("" + accountNumber++);
        accounts.add(account);
        return account;

    }
    /*public Account addAccount(Account account) {
        account.setAccountNumber("" + accountNumber++);
        accounts.add(account);
        return account;
    }
*/

    public  Account findAccount(String accountNumber) {return accounts.get(Integer.parseInt(accountNumber) -1);}
    public void deposit(String accountNumber, int amount){
        findAccount(accountNumber).deposit(amount);
    }
//    public void transfer(Account sender, Account receiver, int amount, String password){
//        sender.withdraw(amount, password);
//        receiver.deposit(amount);
//    }

    public void transfer(String senderAccountNumber, String receiverAccountNumber, int amount, String password){findAccount(senderAccountNumber).withdraw(amount, password);
        findAccount(receiverAccountNumber).deposit(amount);

    }
    public void withdraw(String accountNumber, int amount, String password){
        findAccount(accountNumber).withdraw(amount, password);
    }
    public int checkAccountBalance(String accountNumber, String password){
        int accountBalance =  findAccount(accountNumber).getBalance(password);
        return accountBalance;
    }





}
