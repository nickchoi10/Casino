package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import com.github.zipcodewilmington.casino.games.cardgames.StandardDeck;

import java.util.*;

public class Blackjack implements GameInterface {


    StandardDeck deck;
    Hand dealerHand;
    List<BlackjackPlayer> players;
    Map<BlackjackPlayer, Integer> playerBets;
    //a map to map the players bet to the players.
    //at the end, pass the pot amount to the BlackjackPlayer method winPot.

    // Blackjack is usually a table of 2-7 players and uses one to 52-card deck.
    // Jack, Queen, King are all 10 points. Ace is one or 11 points.
    // deal one card face up to all players, then deal second card to all players. AKA deal 2 cards to player.
    // dealer receive two card, one face up and one face down.
    // Objective is to get 21 or be as close you can to 21 without going over.
    // Beginning of game players place their bets.
    // "Hit" or "Stand" without being busted (exceeding 21).
    // After each player Hit or Stand, dealer's turn to hit or stand.

    public Blackjack() {
        deck = new StandardDeck();
        dealerHand = new Hand();
        players = new ArrayList<>();
        playerBets = new HashMap<>();
    }


    public void startGame() {

        //initialize the game.
        // How many players.
        // Deal the card to the players.

//        System.out.println("Welcome to Blackjack at Stardust Casino! \n");
//        int numOfPlayers;
//        do {
//            System.out.println("How many people are playing (1-6)?");
//            numOfPlayers = scanner.nextInt();
//        } while (numOfPlayers > 6 || numOfPlayers < 0);
//
//        for (int i = 1; i <= numOfPlayers; i++) {
//            BlackjackPlayer player = new BlackjackPlayer(i);
//            players.add(player); //add player to ArrayList
//        }
//
//        for (BlackjackPlayer blackjackPlayer : players) {
//            blackjackPlayer.addToHand(dealCards());
//            blackjackPlayer.addToHand(dealCards());
//        }

    }

    public void placeBet(int amount) {

    }

    public PlayingCard dealCards() {
        return deck.dealCard();
    }

    public boolean isBlackjack() {
//        for each player if the sum of the value is equal to 21 then true.
//        else false
        return true;
    }

    public void hit(Hand hand) {
        hand.getCards().add(dealCards());
    }

    public void stand() {
        //possibly boolean, not sure yet.
    }

    public boolean isBust() {
//        for each player if the sum of the value is greater to 21 then true.
//        else false
        return true;
    }

    public void dealerTurn() {
        isBlackjack();
        //if dealer's hand is less than 16, he must hit until it is 16 or higher.
        //if greater than 16, then stand.
    }

    public void rewardWinner(int index, int totalWinning) {
        //call player's winPot method with totalWinning.
        players.get(0); //not finish!
        //reward amount is calculated in the engine.
    }

//    boolean playAgain() {
//        return true;
//
//    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

        //run playerSetup().get(account name, balance)

    }



}
