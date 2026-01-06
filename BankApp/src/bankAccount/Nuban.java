package bankAccount;

import BankException.InvalidBankException;
import BankException.InvalidSerialNumberException;

import java.util.HashMap;

public class Nuban {
   final static String[] banksThreeDigitCode = {
        "044","014","023","063","050","040", "011", "214",
        "070","085","058","069","056","082", "076", "084",
        "221","068","232","033","032", "035","057","215"

    };

  final static String[] bank = {
        "access bank", "afribank", "citibank", "diamond bank",
        "ecobank", "equitorial trust bank", "first bank", "fcmb",
        "fidelity bank", "finbank", "gtb", "intercontinental bank",
        "oceanic bank", "bankphb", "skye bank", "springbank",
        "stanbicibtc", "standard chartered bank", "sterling bank", "uba",
        "union bank", "wema bank", "zenith bank", "unity bank"

    };

    static HashMap<String, String>  banksAndCodes = new HashMap<>();

    public static void convertToHashMap(){
        for(int count = 0; count < bank.length; count ++){
            banksAndCodes.put(bank[count], banksThreeDigitCode[count]);

        }

    }
    public static String checkBankThreeDigitCode(String bankName) {
        convertToHashMap();
        String bankCode = banksAndCodes.get(bankName) ;
        if (bankCode == null) throw new InvalidBankException();
        return bankCode;
    }

    public static String convertToLowerCase(String word){
        return word.toLowerCase();
    }


    public static int calNubanLastDigitCode(String serialNumber, String bank){
        validateSerialNumber(serialNumber);
        String codePlusSerialNumber = checkBankThreeDigitCode(bank) + serialNumber;
        int[] numbers = {3, 7, 3};
        int total = 0;
        int counter = 0;
        int digit = 0;
        for(int count = 0; count < codePlusSerialNumber.length(); count++){
            if(counter == 3) counter = 0;
            total += codePlusSerialNumber.charAt(count) - '0' * numbers[counter];
            counter ++;
        }
        total = total % 10;
        if(10 - total == 10) return 0;
        else
            return  10 - total;


    }
  private static void validateSerialNumber(String serialNumber) {
        if (serialNumber.length() != 9) throw new InvalidSerialNumberException();
  }

}
