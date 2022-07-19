package com.github.zipcodewilmington.casino.games.dicegames.highlowdice;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
import com.github.zipcodewilmington.casino.games.dicegames.Dice;


public class HighLowDiceMain {
    private Casino casino;
    static boolean running = true;
    static Dice dice = new Dice();
    static HighLowDiceEngine mainGame = new HighLowDiceEngine();
    public static final String ANSI_BLUE = "\u001B[34m";
    private ActiveAccount aa;
    private Account acct;



    public void playGame() {
        acct = new Account();
        aa = new ActiveAccount();
        aa.numPlayers(1);
        casino = new Casino();
        mainGame.startPrompt();
        int wager;


        while (true) {

            int input = mainGame.getInput();
            if(input == 3){
                mainGame.instructionsPrompt();
                playGame();
            } else if (input == 2) {
                running = false;
                casino.splashScreen();
            } else break;
        }

        while (running) {

            mainGame.placeBets();
            mainGame.highLowPrompt();
            int playerInput = mainGame.getInput(); //take input per player. set player input to 0 for high, 1 for low, 2 for seven
            System.out.println("Rolling Dice... ");
//            String msg = "";
//            int playerInput = HighLowDiceEngine.ioConsole.getIntegerInput(msg);
            int toss = dice.tossAndSum(2);
            System.out.println("Roll: " + toss);
            int highOrLow = mainGame.checkHighOrLow(toss);
            mainGame.resultsCheck(highOrLow);
            mainGame.winOrLose(playerInput, highOrLow);
            mainGame.resolveBets();

            //acct.deposit(aa.activeAccounts.get(0), (wager*2));


            System.out.println("Do you want to continue playing?\n1) Continue 2) Quit\n"+ANSI_BLUE);
            int input = mainGame.getInput();
            if(input == 1){
                continue;
            } else if (input == 2) {
                running = false;
                casino.splashScreen();
            }
        }
    }
}
