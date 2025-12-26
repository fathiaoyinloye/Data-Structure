package algorithims;

import exception.InvalidInputException;

import java.util.Locale;

public class Cryptography {
    public static boolean isAlpha(String word) {

        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        word = word.toLowerCase();
        for(int count = 0; count < word.length(); count++){
            int alphabetCheck = 0;
            for(int counter = 0; counter < alphabets.length(); counter++){
                alphabetCheck += 1;
                if(word.charAt(count) == alphabets.charAt(counter)) break;
            }
            if(alphabetCheck == 26) return false;
        }
        return true;
    }

    public static boolean isBetweenOneToTwentySix(int number) {
        if(number  > 0 && number < 27) return true;
        return false;
    }

    public static String encrypt(String word, int number) {
       validate(word, number);
        word = word.toLowerCase();
        String decrypt = "";
        char[] alphabets = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n','o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };
        for(int count = 0; count < word.length(); count++){
            for(int counter = 0; counter < alphabets.length; counter++ ){
                int index = counter + number;
                if(index > 25) index = index - 26;
                if(word.charAt(count) == alphabets[counter]) decrypt += alphabets[index];
            }
        }
        return decrypt;
    }

    public static String decrypt(String word, int number) {
        validate(word, number);
        word = word.toLowerCase();
        String decrypt = "";
        char[] alphabets = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n','o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };
        for(int count = 0; count < word.length(); count++){
            for(int counter = 0; counter < alphabets.length; counter++ ){
                int index = counter - number;
                if(index < 0) index = 26 + index;
                if(word.charAt(count) == alphabets[counter]) decrypt += alphabets[index];
            }
        }
        return decrypt;
    }

    public static void validate(String word, int number){
        boolean check = isAlpha(word) && isBetweenOneToTwentySix(number);
        if ( !check) throw  new InvalidInputException();
    }
}
