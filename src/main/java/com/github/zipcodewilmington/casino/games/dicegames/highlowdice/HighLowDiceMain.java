package com.github.zipcodewilmington.casino.games.dicegames.highlowdice;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.games.dicegames.Dice;

public class HighLowDiceMain {
    static boolean running = true;
    static Dice dice = new Dice();
    static HighLowDiceEngine mainGame = new HighLowDiceEngine();


    public static void main(String[] args){
        playGame();
    }

    public static void playGame() {
        mainGame.startPrompt();

        while (true) {
            int input = mainGame.getInput();
            if(input == 3){
                mainGame.instructionsPrompt();
                playGame();
            } else if (input == 2) {
                running = false;
                Casino.splashScreen();
            } else break;
        }


        while (running) {
            mainGame.placeBets();
            mainGame.highLowPrompt();
            int playerInput = mainGame.getInput(); //take input per player. set player input to 0 for high, 1 for low, 2 for seven
            System.out.println("Rolling Dice... ");
            int toss = dice.tossAndSum(2);
            System.out.println("Roll: " + toss);
            int highOrLow = mainGame.checkHighOrLow(toss);
            mainGame.resultsCheck(highOrLow);
            mainGame.winOrLose(playerInput, highOrLow);
            mainGame.resolveBets();

            System.out.println("Do you want to continue playing?\n1) Continue 2) Quit\n");
            int input = mainGame.getInput();
            if(input == 1){
                continue;
            } else if (input == 2) {
                running = false;
                Casino.splashScreen();
            }
        }
    }
}
