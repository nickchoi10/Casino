package com.github.zipcodewilmington.casino.games.cardgames.blackjack;


import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.PlayerSetup;
import java.util.Scanner;

public class BlackjackMain implements GameInterface {
    Scanner scanner;
    BlackjackEngine blackjackEngine;

    //Ensure PlayerInterface is garbage collected upon completing a respective GameInterface
    //After the game ends, the player is deleted.
    //Ensure all implementation of PlayerInterface have reference to a CasinoAccount
    //we are storing the player's info into an account which keeps track of player's money
    //Ensure at least 6 different implementations of GameInterface and a respective PlayerInterface are defined.


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        PlayerSetup.playerSetup(6);

        while(true){
            blackjackEngine.startPrompt();
            int input = scanner.nextInt();
            if(input == 1){
                blackjackEngine.instructionsPrompt();
            } else if (input == 2) {
                break;
            } else {
                System.out.println("Not a valid number.");
            }
        }
    }
}

