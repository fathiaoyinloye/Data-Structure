package bankAccount;

import BankException.InvalidAccountNumberException;
import BankException.InvalidCardNUmberException;

import java.util.HashMap;
import java.util.Map;

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
        account.setBvn(generateBvn());
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
    private String generateBvn(){
        if(accountNumber < 10) return "4345235678" + accountNumber++;

        return "434523567" + accountNumber++;
    }

    private String generateMasterCard(){
        String fifteenDigit = "5135272517384" + accountNumber;
        if(accountNumber < 10) fifteenDigit = "51352725173847" + accountNumber;
        return fifteenDigit + CreditCardValidator.getCreditCardCheckDigit(fifteenDigit);
    }

    private String generateVisaCard(){
        String fifteenDigit = "4135272517384" + accountNumber;
        if(accountNumber < 10) fifteenDigit = "41352725173847" + accountNumber;
        return fifteenDigit + CreditCardValidator.getCreditCardCheckDigit(fifteenDigit);
    }
    public  Account findAccount(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if(account == null) throw new InvalidAccountNumberException();
        return account;
    }

    private Account findAccountWithCreditCardNumber(String  creditCardNumber){
        for(Map.Entry<String,Account> getAccount:accounts.entrySet()){
            if(getAccount.getValue().getCardNumber().equals(creditCardNumber)) return getAccount.getValue();
        }
        throw new InvalidCardNUmberException();

    }
    public void deposit(String accountNumber, int amount){
        findAccount(accountNumber).deposit(amount);
    }


    public void transfer(String senderAccountNumber, String receiverAccountNumber, int amount, String password){findAccount(senderAccountNumber).withdraw(amount, password);
        findAccount(receiverAccountNumber).deposit(amount);

    }
    public void transferWithCreditCard(String senderCreditCardNumber, String receiverAccountNumber, int amount, String password){findAccountWithCreditCardNumber(senderCreditCardNumber).withdraw(amount, password);
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
    public String issueCreditCard(String creditCardType, String accountNumber){
        Account account = findAccount(accountNumber);
        String cardNumber = "";
        switch (Nuban.convertToLowerCase(creditCardType)){
            case "master card" ->{
                cardNumber = generateMasterCard();
                account.setCardNumber(cardNumber);
                account.setGotACard(true);
                return cardNumber;}
            case "visa card" -> {
                cardNumber = generateVisaCard();
                account.setCardNumber(cardNumber);
                account.setGotACard(true);
                return cardNumber;}
            default -> {
                throw new InvalidCardTypeException();
            }

        }
    }


    public void transferWithCreditCard(){
        //if(!g) throw new InvalidMethodOfPaymentException();
    }




}
