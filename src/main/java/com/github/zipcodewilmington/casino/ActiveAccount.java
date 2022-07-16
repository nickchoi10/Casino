package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.ArrayList;
import java.util.Scanner;


public class ActiveAccount {
    static Scanner scan = new Scanner(System.in);
    public static ArrayList<Account> activeAccounts = new ArrayList<>();

    public static void addActiveAccount(Account account){
        if (activeAccounts.contains(account)){
            System.out.println("This player is already logged in, please choose another account.");
        }
        else {activeAccounts.add(account);
            System.out.println("Added " + account.getAccountName() + " as Player" + activeAccounts.size());}
    }

    public static void removeActiveAccount(Account account) {
        if (activeAccounts.contains(account)){
            activeAccounts.remove(account);
            System.out.println("Removed " + account.getName() + " from active player list.\n" +
                    "Remaining active players:\n");
            showActiveAccounts();
        }
        else {System.out.println("That player is not currently logged in.");}
    }

    public static String showActiveAccounts(){
        StringBuilder output = new StringBuilder();
        for (int i = 0 ; i < activeAccounts.size() ; i++) {
            output.append("Account ").append(i + 1).append(": ").append(activeAccounts.get(i).getAccountName()).append("\n");
        }
        if (activeAccounts.size() != 0) {
            System.out.println(output);
            return output.toString();
        }
        else return ("There are no active players!");
    }

    public static void numPlayers(int maxPlayers) {
        int numPlayers;
        while (true) {
            numPlayers = TheScanner.getNumber("How many players are going to be playing in this game?\n");
            if (numPlayers >= 1 && numPlayers <= maxPlayers) {
                break;
            } else System.out.println("That is not a valid number of players. Please enter a number between 1 and " + maxPlayers + ".");
        }
        checkActiveAccounts(numPlayers, maxPlayers);
    }

    public static void checkActiveAccounts(int numPlayers, int maxPlayers) {
        if (numPlayers == activeAccounts.size()) {
            ActiveAccount.showActiveAccounts();
        } else if (numPlayers > activeAccounts.size()) {
            System.out.println("Not enough active players, please add another account.");
            Account.login(2, numPlayers, maxPlayers);
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

    public static void activeAccountManager() {
        showActiveAccounts();
        System.out.println("What would you like to do ?\n" +
                "1) Log in a new account\n" +
                "2) Log out of an active account\n" +
                "3) Log out all active accounts\n" +
                "4) Return to Main Menu\n");
        int choice;
        while (true) {
            choice = TheScanner.getNumber("");
            if (choice >= 1 && choice <= 4) {
                break;
            } else System.out.println("That is not a valid choice, please choose a valid menu choice.\n");
        }
        if (choice == 1) {
            Account.login(1, 1, 1);
        } else if (choice == 2) {
            System.out.println("Type the Account Name you would like to remove\n");
            String acctName = scan.nextLine();
            ActiveAccount.removeActiveAccount(Account.getAccount(acctName));
            activeAccountManager();
        } else if (choice == 3) {
            activeAccounts.clear();
            System.out.println("All players have been logged out.");
            activeAccountManager();
        } else if (choice == 4) {
            Casino.mainMenu();
        }
    }
}