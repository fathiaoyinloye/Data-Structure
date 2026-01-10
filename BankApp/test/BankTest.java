
import BankException.InsufficientFundException;
import bankAccount.Account;
import bankAccount.Bank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    Bank fidelityBank;


    @BeforeEach
    void setup() {
        fidelityBank = new Bank("fidelity bank");
    }



    @Test
    public void testThatBankAsNoAccount() {
        Bank fidelityBank = new Bank("fidelity bank");
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
        assertEquals("0001234515", account.getAccountNumber());
        assertEquals(1, fidelityBank.getSize());
    }


    @Test
    public void createAccountX_Deposit5h_balaance5h() {
        assertEquals(0, fidelityBank.getSize());
        Account account = fidelityBank.createAccount("fathia", "1");
        assertNotNull( account.getAccountNumber());
        assertEquals(1, fidelityBank.getSize());
        fidelityBank.deposit("0001234515", 500);
       assertEquals(500, account.getBalance("1"));
    }

    @Test
    public void createAccount_Deposit5h_withdraw3h_balance2h() {
        assertEquals(0, fidelityBank.getSize());
        Account account = fidelityBank.createAccount("fathia", "1");
        assertEquals("0001234515", account.getAccountNumber());
        assertEquals(1, fidelityBank.getSize());
        fidelityBank.deposit("0001234515", 500);
        assertEquals(500, account.getBalance("1"));
        fidelityBank.withdraw("0001234515", 200, "1");
        assertEquals(300, account.getBalance("1"));

    }


        @Test
      public void createAccountXY_XDeposited5h_Xtransfered3htoY_XbalanceIs2h_YbalanceIs3h(){
            assertEquals(0, fidelityBank.getSize());
            Account account = fidelityBank.createAccount("fathia", "1");
            Account account2 = fidelityBank.createAccount("Tobi", "123");
            assertEquals(2, fidelityBank.getSize());
            assertEquals("0001234522", account2.getAccountNumber());
            fidelityBank.deposit("0001234515", 500);
            assertEquals(500, account.getBalance("1"));
            fidelityBank.transfer("0001234515", "0001234522", 300, "1" );
            assertEquals(200, account.getBalance("1"));

        }

    @Test
    public void createAccountXY_XDeposited5h_Xtransfered6htoY_throwsInsufficientFundException_XbalanceIs5h(){
        assertEquals(0, fidelityBank.getSize());
        Account account = fidelityBank.createAccount("fathia", "1");
        Account account2 = fidelityBank.createAccount("Tobi", "123");
        assertEquals(2, fidelityBank.getSize());
        fidelityBank.deposit("0001234515", 500);
        assertEquals(500, account.getBalance("1"));
        assertEquals("0001234522", account2.getAccountNumber());
        assertEquals(500, account.getBalance("1"));
        assertThrows(InsufficientFundException.class, ()-> fidelityBank.transfer("0001234515", "0001234522", 600, "1" ));
        assertEquals(500, account.getBalance("1"));
    }

    @Test
    public void createAccountX_AccountX_bankIssuedXCreditCard(){
        assertEquals(0, fidelityBank.getSize());
        Account account = fidelityBank.createAccount("fathia", "1");
        assertEquals("5135272517384717",fidelityBank.issueCreditCard("master","0001234515" ));

    }
    @Test
    public void createAccountX_AccountX_bankIssuedXCreditCard_createdAccountY_XtreansferUsingCreditCard(){
        assertEquals(0, fidelityBank.getSize());
        Account accountX = fidelityBank.createAccount("fathia", "1");
        assertEquals("5135272517384717",fidelityBank.issueCreditCard("master","0001234515" ));
        Account accountY = fidelityBank.createAccount("Tobi", "123");
        assertEquals("0001234522", accountY.getAccountNumber());
        assertEquals(2, fidelityBank.getSize());
        fidelityBank.deposit("0001234515", 500);
        assertEquals(500, accountX.getBalance("1"));
        fidelityBank.transferWithCreditCard("5135272517384717", "0001234522", 500, "1" ) ;
        assertEquals(0, accountX.getBalance("1"));
        assertEquals(500, accountY.getBalance("123"));


    }
    }


