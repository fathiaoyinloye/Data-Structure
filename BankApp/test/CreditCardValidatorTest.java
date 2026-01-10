import bankAccount.CreditCardValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardValidatorTest {

    @Test
    public void testThatLengthOCardfNumberIGotten(){
        String cardNumber = "4388576018402626";
        assertEquals(16, CreditCardValidator.getLengthOfCard(cardNumber));
    }

    @Test
    public void testThatDoublingSecondDigitFromRightToLeftIsCalculated(){
        String cardNumber = "4388576018402626";
        assertEquals(37, CreditCardValidator.getTotalOfDoubledSecondDigitFromRightToLeft(cardNumber));

    }
    @Test
    public void testTotalOfOddDigitFromRightToLeftIsCalculated(){
        String cardNumber = "4388576018402626";
        assertEquals(38, CreditCardValidator.getSumOfOddDigitFromRightToLeft(cardNumber));

    }

    @Test
    public void testThatCardIsNotAValidCreditCard(){
        String cardNumber = "4388576018402626";
        assertFalse( CreditCardValidator.isValidCard(cardNumber));
    }
    @Test
    public void testThatCardIsAValidCreditCard(){
        String cardNumber = "4388576018410707";
        assertTrue( CreditCardValidator.isValidCard(cardNumber));
    }
    @Test
    public void testThatLastDigitOfACreditCardCardBeGotten(){
        String numbers = "438857601841070";
        assertEquals(7, CreditCardValidator.getCreditCardCheckDigit(numbers));


    }
    @Test
    public void testThatLastDigitOfACreditCardCardBeGottenTwo(){
        String numbers = "412345678901234";
        assertEquals(9, CreditCardValidator.getCreditCardCheckDigit(numbers));


    }
}
