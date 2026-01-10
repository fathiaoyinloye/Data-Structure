package bankAccount;

public class CreditCardValidator {
    public static int getLengthOfCard(String cardNumber){
        return cardNumber.length();
    }

    public static int getTotalOfDoubledSecondDigitFromRightToLeft(String cardNumber){
        int total = 0;
        for(int count = cardNumber.length()- 2 ;count >= 0 ; count -=2){
                int doubledNumber = (cardNumber.charAt(count) - '0') * 2;
                if (doubledNumber > 9) doubledNumber = doubledNumber - 9;
                total += doubledNumber;
        }
        return total;
    }
    public static int getSumOfOddDigitFromRightToLeft(String cardNumber){
        int total = 0;
        for(int count = cardNumber.length()- 1 ;count >= 0 ; count -=2){
            total += (cardNumber.charAt(count) - '0');
        }
        return total;
    }

    public static boolean isValidCard(String cardNumber){
        int sum = getSumOfOddDigitFromRightToLeft(cardNumber) + getTotalOfDoubledSecondDigitFromRightToLeft(cardNumber);
        if(sum % 10 == 0) return true;
        return false;
    }

    public static int getCreditCardCheckDigit(String fifteenDigitNumbers){
        int total = doubleNumbersAtOddPosition(fifteenDigitNumbers)  + getSumOfNumbersAtEvenPosition(fifteenDigitNumbers);
        if(total % 10 == 0) return 0;

        return getDifferenceBetweenNumberAndNextTenth(total);
    }
    private static int getDifferenceBetweenNumberAndNextTenth(int number){
        int difference = 0;
         for(int count = 0; count > -1; count++){
        number += 1;
        difference +=1;
        if(number % 10 == 0)break;
    }
    return difference;
    }

    public  static  int doubleNumbersAtOddPosition(String numbers){
        int total = 0;
        for(int count = 0; count < numbers.length() ; count+=2  ){
            int doubledNumber = (numbers.charAt(count) - '0') * 2;
                    if(doubledNumber > 9) doubledNumber = doubledNumber - 9;
            total+= doubledNumber;
        }
        return total;
    }
    public  static  int getSumOfNumbersAtEvenPosition(String numbers){
        int total = 0;
        for(int count = 1; count < numbers.length() ; count+=2  ){
            total+= numbers.charAt(count) - '0';
        }
        return total;
    }
}
