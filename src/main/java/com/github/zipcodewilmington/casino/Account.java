package com.github.zipcodewilmington.casino;


import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.*;

import static com.github.zipcodewilmington.casino.ActiveAccount.*;

public class Account {

    //INITIALIZING VARIABLES
    private ActiveAccount aa;
    private Casino casino;
    private String accountName;
    private String password;
    private int balance;
    static Map<String, Account> allAccounts = new HashMap<>();


    //CONSTRUCTORS
    public Account() {
        this.accountName = "";
        this.password = "";
        this.balance = 0;
        allAccounts.put(accountName, this);
    }
    public Account(String acctName, String password, int balance){
        this.accountName = acctName;
        this.password = password;
        this.balance = balance;
        allAccounts.put(accountName, this);
        activeAccounts.add(this);
    }

    //SETTERS
    public void setAccountName(String acctName){this.accountName = acctName;}
    public void setPassword(String password){this.password = password;}
    public void setBalance(int balance){this.balance = balance;}

    //GETTERS
    public String getAccountName(){return this.accountName;}
    public String getPassword(){return this.password;}
    public Integer getBalance(){return this.balance;}

    //METHODS
    public void login(int menuReturn, int numPlayers, int maxPlayers){
        aa = new ActiveAccount();
        casino = new Casino();
        Account tempAccount;
        Scanner scan = new Scanner(System.in);
        String acctName;
        String pw;
        while(true) {
            System.out.println("Please enter your account name, or type \"exit\" to return to main menu.\n");
            acctName = scan.nextLine();
            tempAccount = allAccounts.get(acctName);
            if (accountExists(acctName) && !activeAccounts.contains(tempAccount)) {
                break;
            } else if (accountExists(acctName) && activeAccounts.contains(tempAccount)) {
                System.out.println("That account is already logged in, please log into a different account.\n");
            } else if (acctName.equals("exit")) {
                casino.splashScreen();
            } else if (!accountExists(acctName)) {
                System.out.println("There is no record of an account with that name, please re-enter\n" +
                        "your account name, or return to the main menu and create an account.\n");
            }
        }
        while(true) {
            System.out.println("Please enter your password.\n");
            pw = scan.nextLine();
            if (tempAccount.getPassword().equals(pw)) {
                System.out.println("Password accepted.\n");
                break;
            } else System.out.println("Password does not match account " + acctName + ".\n");
        }
        activeAccounts.add(tempAccount);
        if (menuReturn == 1) {
            aa.activeAccountManager();}
        else {
            aa.checkActiveAccounts(numPlayers, maxPlayers);}
    }



    public int makeBet(Account account){
        int amount;
        while(true) {
           amount = TheScanner.getNumber("");
            if (allAccounts.containsValue(account) && account.balance >= amount) {
                account.balance -= amount;
                break;
            } else if (allAccounts.containsValue(account) && account.balance < amount) {
                System.out.println("\nYou don't have that much in your account.\n" +
                        "Current account balance is: " + account.getBalance() + "Please enter a valid amount.\n");
            }
        }
        return amount;
    }


    public void deposit(Account account, int amount){
        account.balance += amount;
    }
    public void withdraw(Account account, int amount){
        while(true) {
            if (allAccounts.containsValue(account) && account.balance >= amount) {
                account.balance -= amount;
                break;
            } else if (allAccounts.containsValue(account) && account.balance < amount) {
                System.out.println("\nYou don't have that much in your account.\n" +
                        "Current account balance for " + account.getAccountName() + " is: " + account.getBalance() + "Please enter a valid amount.\n");
            }
        }
    }

    public boolean accountExists(String acctName){
            if (allAccounts.containsKey(acctName)) {
                return true;
            } else return false;
        }
    public Account getAccount(String acctName) {
        while(true) {
            if (allAccounts.containsKey(acctName)) {
                return allAccounts.get(acctName);
            } else System.out.println("No account exists with that UserName.");
        }
    }

    public void menuDeposit(){
        String acctName;
        Scanner scan = new Scanner(System.in);
        Account tempAccount = new Account();
        System.out.println("Type in the name of the account you would like to make a deposit in.\n");
        acctName = scan.nextLine();
        tempAccount = getAccount(acctName);
        System.out.println("Current balance of " + acctName + " is " + tempAccount.getBalance() + ".\n" +
                "How much would you like to deposit?");
        int amount = TheScanner.getNumber("");
        deposit(tempAccount, amount);
        System.out.println("New balance of " + acctName + " is " + tempAccount.getBalance() + ".\n");

    }

    public void checkBalance(){
        String acctName;
        Scanner scan = new Scanner(System.in);
        Account tempAccount = new Account();
        System.out.println("Type in the name of the account you would like to check the balance of.\n");
        acctName = scan.nextLine();
        tempAccount = getAccount(acctName);
        System.out.println("Current balance of " + acctName + " is " + tempAccount.getBalance() + ".\n");
    }

    public void loginTest(){
        Account tempAccount;
        String acctName;
        String pw;
        while(true) {
            System.out.println("Please enter your account name, or type \"exit\" to return to main menu.\n");
            acctName = "test";
            tempAccount = allAccounts.get(acctName);
            if (accountExists(acctName) && !activeAccounts.contains(tempAccount)) {
                break;
            } else if (accountExists(acctName) && activeAccounts.contains(tempAccount)) {
                System.out.println("That account is already logged in, please log into a different account.\n");
            } else if (acctName.equals("exit")) {
                casino.splashScreen();
            } else if (!accountExists(acctName)) {
                System.out.println("There is no record of an account with that name, please re-enter\n" +
                        "your account name, or return to the main menu and create an account.\n");
            }
        }
        while(true) {
            System.out.println("Please enter your password.\n");
            pw = "test";
            if (tempAccount.getPassword().equals(pw)) {
                System.out.println("Password accepted.\n");
                break;
            } else System.out.println("Password does not match account " + acctName + ".\n");
        }
        activeAccounts.add(tempAccount);
    }
    public int makeBetTest(Account account, int amount){
        while(true) {
            if (allAccounts.containsValue(account) && account.balance >= amount) {
                account.balance -= amount;
                break;
            } else if (allAccounts.containsValue(account) && account.balance < amount) {
                System.out.println("You don't have that much in your account.\n" +
                        "Current account balance is: " + account.getBalance() + "Please enter a valid amount.\n");
            }
        }
        return account.getBalance();
    }
}