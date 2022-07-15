package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.ArrayList;
import java.util.Scanner;


public class PlayerSetup {
    static Scanner scan = new Scanner(System.in);
    public static ArrayList<Account> activeAccounts = new ArrayList<>();
//    static Map<String, Account> activePlayers = new HashMap<>();

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
        String output = "";
        for (int i = 0 ; i < activeAccounts.size() ; i++) {
            output += "Player " + (i+1) + ": " + activeAccounts.get(i).getAccountName() + "\n";
        }
        if (activeAccounts.size() != 0) {return output;}
        else return ("There are no active players.");
    }

    public static void numPlayers(int maxPlayers) {
        int numPlayers;
        while (true) {
            numPlayers = TheScanner.getNumber("How many players are going to be playing in this game?\n");
            if (numPlayers >= 1 && numPlayers <= maxPlayers) {
                break;
            } else System.out.println("That is not a valid number of players. Please enter a number between 1 and " + maxPlayers + ".");
        }
        for (int i = 0 ; i < numPlayers; i++) {
            Account.login();
        }
    }




    public static void activePlayerManager() {
        showActiveAccounts();
        System.out.println("What would you like to do ?\n" +
                "1) Log in a new account\n" +
                "2) Log out of an active account\n" +
                "3) Log out all active accounts\n" +
                "4) Return to Main Menu\n");
        int choice;
        while(true) {
            choice = TheScanner.getNumber("");
            if (choice >= 1 && choice <= 4) {
                break;
            } else System.out.println("That is not a valid choice, please choose a valid menu choice.\n");
            if (choice == 1) {
                Account.login();
            } else if (choice == 2) {
                System.out.println("Type the Account Name you would like to remove\n");
                String acctName = scan.nextLine();
                PlayerSetup.removeActiveAccount(Account.getAccount(acctName));
            } else if (choice == 3) {
                activeAccounts.clear();
                System.out.println("All players have been logged out.");
            } else if (choice == 4) {
                Casino.splashScreen();
            }
        }
    }
}