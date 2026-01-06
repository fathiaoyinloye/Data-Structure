import bankAccount.Nuban;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NubanTest {
    @Test
    void testThatUbaAsThreeDigitBeginningSerialCode(){
        String actual = Nuban.checkBankThreeDigitCode("Access Bank");
        assertEquals("044", actual);
    }
    @Test
    void testThatNubanLastDigitCanBeCalculated(){

    }
}
