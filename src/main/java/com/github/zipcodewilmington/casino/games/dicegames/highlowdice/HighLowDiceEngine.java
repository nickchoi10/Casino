package com.github.zipcodewilmington.casino.games.dicegames.highlowdice;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.InputMismatchException;
import java.util.Scanner;


public class HighLowDiceEngine {
    static Scanner scanner = new Scanner(System.in);
    Integer results;
    static IOConsole ioConsole = new IOConsole(AnsiColor.BLUE);
    public static final String ANSI_BLUE = "\u001B[34m";
    private ActiveAccount aa;
    private Account acct;
    int wager;
    boolean isWinner;



    //**********||GAME METHODS||**********//
    public void placeBets() {
        acct = new Account();
        aa = new ActiveAccount();
        System.out.println("How much would you like to wager?\n");
        wager = acct.makeBet(aa.activeAccounts.get(0));
    }
    public Integer checkHighOrLow(int diceResult) {
        int results = 0;
        if (diceResult > 7) {
            results = 1; //High
        } else if (diceResult < 7){
            results = 2; //Low
        } else if (diceResult == 7) {
            results = 3; //7 is middle
        }
        return results;
    }

    public void resultsCheck(int highOrLow){
        if(highOrLow == 1){
            results = 1; //1 is high
            System.out.println("The result is High!!!\n");
        } else if (highOrLow == 2){
            results = 2; //2 is low
            System.out.println("The result is Low!!!\n");
        } else if (highOrLow == 3) {
            results = 3; //3 is seven
            System.out.println("The result is Seven!!!\n");
        }
    }

    public void winOrLose(int playerInput, int highOrLow){
        if (playerInput == highOrLow) {
            System.out.println("You win!!\n");
            isWinner = true;
        } else {
            System.out.println("You lose!!\n");
            isWinner = false;
        }
    }
    public void resolveBets() {
//        if(isWinner == true && results == 3;){
//            acct.deposit(aa.activeAccounts.get(0), (wager*4));
//        }else
        if(isWinner){
            acct.deposit(aa.activeAccounts.get(0), (wager*2));
            System.out.println(aa.activeAccounts.get(0).getAccountName() + " Wins! \n You wagered " + wager + " and won " + (wager*2) + ". That amount has been deposited in your account. \n"+ANSI_BLUE);
            System.out.println("Balance: " + aa.activeAccounts.get(0).getBalance());
        } else if(!isWinner){
            System.out.println(aa.activeAccounts.get(0).getAccountName() + " lost :( \n\n");
            System.out.println("Balance: " + aa.activeAccounts.get(0).getBalance());
        }
    }
    public void slowText(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //**********||PROMPTS||**********//
    public void startPrompt() {
        String d = String.valueOf((Character.toChars(0x0001F3B2)));
        ioConsole.println("Welcome to High Low Dice Game " + d + d +"\n");
        ioConsole.println("Please choose from the following: \n1) Play Game\n2) Quit\n3) Rules\nEnter 1, 2, or 3 \n");
        //System.out.println("Welcome to High Low Dice Game " + d + d +"\n");
        //System.out.println("Please choose from the following: \n1) Play Game\n2) Quit\n3) Rules\nEnter 1, 2, or 3 \n");
    }

    public void instructionsPrompt() {
        System.out.println("Rules!\nThe outcome is considered:\nHigh if the sum of the dice is 8, 9, 10, 11, 12.\nLow if the sum of the dice is 1, 2, 3, 4, 5, 6.\nSeven is the outcome is 7.\n\nPlace your bets on High, Low, or Seven\nPayout is 1-1 for High and Low.\nPayout is 4-1 for Seven.\n");
    }
    public void highLowPrompt(){
        System.out.println("Enter a number: 1) High 2) Low 3) Seven\n");
    }

    //**********||INPUTS||**********//
    public int getInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= 0) {
                    return input;
                }
                throw new IllegalArgumentException("number is negative");
            } catch (IllegalArgumentException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a positive number!");
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }
}
