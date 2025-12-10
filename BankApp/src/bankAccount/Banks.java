package bankAccount;

import java.util.ArrayList;
import java.util.List;

public class Banks {
    private Bank[] banks = new Bank[1];


    public Bank[] getBanks() {
        return banks;
    }


    public void createBanks() {
        Bank fidelity = new Bank("Fidelity");
        Bank stanbic = new Bank("Stanbic");
        banks[0] = fidelity;
        banks[1] = stanbic;
    }
public void interBankTransfer(String receiverBankName, String senderAccountNumber, String receiverAccountNumber, int amount, String password) {

    //{findAccount(senderAccountNumber).withdraw(amount, password);
      //  findAccount(receiverAccountNumber).deposit(amount);
}

}