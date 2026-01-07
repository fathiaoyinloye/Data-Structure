package bankAccount;

import BankException.InvalidBankException;
import BankException.NoBankException;

import java.util.ArrayList;

public class CBN {
    private static CBN cbn;
    private ArrayList <Bank> banks = new ArrayList<>();


    private CBN(){}

    public static CBN getCBN(){
        if(cbn == null) cbn = new CBN();
        return cbn;
    }

    public void deleteAllCBNData(){ banks.clear();}
    public ArrayList <Bank> getBanks() {
        return banks;
    }

    public Bank addBank(String bankName){
        Bank bank = new Bank(bankName);
        banks.add(bank);
        return bank;
    }
    public void interBankTransfer(String receiverBankName, String senderBankName, String receiverAccountNumber, int amount, String password, Account senderaccount) {
       withdrawFromSenderAccount();
       depositToReceiverAccount();


}
public void interBankTransfer(Account  receiverAccount, Account senderAccount, int amount){
        receiverAccount.deposit(amount);
}

private void withdrawFromSenderAccount(String senderAccountNumber, String senderBankName, int amount, String password){
    Bank senderBank = findBank(senderBankName);
    senderBank.withdraw(senderAccountNumber, amount, password);
}
private void depositToReceiverAccount(String receiverAccountNumber, String receiverBankName, int amount){
    Bank receiverBank = findBank(receiverBankName);
    receiverBank.deposit(receiverAccountNumber, amount);
}
private Bank findBank(String bankName){
        if (banks.isEmpty()) throw new NoBankException();
        for(Bank bank: banks){
            if (bank.getName().equals(bankName))return bank;
        }
        throw  new InvalidBankException();
    }

    public int getBankSize(){
        return banks.size();
    }

}