import BankException.IncorrectPassword;
import BankException.InsufficientFundException;
import BankException.InvalidAmountException;
import bankAccount.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    Account account;
    @BeforeEach
    void init() {
        account = new Account("Fathia Oyinloye", "1234");
    }

    @Test
    public void accountIsCreated_balanceIsZero(){
        assertEquals(0, account.getBalance("1234"));
    }
    @Test
    public void Deposit100h_balanceIs100h(){
        assertEquals(0, account.getBalance("1234"));
        account.deposit(100);
        assertEquals(100, account.getBalance("1234"));

    }
    @Test
    public void Deposit100h300h_balanceIs400h(){
        assertEquals(0, account.getBalance("1234"));
        account.deposit(100);
        account.deposit(300);
        assertEquals(400, account.getBalance("1234"));
    }@Test
    public void DepositiveNegativeNumber_throwsInvalidAmountException(){
        assertEquals(0, account.getBalance("1234"));
        assertThrows(InvalidAmountException.class, () -> account.deposit(-100));

    }@Test
    public void Depositive100hDepositNegativeNumber_throwsInvalidAmountException_balanceIs100h(){
        assertEquals(0, account.getBalance("1234"));
        account.deposit(100);
        assertThrows(InvalidAmountException.class, () -> account.deposit(-60));
        assertEquals(100, account.getBalance("1234"));
    }

    @Test
    public void Deposit100h_withdraw20h_balancesIs80h(){
        assertEquals(0, account.getBalance("1234"));
        account.deposit(100);
        assertEquals(100, account.getBalance("1234"));
        account.withdraw(20, "1234");
        assertEquals(80, account.getBalance("1234"));
    }

    @Test
    public void Deposit100h_withdraw200h_throwsInsufficientFundException_balancesIs100h(){
        assertEquals(0, account.getBalance("1234"));
        account.deposit(100);
        assertEquals(100, account.getBalance("1234"));
        assertThrows(InsufficientFundException.class, () -> account.withdraw(200, "1234"));
        assertEquals(100, account.getBalance("1234"));
    }

    @Test
    public void testThatAccountBalanceCannotBeCheckedWithIncorrectPassword(){
        assertThrows(IncorrectPassword.class, () -> account.getBalance("1814"));
    }


}
