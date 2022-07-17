package com.github.zipcodewilmington.casino.games.cardgames.blackjack;


import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.Scanner;

public class BlackjackMain implements GameInterface {
    BlackjackEngine blackjackEngine;
    ActiveAccount activeAccount;
    boolean gameOn;


    public BlackjackMain() {
        blackjackEngine = new BlackjackEngine();
        activeAccount = new ActiveAccount();
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

//    public static void main(String[] args) {
//        BlackjackMain bm = new BlackjackMain();
//        bm.run();
//    }
    @Override
    public void run() {
        ActiveAccount.activeAccounts.add(new Account("xy", "1", 100));
        ActiveAccount.activeAccounts.add(new Account("gy", "1", 100));
        gameOn = true;
        while(gameOn){
            blackjackEngine.startPrompt();
            int input = TheScanner.getNumber("");
            if(input == 1){
                blackjackEngine.instructionsPrompt();
                activeAccount.numPlayers(6);
                System.out.println(ActiveAccount.activeAccounts.size());
                blackjackEngine.startGame();
                for (BlackjackPlayer blackjackPlayer : blackjackEngine.players) {
                    System.out.println("How much would you like to wager?");
                    blackjackPlayer.placeBet();
                }
                blackjackEngine.printCurrentState();
                if (blackjackEngine.isBlackJack(blackjackEngine.players.get(0))) {
                    System.out.printf("BLACKJACK! Congrats %s%n", blackjackEngine.players.get(0).casinoAccount.getAccountName());
                    blackjackEngine.resetGame();
                    continue;
                }
                int choice = TheScanner.getNumber("1 to hit, 2 to stand\n");
                if (choice == 1) {
                    blackjackEngine.hit(blackjackEngine.players.get(0));
                    blackjackEngine.printCurrentState();
                    boolean bust = blackjackEngine.isBust(blackjackEngine.players.get(0));
                    if (bust) {
                        System.out.println("Sorry you lost");
                    }
                }
                blackjackEngine.resetGame();
            } else if (input == 2) {
                gameOn = false;
            } else {
                System.out.println("Not a valid number.");
            }
        }
    }
}

