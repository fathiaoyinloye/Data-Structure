import algorithims.Cryptography;
import exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CryptographyTest {
    @Test
    public void inputalphabetAndNumbers_testThatAllAreAlphabet_false(){
        assertFalse(Cryptography.isAlpha("yyu2j3"));
    }

    @Test
    public void inputalphabets_testThatAllAreAlphabet_true(){
        assertTrue(Cryptography.isAlpha("ghjklHDs"));
    }
    @Test
    public void input59_numberIsNotBetweenOne_TwentySix_false(){
        assertFalse(Cryptography.isBetweenOneToTwentySix(59));
    }

    @Test
    public void input5_numberIsNotBetweenOne_TwentySix_false(){
        assertTrue(Cryptography.isBetweenOneToTwentySix(5));
    }

    @Test
    public void encrypyt_codedamnAmd3_resultIs_frghgdpq(){
        assertEquals("frghgdpq",  Cryptography.encrypt("codedamn", 3));

    }
    @Test
    public void encrypt_whyAmd4_resultIs_alc(){
        assertEquals("alc",  Cryptography.encrypt("why", 4));

    }
    @Test
    public void encrypyt_lmnAnd4_resultIs_fgh(){
        assertEquals("fgh",  Cryptography.encrypt("lmn", 20));

    }
    @Test
    public void encrypt_COdeDamnAnd3_resultIs_frghgdpq(){
        assertEquals("frghgdpq",  Cryptography.encrypt("COdeDamn", 3));

    }
    @Test
    public void encrypt_COdeDamn56And3_throws_InvalidInputException(){
        assertThrows(InvalidInputException.class, () ->   Cryptography.encrypt("COdeDamn56", 3));

    }
    @Test
    public void encrypt_codedamnAnd36_throws_InvalidInputException(){
        assertThrows(InvalidInputException.class, () ->   Cryptography.encrypt("codedamn", 36));

    }

    @Test
    public void encrypt_COdeDamn56And_1_throws_InvalidInputException(){
        assertThrows(InvalidInputException.class, () ->   Cryptography.encrypt("COdeDamn56", -1));

    }

    @Test
    public void decrypt_frghgdpq_minus1_throws_InvalidInputException(){
        assertThrows(InvalidInputException.class, () ->   Cryptography.decrypt("frghgdpq", -1));

    }

    @Test
    public void decrypt_frghgdpq_3_result_codedamn(){
        assertEquals("codedamn",Cryptography.decrypt("frghgdpq", 3));

    }

    @Test
    public void decrypt_alc3_result_why(){
        assertEquals("why",Cryptography.decrypt("alc", 4));

    }
}
