import BankException.InsufficientFundException;
import BankException.InvalidAmountException;
import bankAccount.Account;
import bankAccount.Bank;

import javax.swing.*;
import java.util.Scanner;

import static java.lang.IO.print;

public class FidelityBankMain {
    static Bank bank = new Bank();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        menuStart();

    }

public static void menuStart(){
        menu();
      String choice =  choice();
      switch(choice){
          case "1" -> createAccount();
          case "2" -> checkAccountBalance();
          case "3" -> withdraw();
          case "4" -> deposit();
          case "5" -> transfer();
          case "6" -> {
              print("Thanks for banking with us");
              System.exit(0);
          }
          default -> {print("Invalid Input");menuStart();}



      }



}



    public static void menu() {
        String mainMenu = """
                1   ->  Create Account
                2   ->  Check Account Balance
                3   ->  Withdraw
                4   ->  Deposit
                5   ->  Transfer
                6   ->  Exit
                """;
        print(mainMenu);

    }


    public static void createAccount(){
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        Account account = bank.createAccount(name,password);
        System.out.println("Account created successfully!");
        System.out.println("Your Account Number is: " + account.getAccountNumber());
        menuStart();

    }
    public static void deposit(){
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();
        bank.deposit(accountNumber, amount);
        System.out.println("Deposited successfully!");
        menuStart();

    }


    public static void withdraw(){
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter your amount to withdraw: ");
        int amount = scanner.nextInt();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        try {bank.withdraw(accountNumber, amount, password);
            print("Withdraw successfully!");
           }
        catch (InsufficientFundException e){
            print(e.getMessage());
        }
        finally { menuStart();}

    }
    public static void checkAccountBalance(){
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        int accountBalance = bank.checkAccountBalance(accountNumber, password);
        print("Your account balance is" + accountBalance);
        menuStart();

    }

    public static void transfer() {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter recipient account number: ");
        String recipientAccountNumber = scanner.nextLine();
        System.out.print("Enter recipient account: ");
        int amount = scanner.nextInt();
        System.out.print("Enter recipient password: ");
        String password = scanner.nextLine();
        try {
            bank.transfer(accountNumber, recipientAccountNumber, amount, password);
            print("Transfer of " + amount + " is successful ");
        } catch (InsufficientFundException e) {
            print(e.getMessage());
        } finally {menuStart();}
    }

    public static void print(String message){
        System.out.println(message);
    }

    public static String choice(){
        System.out.print("Enter your choice from the menu above: ");
       String choice;
        choice = scanner.nextLine();
        return choice;


    }


}
