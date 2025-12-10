
import bankAccount.Account;
import bankAccount.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    Bank fidelityBank;


    @BeforeEach
    void setup() {
        fidelityBank = new Bank("fidelity");
    }

    @Test
    public void testThatBankAsNoAccount() {
        Bank fidelityBank = new Bank("fidelity");
        assertEquals(0, fidelityBank.getSize());
    }

    @Test
    public void createdAccount_bankHasOneAccount() {
        assertEquals(0, fidelityBank.getSize());
        fidelityBank.createAccount("fathia", "1");
        assertEquals(1, fidelityBank.getSize());
    }

    @Test
    public void createdAccount_BankAccountsHasOneAccount() {
        assertEquals(0, fidelityBank.getSize());
         fidelityBank.createAccount("fathia", "1");
        assertEquals(1, fidelityBank.getSize());

    }


    @Test
    public void createAccount_accountNumberIsKnown() {
        assertEquals(0, fidelityBank.getSize());
        Account account = fidelityBank.createAccount("fathia", "1");
        assertEquals("1", account.getAccountNumber());
        assertEquals(1, fidelityBank.getSize());
    }


    @Test
    public void createAccountX_Deposit5h_balaance5h() {
        assertEquals(0, fidelityBank.getSize());
        Account account = fidelityBank.createAccount("fathia", "1");
        assertEquals("1", account.getAccountNumber());
        assertEquals(1, fidelityBank.getSize());
        fidelityBank.deposit("1", 500);
       assertEquals(500, account.getBalance("1"));
    }

    @Test
    public void createAccount_Deposit5h_withdraw3h_balance2h() {
        assertEquals(0, fidelityBank.getSize());
        Account account = fidelityBank.createAccount("fathia", "1");
        assertEquals("1", account.getAccountNumber());
        assertEquals(1, fidelityBank.getSize());
        fidelityBank.deposit("1", 500);
        assertEquals(500, account.getBalance("1"));
        fidelityBank.withdraw("1", 200, "1");
        assertEquals(300, account.getBalance("1"));

    }


        @Test
      public void createAccountXY_XDeposited5h_Xtransfered3htoY_XbalanceIs2h_YbalanceIs3h(){
            assertEquals(0, fidelityBank.getSize());
            Account account = fidelityBank.createAccount("fathia", "1");
            Account account2 = fidelityBank.createAccount("Tobi", "123");
            assertEquals(2, fidelityBank.getSize());
            fidelityBank.deposit("1", 500);
            assertEquals(500, account.getBalance("1"));
            fidelityBank.transfer("1", "2", 300, "1" );
            assertEquals(200, account.getBalance("1"));




        }






    }


