package bankAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    static int accountNumber = 1;
    private List<Account> accounts = new ArrayList<>();


    public int getSize() {
        return accounts.size();
    }
    public Account addAccount(Account account) {
        account.setAccountNumber("" + accountNumber++);
        accounts.add(account);
        return account;
    }

    public  Account findAccount(int accountNumber) {return accounts.get(accountNumber-1);}
    public void deposit(int accountNumber, int amount){
        findAccount(accountNumber).deposit(amount);
    }
    public void transfer(Account sender, Account receiver, int amount, String password){
        sender.withdraw(amount, password);
        receiver.deposit(amount);
    }



    }
