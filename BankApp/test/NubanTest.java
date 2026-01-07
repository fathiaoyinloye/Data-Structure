import BankException.InvalidAccountNumberException;
import BankException.InvalidBankException;
import BankException.InvalidSerialNumberException;
import bankAccount.Nuban;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NubanTest {
    @Test
    void testThatUbaAsThreeDigitBeginningSerialCode(){
        String actual = Nuban.getBankCode("Access Bank");
        assertEquals("044", actual);
    }
    @Test
    void testThatNubanLastDigitCanBeCalculated(){
        String serialNumber = "000001457";
        int checkNumber = Nuban.calNubanLastDigitCode(serialNumber, "first bank");
        assertEquals(9, checkNumber );

    }
    @Test
    void testThatNubanLastDigitCanBeCalculatedForFidelityBank(){
        String serialNumber = "615095178";
        int checkNumber = Nuban.calNubanLastDigitCode(serialNumber, "fidelity bank");
        assertEquals(7, checkNumber );

    }

    @Test
    void  testThatNubanLastDigitCanBeCalculatedWhenNoRemainder(){
        String serialNumber = "000000022";
        int checkNumber = Nuban.calNubanLastDigitCode(serialNumber, "first bank");
        assertEquals(0, checkNumber );

    }
    @Test
    void testThatSerialNumberIsNotNineDigit_throwsError(){
        String serialNumber = "0000022";
        assertThrows(InvalidSerialNumberException.class, ()-> Nuban.calNubanLastDigitCode(serialNumber, "first bank"));

    }
    @Test
    void testThatBankIsNotAValidBank_throwsException(){
        assertThrows(InvalidBankException.class, ()-> Nuban.calNubanLastDigitCode("000000022", "ghjk bank"));
    }

    @Test
    void testThatAccountNumberIsValid(){
        String accountNumber = "0000014579";
        assertTrue(Nuban.isValidaNubanCheckNumber(accountNumber, "Access Bank"));
    }

    @Test
    void testThatAccountNumberIsValidForUba(){
        String accountNumber = "2214647471";
        assertTrue(Nuban.isValidaNubanCheckNumber(accountNumber, "uba"));
    }
    @Test
    void testThatAccountNumberIsValidWithNineDigit_ThrowsException(){
        String accountNumber = "22146471";
        assertThrows(InvalidAccountNumberException.class, ()-> Nuban.isValidaNubanCheckNumber(accountNumber, "uba"));

    }
    @Test
    void testThatAccountNumberIsValid_ReturnFalse(){
        String accountNumber = "2214007471";
        assertFalse(Nuban.isValidaNubanCheckNumber(accountNumber, "uba"));
    }
}
