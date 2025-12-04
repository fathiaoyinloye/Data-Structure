import bankAccount.Account;
import bankAccount.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    Bank fidelityBank;
    Account account;


    @BeforeEach
     void setup(){
         fidelityBank = new Bank();
        account = new Account("Fathia Oyinloye", "1234");
    }
    @Test
    public void testThatBankAsNoAccount(){
        Bank fidelityBank = new Bank();
        assertEquals(0, fidelityBank.getSize());
    }
    @Test
    public void testAddAccount_BankAccountsCountIsOne(){
        Account account = new Account("Fathia Oyinloye", "1234");
        fidelityBank.addAccount(account);
        assertEquals(1, fidelityBank.getSize());
    }

    @Test
    public void testThatAccountNumberCanBeChecked(){
        Account account = new Account("Fathia Oyinloye", "1234");
        assertNull(account.getAccountNumber());
        Account savedAccount = fidelityBank.addAccount(account);
        assertNotNull(savedAccount.getAccountNumber());
    }


    @Test
    public void createAccountX_Deposit5h_balaance5h(){
        fidelityBank.addAccount(account);
        assertEquals(0,fidelityBank.findAccount(1).getBalance("1234"));
        fidelityBank.findAccount(1).deposit(500);
        assertEquals(500,fidelityBank.findAccount(1).getBalance("1234"));
    }
    @Test
    public void createAccount_Deposit5h_withdraw3h_balance2h() {
        fidelityBank.addAccount(account);
        assertEquals(0, fidelityBank.findAccount(1).getBalance("1234"));
        fidelityBank.findAccount(1).deposit(500);
        assertEquals(500, fidelityBank.findAccount(1).getBalance("1234"));
        fidelityBank.findAccount(1).withdraw(300, "1234");
        assertEquals(200, fidelityBank.findAccount(1).getBalance("1234"));
    }
        @Test
        public void createAccountXY_XDeposited5h_Xtransfered3htoY_XbalanceIs2h_YbalanceIs3h(){
        fidelityBank.addAccount(account);
        Account accountY = new Account("Fathia Oyinloye", "3412");
        fidelityBank.addAccount(accountY);
        assertEquals(0, fidelityBank.findAccount(1).getBalance("1234"));
        assertEquals(0, fidelityBank.findAccount(2).getBalance("3412"));
        fidelityBank.findAccount(1).deposit(500);
        assertEquals(500, fidelityBank.findAccount(1).getBalance("1234"));
        fidelityBank.transfer(account, accountY, 300, "1234");
        assertEquals(300, fidelityBank.findAccount(2).getBalance("3412"));
        assertEquals(200, fidelityBank.findAccount(1).getBalance("1234"));


        }






    }

