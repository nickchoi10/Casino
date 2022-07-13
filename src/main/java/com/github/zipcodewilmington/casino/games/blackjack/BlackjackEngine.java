package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.StandardDeck;

import java.util.Scanner;

public class BlackjackEngine implements GameInterface {
    Scanner scanner = new Scanner((System.in));
    StandardDeck deck = new StandardDeck();
    Blackjack blackjack = new Blackjack();

    //Ensure PlayerInterface is garbage collected upon completing a respective GameInterface
    //After the game ends, the player is deleted.
    //Ensure all implementation of PlayerInterface have reference to a CasinoAccount
    //we are storing the player's info into an account which keeps track of player's money
    //Ensure at least 6 different implementations of GameInterface and a respective PlayerInterface are defined.
    //Each game have


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() { //write my bj game in here.

//        while(true)
//        {
            blackjack.startGame();

//            String playAgain = readLine("Would you like to play again? (Y/N)");
//            if(playAgain.equalsIgnoreCase("N"))
//            {
//                break;
//            }
//        }

//        System.out.println("Thanks for playing!");

    }

}

