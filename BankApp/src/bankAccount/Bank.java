package bankAccount;

import java.util.HashMap;

public class Bank {
    private int noOfBanks = 0;
    private String name;
    private String code;
    private int accountNumber = 1;
    private HashMap<String, Account> accounts = new HashMap<>();

    public Bank(String name){
    Nuban.validateBank(name);
    setCode(Nuban.getBankCode(name));
        this.name = name;
    }
    public int getSize() {
        return accounts.size();
    }
    public Account createAccount(String firstName, String password) {
        Account account = new Account(firstName, password);
        account.setAccountNumber(generateAccountNumber());
        accounts.put(account.getAccountNumber(), account);
        return account;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String generateSerialNumber(){
        if(accountNumber < 10) return "00012345" + accountNumber++;

        return "0001234" + accountNumber++;
    }


    private String generateAccountNumber(){
      String serialNumber =  generateSerialNumber();
        int nubanCheck = Nuban.calNubanLastDigitCode( serialNumber , name);
        return serialNumber + nubanCheck;
    }


    public  Account findAccount(String accountNumber) {return accounts.get(accountNumber);}
    public void deposit(String accountNumber, int amount){
        findAccount(accountNumber).deposit(amount);
    }


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


    public String getName() {
        return name;
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }


}
