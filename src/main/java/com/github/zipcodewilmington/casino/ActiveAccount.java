package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.ArrayList;
import java.util.Scanner;


public class ActiveAccount {
    private Account acct;
    private Casino casino;
    private ActiveAccount aa;
    Scanner scan = new Scanner(System.in);
    public static ArrayList<Account> activeAccounts = new ArrayList<>();

    public void addActiveAccount(Account account){
        aa = new ActiveAccount();
        if (activeAccounts.contains(account)){
            System.out.println("This player is already logged in, please choose another account.");
        }
        else {activeAccounts.add(account);
            System.out.println("Added " + account.getAccountName() + " as Player" + activeAccounts.size());}
    }

    public void removeActiveAccount(Account account) {
        aa = new ActiveAccount();
        if (activeAccounts.contains(account)){
            activeAccounts.remove(account);
            System.out.println("Removed " + account.getAccountName() + " from active player list.\n" +
                    "Remaining active players:\n");
            showActiveAccounts();
        }
        else {System.out.println("That player is not currently logged in.");}
    }

    public String showActiveAccounts(){
        aa = new ActiveAccount();
        acct = new Account();
        StringBuilder output = new StringBuilder();
        for (int i = 0 ; i < activeAccounts.size() ; i++) {
            output.append("Account ").append(i + 1).append(": ").append(activeAccounts.get(i).getAccountName()).append("\n");
        }
        if (activeAccounts.size() != 0) {
            System.out.println("Logged in accounts:\n" + output);
            return output.toString();
        }
        else return ("There are no logged in accounts!");
    }

    public void numPlayers(int maxPlayers) {
        aa = new ActiveAccount();
        acct = new Account();
        int numPlayers;
        while (true) {
            numPlayers = TheScanner.getNumber("How many players are going to be playing in this game?\n");
            if (numPlayers >= 1 && numPlayers <= maxPlayers) {
                break;
            } else System.out.println("That is not a valid number of players. Please enter a number between 1 and " + maxPlayers + ".");
        }
        checkActiveAccounts(numPlayers, maxPlayers);
    }

    public void checkActiveAccounts(int numPlayers, int maxPlayers) {
        aa = new ActiveAccount();
        acct = new Account();
        if (numPlayers == activeAccounts.size()) {
            aa.showActiveAccounts();
        } else if (numPlayers > activeAccounts.size()) {
            System.out.println("Not enough active players, please add another account.");
            acct.login(2, numPlayers, maxPlayers);
            checkActiveAccounts(numPlayers, maxPlayers);
        } else {
            System.out.println("You have too many active players, please choose which accounts you would like to use for this game.\n");
            ArrayList<Account> tempArray = new ArrayList<>();
            for (int i = 0; i <= numPlayers; i++) {
                showActiveAccounts();
                System.out.println("Player " + (i + 1) + ", please pick the number corresponding to the account above.\n");
                int choice = (TheScanner.getNumber("")-1);
                tempArray.add(activeAccounts.get(choice));
                activeAccounts.remove(choice);
                if (tempArray.size() == numPlayers) {break;}
            }
            activeAccounts = tempArray;
            checkActiveAccounts(numPlayers, maxPlayers);
        }
    }

    public void activeAccountManager() {
        aa = new ActiveAccount();
        acct = new Account();
        casino = new Casino();
        showActiveAccounts();
        System.out.println("What would you like to do ?\n" +
                "1) Log in an account\n" +
                "2) Log out of an active account\n" +
                "3) Check Account Balance\n" +
                "4) Deposit Money into an Account\n" +
                "5) Log out all active accounts\n" +
                "6) Return to Main Menu\n");
        int choice;
        while (true) {
            choice = TheScanner.getNumber("");
            if (choice >= 1 && choice <= 6) {
                break;
            } else System.out.println("That is not a valid choice, please choose a valid menu choice.\n");
        }
        if (choice == 1) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            acct.login(1, 1, 1);
        } else if (choice == 2) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Type the Account Name you would like to remove\n");
            String acctName = scan.nextLine();
            aa.removeActiveAccount(acct.getAccount(acctName));
            activeAccountManager();
        } else if (choice == 3) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            acct.checkBalance();
            activeAccountManager();
        } else if (choice == 4) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            acct.menuDeposit();
            activeAccountManager();
        } else if (choice == 5) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            activeAccounts.clear();
            System.out.println("All players have been logged out.");
            activeAccountManager();
        } else if (choice == 6) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            casino.mainMenu();
        }
    }
}