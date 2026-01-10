import BankException.InvalidBankException;
import bankAccount.Account;
import bankAccount.Bank;
import bankAccount.CBN;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CBNTest {
    CBN cbn;

    @BeforeEach
    void setup() {
        cbn = CBN.getCBN();
    }

    @AfterEach
    void teardown(){
        cbn.deleteAllCBNData();
    }
    @Test
    public void testThatCBNIsCreated_cbnHasNoBank(){
        assertEquals(0, cbn.getBankSize());
    }
    @Test
    public void cbnHasNoBank_addedFidelityBank_hasOneBank(){
        assertEquals(0, cbn.getBankSize());
        cbn.addBank("fidelity bank");
        assertEquals(1, cbn.getBankSize());

    }
    @Test
    public void cbnHasNoBank_addedFidelityBank_hasOneBank_addedUba_hasTwoBank(){
        assertEquals(0, cbn.getBankSize());
        cbn.addBank("fidelity bank");
        assertEquals(1, cbn.getBankSize());
        cbn.addBank("uba");
        assertEquals(2, cbn.getBankSize());
    }
    @Test
    public void cbnHasNoBank_addedFidelityBank_throwsInvaxception(){
        assertEquals(0, cbn.getBankSize());
        assertThrows(InvalidBankException.class,()-> cbn.addBank("fty bank"));
        assertEquals(0, cbn.getBankSize());

    }
    @Test
    public void cbnHasNoBank_addedFidelityBank_hasOneBank_fidelityCreatedAccountX(){
        assertEquals(0, cbn.getBankSize());
        Bank fidelty = cbn.addBank("fidelity bank");
        assertEquals(1, cbn.getBankSize());
        fidelty.createAccount("fathia", "1");
        assertEquals(1, fidelty.getAccounts().size());
    }

    @Test
    public void cbnHasNoBank_addedFidelityBank_hasOneBank_fidelityCreatedAccountX_Xdepoited5h(){
        assertEquals(0, cbn.getBankSize());
        Bank fidelty = cbn.addBank("fidelity bank");
        assertEquals(1, cbn.getBankSize());
        Account fathiaAccount = fidelty.createAccount("fathia", "1");
        assertEquals(1, fidelty.getAccounts().size());
        fathiaAccount.deposit(500);
       assertEquals(500, fathiaAccount.getBalance("1"));

    }

    @Test
    public void cbnHasNoBank_addedFidelityBank_addUBA_hasTwoBanks_fidelityCreatedAccountX_deposited5h_UBAcreatedAccountY_Xtreansferred3hToY_bal3H(){
        assertEquals(0, cbn.getBankSize());
        Bank fidelity = cbn.addBank("fidelity bank");
        Bank uba = cbn.addBank("uba");
        assertEquals(2, cbn.getBankSize());
        Account fathiaAccount = fidelity.createAccount("fathia", "1");
        Account omotemmyAccount = uba.createAccount("omotemmy", "2");
        assertEquals(1, fidelity.getAccounts().size());
        fathiaAccount.deposit(500);
        assertEquals(500, fathiaAccount.getBalance("1"));
        cbn.interBankTransfer("uba","fidelity bank", "0001234514", "0001234515", 300, "1");
        assertEquals(200, fathiaAccount.getBalance("1"));
        assertEquals(300, omotemmyAccount.getBalance("2"));

    }

}
